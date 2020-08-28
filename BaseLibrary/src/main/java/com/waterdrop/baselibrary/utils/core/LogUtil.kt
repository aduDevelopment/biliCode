package com.mtool.toolslib.base.core.ext

import android.util.Log

//规定每段显示的长度
private const val LOG_MAXLENGTH : Int = 2000
const val NETDATA_TAG = "netdata"

fun <T : Any> T?.loge(tag : String, msg : String) {

    var strLength = msg.length
    var start = 0
    var end = LOG_MAXLENGTH
    var i = 0
    while (i < 100) {
        if (strLength > end) {
            Log.e(tag, msg.substring(start, end))
            start = end
            end += LOG_MAXLENGTH;
        } else {
            Log.e(tag, msg.substring(start, strLength))
            break
        }
    }
}

fun <T : Any> T?.logNet(msg : String) {
    loge(NETDATA_TAG, msg)
}

fun <T : Any> T?.logTouch(msg : String) {
    loge("touch", msg)
}