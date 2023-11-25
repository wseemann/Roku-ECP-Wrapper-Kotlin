package com.jaku.api

interface RokuDeviceFactory {
    fun create(url: String): RokuDevice
}