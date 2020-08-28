package com.mtool.toolslib.base.core.ext

import android.annotation.SuppressLint
import android.app.Activity
import android.content.res.ColorStateList

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.DrawableRes
import androidx.annotation.IdRes
import androidx.annotation.LayoutRes
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar

/**
 * Created by Kelin on 2020/8/5.
 */

fun <T : Any> T.TAG() = this::class.simpleName


fun View.getLayoutInflater(): LayoutInflater = this.getLayoutInflater()

fun View.inflateLayout(@LayoutRes layoutId: Int, parent: ViewGroup? = null, attachToRoot: Boolean = false): View
        = LayoutInflater.from(context).inflate(layoutId, parent, attachToRoot)


fun View.getString(stringResId: Int): String = resources.getString(stringResId)

fun View.getColor(stringResId: Int): Int = ContextCompat.getColor(context, stringResId)

fun View.getColorStateList(stringResId: Int): ColorStateList? = ContextCompat.getColorStateList(context, stringResId)

fun View.getBool(stringResId: Int): Boolean = resources.getBoolean(stringResId)

fun View.getInt(stringResId: Int): Int = resources.getInteger(stringResId)


fun View.getDrawable(@DrawableRes id: Int) = ContextCompat.getDrawable(context, id)

//fun View.showSnackbar(snackbarText: String, timeLength: Int) {
//    Snackbar.make(this, snackbarText, timeLength).show()
//}


fun View.setPaddingLeft(value: Int) = setPadding(value, paddingTop, paddingRight, paddingBottom)
fun View.setPaddingRight(value: Int) = setPadding(paddingLeft, paddingTop, value, paddingBottom)
@SuppressLint("NewApi")
fun View.setPaddingTop(value: Int) = setPaddingRelative(paddingStart, value, paddingEnd, paddingBottom)
@SuppressLint("NewApi")
fun View.setPaddingBottom(value: Int) = setPaddingRelative(paddingStart, paddingTop, paddingEnd, value)
@SuppressLint("NewApi")
fun View.setPaddingStart(value: Int) = setPaddingRelative(value, paddingTop, paddingEnd, paddingBottom)
@SuppressLint("NewApi")
fun View.setPaddingEnd(value: Int) = setPaddingRelative(paddingStart, paddingTop, value, paddingBottom)
@SuppressLint("NewApi")
fun View.setPaddingHorizontal(value: Int) = setPaddingRelative(value, paddingTop, value, paddingBottom)
@SuppressLint("NewApi")
fun View.setPaddingVertical(value: Int) = setPaddingRelative(paddingStart, value, paddingEnd, value)


fun View.setWidth(value: Int) {
    val lp = layoutParams
    lp?.let {
        lp.width = value
        layoutParams = lp
    }
}

fun View.setHeight(value: Int) {
    val lp = layoutParams
    lp?.let {
        lp.height = value
        layoutParams = lp
    }
}

fun View.resize(width: Int, height: Int) {
    val lp = layoutParams
    lp?.let {
        lp.width = width
        lp.height = height
        layoutParams = lp
    }
}

val ViewGroup.children: List<View>
    get() = (0 until childCount).map { getChildAt(it) }


fun <T : View> T.click(block: (T) -> Unit) = setOnClickListener { block(it as T) }


fun <T : View> T.longClick(block: (T) -> Boolean) = setOnLongClickListener { block(it as T) }

fun View.show(): View {
    if (visibility != View.VISIBLE) {
        visibility = View.VISIBLE
    }
    return this
}

fun View.hide(): View {
    if (visibility != View.INVISIBLE) {
        visibility = View.INVISIBLE
    }
    return this
}

fun View.gone(): View {
    if (visibility != View.GONE) {
        visibility = View.GONE
    }
    return this
}

inline fun View.showIf(condition: () -> Boolean): View {
    if (visibility != View.VISIBLE && condition()) {
        visibility = View.VISIBLE
    }
    return this
}

inline fun View.hideIf(predicate: () -> Boolean): View {
    if (visibility != View.INVISIBLE && predicate()) {
        visibility = View.INVISIBLE
    }
    return this
}

inline fun View.goneIf(predicate: () -> Boolean): View {
    if (visibility != View.GONE && predicate()) {
        visibility = View.GONE
    }
    return this
}




fun View.setVisibility(isVisibility: Boolean) {
    visibility = if (isVisibility) View.VISIBLE else View.GONE
}

fun View.setInvisibility(isVisibility: Boolean) {
    visibility = if (isVisibility) View.VISIBLE else View.INVISIBLE
}
fun View.isVisibility() = visibility == View.VISIBLE