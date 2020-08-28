package com.mtool.toolslib.utils

import org.jetbrains.anko.*

/**
 * log
 */
object LogUtil : AnkoLogger {

    fun logV(str: Any?) {
        verbose(str)
    }

    fun logD(str: Any?) {
        debug(str)
    }

    fun logI(str: Any?) {
        info(str)
    }

    fun logW(str: Any?) {
        warn(str)
    }

    fun logE(str: Any?) {
        error(str)
    }
}