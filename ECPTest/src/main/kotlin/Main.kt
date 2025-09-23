package org.example

import com.wseemann.ecp.api.RokuDevice
import com.wseemann.ecp.core.KeyPressKeyValues
import com.wseemann.ecp.model.Channel
import com.wseemann.ecp.model.Device
import java.io.ByteArrayInputStream
import java.io.File
import java.lang.Exception
import javax.imageio.ImageIO

object Main {

    private const val ROKU_DEVICE_IP_ADDRESS = ""

    private lateinit var rokuDevice: RokuDevice

    @JvmStatic
    fun main(args: Array<String>) {
        try {
            rokuDevice = RokuDevice.create(ROKU_DEVICE_IP_ADDRESS)

            testKeypress()
            testKeydown()
            testKeyup()
            queryApps()
            queryActiveApp()
            queryDeviceInfo()
            launchAppId()
            queryIcon()
        } catch (ex: Exception) {
            ex.printStackTrace()
        }
    }

    @Throws(Exception::class)
    private fun testKeypress() {
        rokuDevice.keyPressRequest(KeyPressKeyValues.INFO)
    }

    @Throws(Exception::class)
    private fun testKeydown() {
        rokuDevice.keyDownRequest(KeyPressKeyValues.INFO)
    }

    @Throws(Exception::class)
    private fun testKeyup() {
        rokuDevice.keyUpRequest(KeyPressKeyValues.INFO)
    }

    @Throws(Exception::class)
    private fun queryApps() {
        val channels: List<Channel> = rokuDevice.queryAppsRequest()

        for (channel in channels) {
            println(channel.title)
        }
    }

    @Throws(Exception::class)
    private fun queryActiveApp() {
        val channels: List<Channel> = rokuDevice.queryActiveAppRequest()

        for (channel in channels) {
            println(channel.id)
        }
    }

    @Throws(Exception::class)
    private fun queryDeviceInfo() {
        val device: Device = rokuDevice.queryDeviceInfo()

        println(device.country)
    }

    @Throws(Exception::class)
    private fun launchAppId() {
        rokuDevice.launchAppIdRequest("1457")
    }

    @Throws(Exception::class)
    private fun queryIcon() {
        val data: ByteArray = rokuDevice.queryIconRequest("1457")

        val outputfile = File("<some path>")
        val image = ImageIO.read(ByteArrayInputStream(data))
        ImageIO.write(image, "png", outputfile)
    }
}