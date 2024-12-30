package com.wseemann.ecp.core

import java.util.concurrent.TimeUnit

import okhttp3.OkHttpClient
import okhttp3.ConnectionPool
import okhttp3.HttpUrl.Companion.toHttpUrl
import okhttp3.ResponseBody
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody

class HttpManager private constructor() {

    private val okHttpClient = OkHttpClient.Builder()
	.connectionPool(ConnectionPool(20, 1, TimeUnit.SECONDS))
	.connectTimeout(40, TimeUnit.MILLISECONDS)
	.readTimeout(40, TimeUnit.MILLISECONDS)
	.build()

    private val requestCache = HashMap<String, Request>()

    private fun buildRequest(url: String, method: String, useRequestCache: Boolean): Request {
	if (useRequestCache) {
	    val request = requestCache.get(url)
	    if (request != null)
		return request
	}
        val body = if (method == "POST") "".toRequestBody() else null
	val request = Request.Builder()
            .addHeader("User-Agent", "Roku-ECP-Wrapper-Kotlin")
            .url(url.toHttpUrl())
            .method(method, body)
            .build()
	if (useRequestCache) {
	    requestCache.put(url, request)
	}
	return request
    }

    public fun execute(url: String, method: String, useRequestCache: Boolean): ResponseBody? {
	val request = buildRequest(url, method, useRequestCache)
	val call = okHttpClient.newCall(request)
	val response = call.execute()
	return response.body
    }

    companion object {

	// Volatile modifier is necessary to preserve execution order amoung threads
        @Volatile private var instance: HttpManager? = null

        fun getInstance() =
            instance ?: synchronized(this) { // synchronized to avoid concurrency problems
                instance ?: HttpManager().also { instance = it }
            }
    }
}
