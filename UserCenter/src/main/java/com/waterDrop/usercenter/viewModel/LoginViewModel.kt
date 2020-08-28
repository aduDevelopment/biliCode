package com.waterDrop.usercenter.viewModel

/**
 * Created by payne on 7/28/20.
 * ClassName:LoginViewModel
 * Description: 登录页的ViewModel
 */
import android.widget.TextView
import androidx.lifecycle.*
import com.waterDrop.baselibrary.ui.viewModel.view.BaseViewInterface
import com.waterDrop.usercenter.ui.activity.LoginActivity
import org.jetbrains.anko.AnkoContext

class LoginViewModel :
    BaseViewInterface {
    companion object {
        val TAG = LoginViewModel::class.java.simpleName
    }
    fun loginSubmit(ui: AnkoContext<LoginActivity>, responseBody: MutableLiveData<*>, observerView: TextView) {

        /**
         * 双向绑定实现
         */

        liveData {
            try {
                emit(responseBody)
            } catch(e: Exception) {
                emit(responseBody)
            }
        }.observe(ui.owner, Observer {
            observerView.text = it.value.toString()
        })

    }

    override fun showLoading() {

    }

    override fun hideLoading() {

    }

    override fun onError(text: String) {

    }
}
