package com.waterDrop.usercenter.ui.activity

import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.mtool.toolslib.base.core.ext.setVisibility
import com.waterDrop.usercenter.R
import com.waterDrop.usercenter.ui.activity.LoginActivity
import com.waterDrop.usercenter.ui.activity.RegisterActivity
import kotlinx.android.synthetic.main.activity_splash.*
import org.jetbrains.anko.startActivity
import java.util.*
import kotlin.concurrent.timer

class SplashActivity : AppCompatActivity() {

    private val handler = Handler()
    private var mCountNum = 3


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        handler.postDelayed(countDown, 0)
        splash_time.setOnClickListener {
            finish()
            handler.removeCallbacks(countDown)
            startActivity<LoginActivity>()
        }

    }


    private val countDown = object : Runnable {

        override fun run() {

            splash_time.text = "跳过${mCountNum}"

            if (mCountNum > 0) {
                handler.postDelayed(this, 1000)
            } else {
                splash_time.visibility = View.GONE
                startActivity<RegisterActivity>()
                finish()
            }
            mCountNum--
        }
    }


}