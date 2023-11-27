package com.wseemann.ecp.logging

import org.apache.logging.log4j.LogManager

internal object Logger {
    private val logger = LogManager.getLogger()

    fun debug(message: String) {
        logger.debug(message)
    }

    fun info(message: String) {
        logger.info(message)
    }

    fun error(message: String) {
        logger.error(message)
    }

    fun error(ex: Exception) {
        logger.error(ex)
    }
}