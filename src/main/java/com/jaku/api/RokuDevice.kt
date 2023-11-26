package com.jaku.api

import com.jaku.core.KeyPressKeyValues
import com.jaku.core.SearchTypeValues
import com.jaku.model.Channel
import com.jaku.model.Device
import com.jaku.model.Player
import com.jaku.request.*
import java.io.IOException

interface RokuDevice {

    fun getHost(): String

    @Throws(IOException::class)
    fun installRequest(appId: String)

    @Throws(IOException::class)
    fun keyPressRequest(keyPressKeyValue: KeyPressKeyValues)

    @Throws(IOException::class)
    fun keyPressRequest(literalCharacter: Char)

    @Throws(IOException::class, InterruptedException::class)
    fun keyPressRequest(word: String)

    @Throws(IOException::class)
    fun keyDownRequest(keyPressKeyValue: KeyPressKeyValues)

    @Throws(IOException::class)
    fun keyUpRequest(keyPressKeyValue: KeyPressKeyValues)

    @Throws(IOException::class)
    fun launchAppIdRequest(appId: String)

    @Throws(IOException::class)
    fun queryAppsRequest(): List<Channel>

    @Throws(IOException::class)
    fun queryActiveAppRequest(): List<Channel>

    @Throws(IOException::class)
    fun queryDeviceInfo(): Device

    @Throws(IOException::class)
    fun queryIconRequest(appId: String): ByteArray

    @Throws(IOException::class)
    fun queryMediaPlayer(url: String): Player

    @Throws(IOException::class)
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