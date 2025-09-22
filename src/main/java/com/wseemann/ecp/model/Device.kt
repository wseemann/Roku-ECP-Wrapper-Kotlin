package com.wseemann.ecp.model

data class Device(
    var udn: String? = null,
    var serialNumber: String? = null,
    var deviceId: String? = null,
    var vendorName: String? = null,
    var modelNumber: String? = null,
    var modelName: String? = null,
    var wifiMac: String? = null,
    var ethernetMac: String? = null,
    var networkType: String? = null,
    var userDeviceName: String? = null,
    var softwareVersion: String? = null,
    var softwareBuild: String? = null,
    var secureDevice: String? = null,
    var language: String? = null,
    var country: String? = null,
    var locale: String? = null,
    var timeZone: String? = null,
    var timeZoneOffset: String? = null,
    var powerMode: String? = null,
    var supportsSuspend: String? = null,
    var supportsFindRemote: String? = null,
    var supportsAudioGuide: String? = null,
    var developerEnabled: String? = null,
    var keyedDeveloperId: String? = null,
    var searchEnabled: String? = null,
    var voiceSearchEnabled: String? = null,
    var notificationsEnabled: String? = null,
    var notificationsFirstUse: String? = null,
    var supportsPrivateListening: String? = null,
    var headphonesConnected: String? = null,
    var tv: String? = null, // isTv
    var stick: String? = null, // isStick
    var host: String? = null
) {
    override fun toString(): String {
        return this.host.orEmpty()
    }
}