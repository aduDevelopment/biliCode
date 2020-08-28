package com.waterDrop.usercenter.viewModel

import com.haoyue.wanandroidkotlin.http.HttpClient
import com.waterDrop.baselibrary.ui.viewModel.BaseViewModel
import com.waterDrop.usercenter.databinding.ActivityRegisterBinding
import com.waterDrop.usercenter.model.ApiClient
import com.waterDrop.usercenter.model.ArticleList
import com.waterDrop.usercenter.viewModel.view.RegisterView

class RegisterViewModel : BaseViewModel<RegisterView>() {

    companion object {
        val TAG = RegisterViewModel::class.java.simpleName
    }

    suspend fun register(mobile: String, verifyCode: String) {
        //业务逻辑
        mView?.onRegisterResult(mobile, verifyCode)
    }

    suspend fun requestData(id: String = "0", binding: ActivityRegisterBinding) {
        mView?.showLoading()
        HttpClient.requestData(
            HttpClient.getService(ApiClient.HomePageAPI::class.java).homeArticleList(id),
            object : HttpClient.CallBack<ArticleList> {
                override fun success(v: ArticleList) {
                    mView?.hideLoading()
                    println("接收到的数据：$v")
                    binding.articleList = v
                }

                override fun failed(t: Throwable) {
                    mView?.onError(t.localizedMessage)
                }
            })
    }
}