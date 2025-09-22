package com.wseemann.ecp.request

import com.wseemann.ecp.core.ECPRequest
import java.net.URLEncoder

internal abstract class KeyRequest(url: String, private val rawKey: String) : ECPRequest<Void>(url) {
    val key: String
        get() = URLEncoder.encode(rawKey, "UTF-8")
}