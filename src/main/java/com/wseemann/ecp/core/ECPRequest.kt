package com.wseemann.ecp.core

import com.wseemann.ecp.api.ResponseCallback
import com.wseemann.ecp.logging.Logger.debug
import com.wseemann.ecp.parser.ECPResponseParser
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.withContext
import org.jdom2.JDOMException
import java.io.IOException

internal abstract class ECPRequest<T>(private val url: String) {

    protected fun getUrl(): String {
        return url
    }

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
                val requestManager = RequestManager.getInstance()
                val ecpRequest = requestManager.buildRequest(url = url, method = getMethod())
                val response = requestManager.execute(ecpRequest)
                val responseBody = response?.body

                if (responseBody != null) {
                    val body = responseBody.bytes()
                    debug("ECP request response: " + String(body))
                    return ECPResponse(generateResponseData(body, getParser()))
                } else {
                    return null
                }
            }
        } catch (ex: JDOMException) {
            throw IOException(ex)
        } catch (ex: IOException) {
            throw IOException(ex)
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