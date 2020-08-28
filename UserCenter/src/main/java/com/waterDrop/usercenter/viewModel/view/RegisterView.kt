package com.waterDrop.usercenter.viewModel.view

import com.waterDrop.baselibrary.ui.viewModel.view.BaseViewInterface


/**
 * Created by payne on 8/6/20.
 * ClassName:RegisterView
 * Description: 注册视图接口
 */

interface RegisterView : BaseViewInterface {
    suspend fun onRegisterResult(mobile: String, verifyCode: String)
}