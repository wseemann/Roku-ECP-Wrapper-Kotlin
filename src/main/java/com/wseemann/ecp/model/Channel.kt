package com.wseemann.ecp.model

data class Channel(
    var id: String? = null,
    var title: String? = null,
    var type: String? = null,
    var version: String? = null,
    var imageUrl: String? = null
) {

    override fun toString(): String {
        return this.id + " " + this.title + " " + this.type + " " + this.version + " " + this.imageUrl
    }
}