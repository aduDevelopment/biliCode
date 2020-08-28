package com.waterDrop.usercenter.ui.inflater
/**
 * Created by payne on 7/28/20.
 * ClassName:LoginUI
 * Description: 登录页的UI
 */
import android.graphics.Color
import android.os.Build
import android.view.View
import android.widget.TextView
import androidx.annotation.RequiresApi
import com.waterDrop.usercenter.ui.activity.LoginActivity
import com.waterDrop.usercenter.viewModel.LoginViewModel
import com.waterDrop.usercenter.repository.LoginRepository
import kotlinx.coroutines.async

import org.jetbrains.anko.*
import org.jetbrains.anko.sdk27.coroutines.onClick

class LoginUI : AnkoComponent<LoginActivity> {
    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    override fun createView(ui: AnkoContext<LoginActivity>) = with(ui) {
        val loginViewModel = LoginViewModel()

        /**
         * 绘制ui界面
         */

        verticalLayout {
            padding = dip(30)
            val textV: TextView = textView {
                text = ""
                textSize = 24f
                textColor = Color.BLUE
                textAlignment = View.TEXT_ALIGNMENT_CENTER
            }
            val name = editText {
                hint = "Name"

                textSize = 24f
            }
            val password = editText {
                hint = "Password"
                textSize = 24f
            }
            button("登录") {
                textSize = 26f
                onClick {
                    val req = async { LoginRepository(name.text, password.text).postLogin() }
                    loginViewModel.loginSubmit(ui, req.await(), textV)
                }
            }
        }

    }
}