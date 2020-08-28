package com.haoyue.wanandroidkotlin.http

/**
 * 作者：Nixon
 * date：2020/8/11.
 * 邮箱：jan.romon@gmail.com
 * TODO：所有DataBean数据的基类
 */
data class BaseData <T>(
    var data: T,
    var errorCode: Int,
    var errorMsg: String
)