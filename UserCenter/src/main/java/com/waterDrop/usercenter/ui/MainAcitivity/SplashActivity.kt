package com.waterDrop.usercenter.ui.MainAcitivity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.waterDrop.usercenter.R
import com.waterDrop.usercenter.ui.activity.LoginActivity
import com.waterDrop.usercenter.ui.activity.RegisterActivity
import kotlinx.android.synthetic.main.activity_splash.*
import org.jetbrains.anko.startActivity
import java.util.*
import kotlin.concurrent.timer

class SplashActivity : AppCompatActivity() {
    private var recLen = 3//跳过倒计时提示3秒
    private lateinit var timer :Timer
    lateinit var timerTask:TimerTask
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        timer.schedule(timerTask,1000,1000)
        splash_time.setOnClickListener {
            finish()
            startActivity<LoginActivity>()
        }
        timeText()
    }
    private fun timeText(){
        runOnUiThread { ->
            recLen--
            splash_time.text = "跳过${recLen}"
            if (recLen <0){
                timer.cancel()
                startActivity<RegisterActivity>()
                finish()
            }
        }

    }

}