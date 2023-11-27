package com.wseemann.ecp.api

import com.wseemann.ecp.core.KeyPressKeyValues
import com.wseemann.ecp.core.SearchTypeValues
import com.wseemann.ecp.model.Channel
import com.wseemann.ecp.model.Device
import com.wseemann.ecp.model.Player

interface AsyncRokuDevice {

    fun installRequestAsync(appId: String, callback: ResponseCallback<Void>)

    fun keyPressRequestAsync(keyPressKeyValue: KeyPressKeyValues, callback: ResponseCallback<Void>)

    fun keyPressRequestAsync(literalCharacter: Char, callback: ResponseCallback<Void>)

    fun keyPressRequestAsync(word: String, callback: ResponseCallback<Void>)

    fun keyDownRequestAsync(keyPressKeyValue: KeyPressKeyValues, callback: ResponseCallback<Void>)

    fun keyUpRequestAsync(keyPressKeyValue: KeyPressKeyValues, callback: ResponseCallback<Void>)

    fun launchAppIdRequestAsync(appId: String, callback: ResponseCallback<Void>)

    fun queryAppsRequestAsync(callback: ResponseCallback<List<Channel>>)

    fun queryActiveAppRequestAsync(callback: ResponseCallback<List<Channel>>)

    fun queryDeviceInfoAsync(callback: ResponseCallback<Device>)

    fun queryIconRequestAsync(appId: String, callback: ResponseCallback<ByteArray>)

    fun queryMediaPlayerAsync(url: String, callback: ResponseCallback<Player>)

    fun searchRequestAsync(
            keyword: String,
            title: String,
            type: SearchTypeValues,
            tmsId: String,
            season: Int,
            showUnavailable: Boolean,
            matchAny: Boolean,
            providerId: Long,
            provider: String,
            launch: Boolean,
            callback: ResponseCallback<Void>
    )
}