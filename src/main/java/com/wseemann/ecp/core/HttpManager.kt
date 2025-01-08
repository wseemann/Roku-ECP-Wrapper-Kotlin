package com.wseemann.ecp.core

import java.util.concurrent.TimeUnit

import okhttp3.OkHttpClient
import okhttp3.ConnectionPool
import okhttp3.HttpUrl.Companion.toHttpUrl
import okhttp3.ResponseBody
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody

internal class HttpManager private constructor() {

    private val okHttpClient = OkHttpClient.Builder()
        .connectionPool(ConnectionPool(0, 1, TimeUnit.SECONDS))
        .connectTimeout(2000, TimeUnit.MILLISECONDS)
        .readTimeout(2000, TimeUnit.MILLISECONDS)
        .build()

    private val requestCache = HashMap<String, Request>()

    fun buildRequest(url: String, method: String, useRequestCache: Boolean): Request {
        if (useRequestCache) {
            val request = requestCache[url]
            if (request != null) {
                return request
            }
        }

        val body = if (method == "POST") "".toRequestBody() else null

        val request = Request.Builder()
            .addHeader("User-Agent", "Roku-ECP-Wrapper-Kotlin")
            .url(url.toHttpUrl())
            .method(method, body)
            .build()

        if (useRequestCache) {
            requestCache[url] = request
        }

        return request
    }

    fun execute(request: Request): ResponseBody? {
        val call = okHttpClient.newCall(request)
        val response = call.execute()
        return response.body
    }

    internal companion object {
        // Volatile modifier is necessary to preserve execution order among threads
        @Volatile
        private var instance: HttpManager? = null

        fun getInstance() =
            instance ?: synchronized(this) {
                instance ?: HttpManager().also { instance = it }
            }
    }
}
