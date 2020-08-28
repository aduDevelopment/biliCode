package com.mtool.toolslib.base.core.ext

import android.app.Activity
import android.content.res.XmlResourceParser
import android.graphics.drawable.Drawable
import androidx.annotation.*
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment


/**
 * Created by Kelin on 2020/8/6.
 */
fun String.findDrawableResource(act: Activity): Int {
    val packageName = act.packageName
    return act.resources.getIdentifier(this, "drawable", packageName)
}

fun String.findMipmapResource(act: Activity): Int {
    val packageName = act.packageName
    return act.resources.getIdentifier(this, "mipmap", packageName)
}

fun String.findStringResource(act: Activity): Int {
    val packageName = act.packageName
    return act.resources.getIdentifier(this, "string", packageName)
}

fun String.findStyleResource(act: Activity): Int {
    val packageName = act.packageName
    return act.resources.getIdentifier(this, "style", packageName)
}

fun Activity.getColorFromRes(@ColorRes colorRes: Int): Int {
    return ContextCompat.getColor(this, colorRes)
}


fun Activity.getStringFromRes(@StringRes stringRes: Int): String {
    return this.resources.getString(stringRes)
}

fun Activity.getDimenFromRes(@DimenRes dimRes: Int): Float {
    return this.resources.getDimension(dimRes)
}

fun Activity.getAnimFromRes(@AnimRes animRes: Int): XmlResourceParser {
    return this.resources.getAnimation(animRes)
}

fun Activity.getDrawableFromRes(@DrawableRes drawRes: Int): Drawable {
    return ContextCompat.getDrawable(this, drawRes)!!
}

fun Fragment.getColorFromRes(@ColorRes colorRes: Int): Int {
    return ContextCompat.getColor(activity!!, colorRes)
}

fun Fragment.getStringFromRes(@StringRes stringRes: Int): String {
    return activity!!.resources.getString(stringRes)
}

fun Fragment.getDimenFromRes(@DimenRes dimRes: Int): Float {
    return activity!!.resources.getDimension(dimRes)
}

fun Fragment.getAnimFromRes(@AnimRes animRes: Int): XmlResourceParser {
    return activity!!.resources.getAnimation(animRes)
}

fun Fragment.getDrawableFromRes(@DrawableRes drawRes: Int): Drawable {
    return this!!.activity?.let { ContextCompat.getDrawable(it, drawRes) }!!
}