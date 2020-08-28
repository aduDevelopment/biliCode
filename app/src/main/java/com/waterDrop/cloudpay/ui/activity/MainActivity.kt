package com.waterDrop.cloudpay.ui.activity
/**
 * Created by payne on 7/28/20.
 * ClassName:MainActivity
 * Description:主页
 */
import android.os.Bundle
import com.waterDrop.cloudpay.R
import com.waterDrop.baselibrary.ui.activity.BaseActivity

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}