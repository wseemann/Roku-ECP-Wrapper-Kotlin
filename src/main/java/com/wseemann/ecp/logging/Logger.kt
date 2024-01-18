package com.wseemann.ecp.logging

internal object Logger {

    var logDebug = false

    fun debug(message: String) {
        if (logDebug) {
            println(message)
        }
    }

    fun info(message: String) {
        println(message)
    }

    fun error(message: String) {
        println(message)
    }

    fun error(ex: Exception) {
        println(ex.message)
    }
}