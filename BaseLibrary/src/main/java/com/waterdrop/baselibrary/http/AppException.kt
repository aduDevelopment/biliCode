package com.waterdrop.baselibrary.http

/**
 * 作者：Nixon
 * date：2020/8/11.
 * 邮箱：jan.romon@gmail.com
 * TODO：错误信息异常
 */
class AppException : Exception {

    var errorMsg: String //错误消息
    var errCode: Int = -1 //错误码
    var errorLog: String? //错误日志

    constructor(errCode: Int, error: String?, errorLog: String? = "") : super(error) {
        this.errorMsg = error ?: "请求失败，请稍后再试"
        this.errCode = errCode
        this.errorLog = errorLog?:this.errorMsg
    }

    constructor(error: Error,e: Throwable?) {
        errCode = error.getKey()
        errorMsg = error.getValue()
        errorLog = e?.message
    }
}