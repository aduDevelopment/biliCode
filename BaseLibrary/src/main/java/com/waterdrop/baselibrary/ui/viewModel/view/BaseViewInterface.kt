package com.waterDrop.baselibrary.ui.viewModel.view

/*
    MVVM中视图回调 基类
 */
interface BaseViewInterface {
    fun showLoading()
    fun hideLoading()
    fun onError(text:String)
}