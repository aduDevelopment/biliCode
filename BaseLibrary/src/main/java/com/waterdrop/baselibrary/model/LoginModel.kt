package com.waterDrop.baselibrary.model
/**
 * Created by payne on 7/28/20.
 * ClassName: userRes
 * Description:注册登录javabean
 */

data class Hello(val text: String)
data class userRes(val status: Int, val msg: String, val username: String) {
    fun user(): String {
        return username
    }

    fun body(): userRes = this
}