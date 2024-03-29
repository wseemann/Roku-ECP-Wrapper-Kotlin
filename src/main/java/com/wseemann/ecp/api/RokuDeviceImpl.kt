package com.wseemann.ecp.api

import com.wseemann.ecp.core.KeyPressKeyValues
import com.wseemann.ecp.core.SearchTypeValues
import com.wseemann.ecp.model.Channel
import com.wseemann.ecp.model.Device
import com.wseemann.ecp.model.Player
import com.wseemann.ecp.request.*

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
        return response!!.responseData
    }

    override fun queryActiveAppRequest(): List<Channel> {
        val request = QueryActiveAppRequest(url)
        val response = request.send()
        return response!!.responseData
    }

    override fun queryDeviceInfo(): Device {
        val request = QueryDeviceInfoRequest(url)
        val response = request.send()
        return response!!.responseData
    }

    override fun queryIconRequest(appId: String): ByteArray {
        val request = QueryIconRequest(url, appId)
        val response = request.send()
        return response!!.responseData
    }

    override fun queryMediaPlayer(url: String): Player {
        val request = QueryMediaPlayerRequest(url)
        val response = request.send()
        return response!!.responseData
    }

    override fun searchRequest(keyword: String, title: String, type: SearchTypeValues, tmsId: String, season: Int, showUnavailable: Boolean, matchAny: Boolean, providerId: Long, provider: String, launch: Boolean) {
        val request = SearchRequest(url, keyword, title, type,
                tmsId, season, showUnavailable, matchAny, providerId, provider, launch)
        request.send()
    }

    // Async requests

    override fun installRequestAsync(appId: String, callback: ResponseCallback<Void>) {
        val request = InstallRequest(url, appId)
        request.sendAsync(callback)
    }

    override fun keyPressRequestAsync(keyPressKeyValue: KeyPressKeyValues, callback: ResponseCallback<Void>) {
        val request = KeyPressRequest(url, keyPressKeyValue.value)
        request.sendAsync(callback)
    }

    override fun keyPressRequestAsync(literalCharacter: Char, callback: ResponseCallback<Void>) {
        val request = KeyPressRequest(url, KeyPressKeyValues.LIT_.value + literalCharacter)
        request.sendAsync(callback)
    }

    override fun keyPressRequestAsync(word: String, callback: ResponseCallback<Void>) {
        for (i in 0 until word.length) {
            val request = if (word[i] != ' ') {
                KeyPressRequest(url, KeyPressKeyValues.LIT_.value + word[i])
            } else {
                KeyPressRequest(url, KeyPressKeyValues.LIT_.value + '+')
            }

            request.sendAsync(callback)

            Thread.sleep(100)
        }
    }

    override fun keyDownRequestAsync(keyPressKeyValue: KeyPressKeyValues, callback: ResponseCallback<Void>) {
        val request = KeydownRequest(url, keyPressKeyValue.value)
        request.sendAsync(callback)
    }

    override fun keyUpRequestAsync(keyPressKeyValue: KeyPressKeyValues, callback: ResponseCallback<Void>) {
        val request = KeyupRequest(url, keyPressKeyValue.value)
        request.sendAsync(callback)
    }

    override fun launchAppIdRequestAsync(appId: String, callback: ResponseCallback<Void>) {
        val request = LaunchAppRequest(url, appId)
        request.sendAsync(callback)
    }

    override fun queryAppsRequestAsync(callback: ResponseCallback<List<Channel>>)  {
        val request = QueryAppsRequest(url)
        request.sendAsync(callback)
    }

    override fun queryActiveAppRequestAsync(callback: ResponseCallback<List<Channel>>) {
        val request = QueryActiveAppRequest(url)
        request.sendAsync(callback)
    }

    override fun queryDeviceInfoAsync(callback: ResponseCallback<Device>) {
        val request = QueryDeviceInfoRequest(url)
        request.sendAsync(callback)
    }

    override fun queryIconRequestAsync(appId: String, callback: ResponseCallback<ByteArray>) {
        val request = QueryIconRequest(url, appId)
        request.sendAsync(callback)
    }

    override fun queryMediaPlayerAsync(url: String, callback: ResponseCallback<Player>) {
        val request = QueryMediaPlayerRequest(url)
        request.sendAsync(callback)
    }

    override fun searchRequestAsync(keyword: String, title: String, type: SearchTypeValues, tmsId: String, season: Int, showUnavailable: Boolean, matchAny: Boolean, providerId: Long, provider: String, launch: Boolean, callback: ResponseCallback<Void>) {
        val request = SearchRequest(url, keyword, title, type,
                tmsId, season, showUnavailable, matchAny, providerId, provider, launch)
        request.sendAsync(callback)
    }
}