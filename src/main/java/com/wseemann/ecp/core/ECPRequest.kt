package com.wseemann.ecp.core

import com.wseemann.ecp.api.ResponseCallback
import com.wseemann.ecp.logging.Logger.debug
import com.wseemann.ecp.parser.ECPResponseParser
import kotlinx.coroutines.*
import okhttp3.HttpUrl.Companion.toHttpUrl
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import org.jdom2.JDOMException
import java.io.IOException
import java.util.concurrent.TimeUnit

internal abstract class ECPRequest<T>(private val url: String) {

    protected abstract fun getMethod(): String

    protected abstract fun getPath(): String

    protected abstract fun getParser(): ECPResponseParser<T>?

    @Throws(IOException::class)
    fun send(): ECPResponse<T>? {
        val url = this.url + getPath()

        try {
            if (getMethod().equals(DISCOVERY, ignoreCase = true)) {
                val request = DiscoveryRequest(url)
                return ECPResponse(generateResponseData(request.send().data, getParser()))
            } else {
                val okHttpClient = OkHttpClient.Builder()
                        .connectTimeout(6000, TimeUnit.MILLISECONDS)
                        .readTimeout(6000, TimeUnit.MILLISECONDS)
                        .build()

                val body = if (getMethod() == "POST") "".toRequestBody() else null

                val request = Request.Builder()
                        .addHeader("User-Agent", "Roku-ECP-Wrapper-Kotlin")
                        .url(url.toHttpUrl())
                        .method(getMethod(), body)
                        .build()

                val call = okHttpClient.newCall(request)
                val response = call.execute()

                val responseBody = response.body

                if (responseBody != null) {
                    val body = responseBody.bytes()
                    debug("ECP request response: " + String(body))
                    return ECPResponse(generateResponseData(body, getParser()))
                } else {
                    return null
                }
            }
        } catch (ex: JDOMException) {
            throw IOException()
        }
    }

    @OptIn(ExperimentalCoroutinesApi::class, DelicateCoroutinesApi::class)
    fun sendAsync(callback: ResponseCallback<T>) {
        CoroutineScope(newSingleThreadContext("")).launch {
            try {
                val response = send()
                withContext(Dispatchers.Default) {
                    callback.onSuccess(response?.responseData)
                }
            } catch (ex: IOException) {
                withContext(Dispatchers.Default) {
                    callback.onError(ex)
                }
            }
        }
    }

    @Throws(IOException::class, JDOMException::class)
    private fun generateResponseData(body: ByteArray, parser: ECPResponseParser<T>?): T? {
        if (parser == null) {
            return null
        }

        return parser.parse(body)
    }

    private companion object {
        private const val DISCOVERY = "DISCOVERY"
    }
}