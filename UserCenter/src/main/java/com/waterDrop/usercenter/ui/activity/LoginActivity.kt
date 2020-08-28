package com.waterDrop.usercenter.ui.activity

/**
 * Created by payne on 8/6/20.
 * ClassName:LoginActivity
 * Description:注册页
 */

import android.os.Bundle
import android.view.View
import com.waterDrop.baselibrary.ui.activity.BaseActivity
import com.waterDrop.baselibrary.ui.activity.BaseMvvmActivity
import com.waterDrop.usercenter.R
import com.waterDrop.usercenter.ui.inflater.LoginUI
import org.jetbrains.anko.setContentView
import org.jetbrains.anko.toast

/*
    登录界面
 */
//@Route(path = RouterPath.UserCenter.PATH_LOGIN)
class LoginActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        LoginUI().setContentView(this)
        toast("${intent.getIntExtra("id", -1)}")
    }

}