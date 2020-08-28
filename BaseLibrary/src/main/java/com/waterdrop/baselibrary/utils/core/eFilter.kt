package com.mtool.toolslib.core



fun String.firstCharacterAZ(): Boolean {
    return if (this.isNotEmpty()) {
        val x = this[0]
        x in 'a'..'z' || x in 'A'..'Z'
    } else {
        false
    }
}