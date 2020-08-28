package com.mtool.toolslib.base.core.ext

import android.widget.EditText

/**
 * Created by Kelin on 2020/8/6.
 */

val EditText.value
    get() = text.toString()

val EditText.textEmpty
    get() = text.isEmpty()
val EditText.textNotEmpty
    get() = text.isNotEmpty()
