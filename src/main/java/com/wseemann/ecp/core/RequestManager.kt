package com.wseemann.ecp.core

import java.util.concurrent.TimeUnit

import okhttp3.OkHttpClient
import okhttp3.HttpUrl.Companion.toHttpUrl
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.Response
import kotlin.collections.LinkedHashMap

internal class RequestManager private constructor() {

    private val requestCache = LinkedHashMap<String, Request>(16, 0.75f, true)

    private val okHttpClient = OkHttpClient.Builder()
        .connectTimeout(6000, TimeUnit.MILLISECONDS)
        .readTimeout(6000, TimeUnit.MILLISECONDS)
        .build()

    internal fun buildRequest(url: String, method: String): Request {
        return requestCache.getOrPut("$url$method") {
            val body = if (method == "POST") "".toRequestBody() else null

            Request.Builder()
                .addHeader("User-Agent", "Roku-ECP-Wrapper-Kotlin")
                .url(url.toHttpUrl())
                .method(method, body)
                .build()
        }
    }

    internal fun execute(request: Request): Response? {
        val call = okHttpClient.newCall(request)
        return call.execute()
    }

    internal companion object {
        // Volatile modifier is necessary to preserve execution order among threads
        @Volatile
        private var instance: RequestManager? = null

        fun getInstance() =
            instance ?: synchronized(this) {
                instance ?: RequestManager().also { instance = it }
            }
    }
}