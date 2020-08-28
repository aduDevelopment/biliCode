package com.waterDrop.baselibrary.utils

import android.os.Looper
import android.os.Handler
/**
 * Created by payne on 7/28/20.
 * ClassName:ThreadUtil
 * Description: 线程管理
 */
object ThreadUtil {
    val handler = Handler(Looper.getMainLooper());
    /**
     * 运行在主线程中
     */
    fun runOnMainThread(runnable:Runnable){
        handler.post(runnable)
    }

}