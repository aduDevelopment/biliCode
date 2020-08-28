package com.mtool.toolslib.base.core.ext

/**
 * Created by Kelin on 2020/8/6.
 */

fun <T : Any> T?.isNotNull(f: (it: T) -> Unit) {
    if (this != null) f(this)
}

fun String.isNotEmpty(f: (it: String) -> Unit) {
    if (this.isNotEmpty()) f(this)
}

fun <T : Any> T?.isNotNullOrEmpty(f: (it: T) -> Unit) {
    if (this != null) {
        if (this as String != "") {
            f(this)
        }
    }
}