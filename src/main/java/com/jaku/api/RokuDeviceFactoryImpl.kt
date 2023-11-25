package com.jaku.api

internal class RokuDeviceFactoryImpl : RokuDeviceFactory {
    override fun create(url: String): RokuDevice {
        return RokuDeviceImpl(url)
    }
}