package com.waterdrop.baselibrary.base

import java.lang.reflect.ParameterizedType

/**
 * 作者：Nixon
 * date：2020/8/11.
 * 邮箱：jan.romon@gmail.com
 * TODO：
 */
// 获得T.class
inline fun <reified T> classOf()  = T::class.java

//获得 T object
inline fun <reified T> instanceOf()  = T::class.java.newInstance()

@Suppress("UNCHECKED_CAST")
fun <VM> getVmClazz(obj: Any): VM {
    return (obj.javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[0] as VM
}