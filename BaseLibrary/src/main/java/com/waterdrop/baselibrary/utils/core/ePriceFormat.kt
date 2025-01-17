package com.mtool.toolslib.core


import java.text.DecimalFormat
import java.util.ArrayList


fun String.castToPriceWithoutSimple(): String {
    return if (this == null) {
        "0"
    } else {
        if (this.isEmpty()) {
            "0"
        } else {
            val mDecimalFormat = DecimalFormat(
                    "#,###,###,###.####")
            val BalanceChange = mDecimalFormat.format(java.lang.Double
                    .parseDouble(this))// 厘模式
            BalanceChange
        }

    }
}

fun String.castToPrice(): String {
    return if (this == null) {
        "¥ " + "0.00"
    } else {
        if (this.isEmpty()) {
            "¥ " + "0.00"
        } else {
            val mDecimalFormat = DecimalFormat(
                    "#,###,###,###.####")
            val BalanceChange = mDecimalFormat.format(java.lang.Double
                    .parseDouble(this))// 厘模式
            "¥ " + BalanceChange
        }

    }
}


fun Int?.castToPrice(): String {
    return if (this != null) {
        val mDecimalFormat = DecimalFormat(
                "#,###,###,###.####")
        val BalanceChange = mDecimalFormat.format(this.toLong())// 厘模式
        "¥ " + BalanceChange
    } else {
        "¥ " + "0.00"
    }
}


fun Double?.castToPrice(): String {
    return if (this != null) {
        val mDecimalFormat = DecimalFormat(
                "#,###,###,###.####")
        val BalanceChange = mDecimalFormat.format(this)// 厘模式
        "¥ " + BalanceChange
    } else {
        "¥ " + "0.00"
    }
}
