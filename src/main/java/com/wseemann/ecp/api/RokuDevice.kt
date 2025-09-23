package com.wseemann.ecp.api

import com.wseemann.ecp.core.KeyPressKeyValues
import com.wseemann.ecp.core.SearchTypeValues
import com.wseemann.ecp.model.Channel
import com.wseemann.ecp.model.Device
import com.wseemann.ecp.model.Player

interface RokuDevice : AsyncRokuDevice {

    fun getHost(): String

    @Throws(Exception::class)
    fun installRequest(appId: String)

    @Throws(Exception::class)
    fun keyPressRequest(keyPressKeyValue: KeyPressKeyValues)

    @Throws(Exception::class)
    fun keyPressRequest(literalCharacter: Char)

    @Throws(Exception::class)
    fun keyPressRequest(word: String)

    @Throws(Exception::class)
    fun keyDownRequest(keyPressKeyValue: KeyPressKeyValues)

    @Throws(Exception::class)
    fun keyUpRequest(keyPressKeyValue: KeyPressKeyValues)

    @Throws(Exception::class)
    fun launchAppIdRequest(appId: String)

    @Throws(Exception::class)
    fun queryAppsRequest(): List<Channel>

    @Throws(Exception::class)
    fun queryActiveAppRequest(): List<Channel>

    @Throws(Exception::class)
    fun queryDeviceInfo(): Device

    @Throws(Exception::class)
    fun queryIconRequest(appId: String): ByteArray

    @Throws(Exception::class)
    fun queryMediaPlayer(url: String): Player

    @Throws(Exception::class)
    fun searchRequest(
            keyword: String,
            title: String,
            type: SearchTypeValues,
            tmsId: String,
            season: Int,
            showUnavailable: Boolean,
            matchAny: Boolean,
            providerId: Long,
            provider: String,
            launch: Boolean
    )

    companion object {
        fun create(url: String): RokuDevice {
            return RokuDeviceImpl(url)
        }
    }
}