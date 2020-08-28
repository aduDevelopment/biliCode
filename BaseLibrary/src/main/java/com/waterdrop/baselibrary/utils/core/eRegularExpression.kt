package com.mtool.toolslib.core

import java.util.regex.Pattern


fun String.checkPwdByRegMix(): Pair<Boolean, String> {
    val regEx = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,20}$"
    val pattern = Pattern.compile(regEx)
    val matcher = pattern.matcher(this)
    return Pair(matcher.matches(), "密码必须由字母+数字混合组成")
}


fun String.checkPwdByRegNumber(number: Int): Pair<Boolean, String> {
    val regEx = "^\\d{${number}}$"
    val pattern = Pattern.compile(regEx)
    val matcher = pattern.matcher(this)
    return Pair(matcher.matches(), "密码必须由${number}位数字组成")
}