package com.jaku.api

import com.jaku.core.KeyPressKeyValues
import com.jaku.core.SearchTypeValues
import com.jaku.model.Channel
import com.jaku.model.Device
import com.jaku.model.Player
import com.jaku.request.*

internal class RokuDeviceImpl(private val url: String) : RokuDevice {
    override fun getHost(): String {
        return url
    }

    override fun installRequest(appId: String) {
        val request = InstallRequest(url, appId)
        request.send()
    }

    override fun keyPressRequest(keyPressKeyValue: KeyPressKeyValues) {
        val request = KeyPressRequest(url, keyPressKeyValue.value)
        request.send()
    }

    override fun keyPressRequest(literalCharacter: Char) {
        val request = KeyPressRequest(url, KeyPressKeyValues.LIT_.value + literalCharacter)
        request.send()
    }

    override fun keyPressRequest(word: String) {
        for (i in 0 until word.length) {
            val request = if (word[i] != ' ') {
                KeyPressRequest(url, KeyPressKeyValues.LIT_.value + word[i])
            } else {
                KeyPressRequest(url, KeyPressKeyValues.LIT_.value + '+')
            }

            request.send()

            Thread.sleep(100)
        }
    }

    override fun keyDownRequest(keyPressKeyValue: KeyPressKeyValues) {
        val request = KeydownRequest(url, keyPressKeyValue.value)
        request.send()
    }

    override fun keyUpRequest(keyPressKeyValue: KeyPressKeyValues) {
        val request = KeyupRequest(url, keyPressKeyValue.value)
        request.send()
    }

    override fun launchAppIdRequest(appId: String) {
        val request = LaunchAppRequest(url, appId)
        request.send()
    }

    override fun queryAppsRequest(): List<Channel> {
        val request = QueryAppsRequest(url)
        val response = request.send()
        return response.responseData
    }

    override fun queryActiveAppRequest(): List<Channel> {
        val request = QueryActiveAppRequest(url)
        val response = request.send()
        return response.responseData
    }

    override fun queryDeviceInfo(): Device {
        val request = QueryDeviceInfoRequest(url)
        val response = request.send()
        return response.responseData
    }

    override fun queryIconRequest(appId: String): ByteArray {
        val request = QueryIconRequest(url, appId)
        val response = request.send()
        return response.responseData
    }

    override fun queryMediaPlayer(url: String): Player {
        val request = QueryMediaPlayerRequest(url)
        val response = request.send()
        return response.responseData
    }

    override fun searchRequest(keyword: String, title: String, type: SearchTypeValues, tmsId: String, season: Int, showUnavailable: Boolean, matchAny: Boolean, providerId: Long, provider: String, launch: Boolean) {
        val request = SearchRequest(url, keyword, title, type,
                tmsId, season, showUnavailable, matchAny, providerId, provider, launch)
        request.send()
    }
}