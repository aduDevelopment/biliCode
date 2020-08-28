package com.waterDrop.cloudpay.ui.activity

import android.app.Application
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.ViewModelStoreOwner

/**
 * 作者：Nixon
 * date：2020/8/11.
 * 邮箱：jan.romon@gmail.com
 * TODO：
 */
class BaseApp :Application(), ViewModelStoreOwner {
    lateinit var mAppViewModelStore: ViewModelStore
    lateinit var mFactory: ViewModelProvider.Factory

    override fun onCreate() {
        super.onCreate()
        mAppViewModelStore = ViewModelStore()
    }

    override fun getViewModelStore(): ViewModelStore {
        return mAppViewModelStore
    }

    fun getAppViewModelProvider(): ViewModelProvider {
        return ViewModelProvider(this, this.getAppFactory())
    }

    private fun getAppFactory(): ViewModelProvider.Factory {
        if (mFactory == null) {
            mFactory = ViewModelProvider.AndroidViewModelFactory.getInstance(this)
        }
        return mFactory
    }
}