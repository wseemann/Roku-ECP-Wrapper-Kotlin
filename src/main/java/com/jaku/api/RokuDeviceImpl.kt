package com.jaku.api

import com.jaku.core.JakuRequest
import com.jaku.core.KeypressKeyValues
import com.jaku.core.SearchTypeValues
import com.jaku.model.Channel
import com.jaku.model.Device
import com.jaku.model.Player
import com.jaku.request.*
import java.io.ByteArrayOutputStream

internal class RokuDeviceImpl(private val url: String) : RokuDevice {
    override fun getHost(): String {
        return url
    }

    override fun installRequest(appId: String) {
        val installRequest = InstallRequest(url, appId)
        val request = JakuRequest<Void>(installRequest)
        request.send()
    }

    override fun keyPressRequest(keypressKeyValue: KeypressKeyValues) {
        val keypressRequest = KeypressRequest(url, keypressKeyValue.value)
        val request = JakuRequest<Void>(keypressRequest)
        request.send()
    }

    override fun keyPressRequest(literalCharacter: Char) {
        val keypressRequest = KeypressRequest(url, KeypressKeyValues.LIT_.value + literalCharacter)
        val request = JakuRequest<Void>(keypressRequest)
        request.send()
    }

    override fun keyPressRequest(word: String) {
        for (i in 0 until word.length) {
            val keypressRequest = if (word[i] != ' ') {
                KeypressRequest(url, KeypressKeyValues.LIT_.value + word[i])
            } else {
                KeypressRequest(url, KeypressKeyValues.LIT_.value + '+')
            }

            val request = JakuRequest<Void>(keypressRequest)
            request.send()

            Thread.sleep(100)
        }
    }

    override fun keyDownRequest(keypressKeyValue: KeypressKeyValues) {
        val keydownRequest = KeydownRequest(url, keypressKeyValue.value)
        val request = JakuRequest<Void>(keydownRequest)
        request.send()
    }

    override fun keyUpRequest(keypressKeyValue: KeypressKeyValues) {
        val keyupRequest = KeyupRequest(url, keypressKeyValue.value)
        val request = JakuRequest<Void>(keyupRequest)
        request.send()
    }

    override fun launchAppIdRequest(appId: String) {
        val launchAppIdRequest = LaunchAppRequest(url, appId)
        val request = JakuRequest<Void>(launchAppIdRequest)
        request.send()
    }

    override fun queryAppsRequest(): List<Channel> {
        val queryAppsRequest = QueryAppsRequest(url)
        val request = JakuRequest<List<Channel>>(queryAppsRequest)
        val response = request.send()
        return response.responseData
    }

    override fun queryActiveAppRequest(): List<Channel> {
        val queryActiveAppRequest = QueryActiveAppRequest(url)
        val request = JakuRequest<List<Channel>>(queryActiveAppRequest)
        val response = request.send()
        return response.responseData
    }

    override fun queryDeviceInfo(): Device {
        val queryActiveAppRequest = QueryDeviceInfoRequest(url)
        val request = JakuRequest<Device>(queryActiveAppRequest)
        val response = request.send()
        return response.responseData
    }

    override fun queryIconRequest(appId: String): ByteArray {
        val queryActiveAppRequest = QueryIconRequest(url, appId)
        val request = JakuRequest<ByteArrayOutputStream>(queryActiveAppRequest)
        val response = request.send()
        return response.responseData.toByteArray()
    }

    override fun queryMediaPlayer(url: String): Player {
        val queryMediaPlayerRequest = QueryMediaPlayerRequest(url)
        val request = JakuRequest<Player>(queryMediaPlayerRequest)
        val response = request.send()
        return response.responseData
    }

    override fun searchRequest(keyword: String, title: String, type: SearchTypeValues, tmsId: String, season: Int, showUnavailable: Boolean, matchAny: Boolean, providerId: Long, provider: String, launch: Boolean) {
        val searchRequest = SearchRequest(url, keyword, title, type,
                tmsId, season, showUnavailable, matchAny, providerId, provider, launch)
        val request = JakuRequest<Void>(searchRequest)
        request.send()
    }
}