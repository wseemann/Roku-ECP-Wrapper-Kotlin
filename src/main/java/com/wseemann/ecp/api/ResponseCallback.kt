package com.wseemann.ecp.api

interface ResponseCallback<T> {
    fun onSuccess(data: T?)
    fun onError(ex: Exception)
}