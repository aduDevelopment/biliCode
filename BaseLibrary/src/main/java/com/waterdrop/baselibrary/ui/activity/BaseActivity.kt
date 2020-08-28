package com.waterDrop.baselibrary.ui.activity
/**
 * Created by payne on 7/28/20.
 * ClassName:BaseActivity
 * Description:所有activity的基类
 *             补充：简单逻辑，不使用ViewModel的Activity继承该类。
 */
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import me.jessyan.autosize.internal.CustomAdapt
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

abstract class BaseActivity: AppCompatActivity(), AnkoLogger,CustomAdapt {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    /**
     *是否根据宽度适配
     */
    override fun isBaseOnWidth() = false

    override fun getSizeInDp() = 667F
    /**
     * 初始化数据
     */
    protected open fun initData() {

    }

    /**
     * adapter listener
     */
    protected open fun initListener() {

    }

    /**
     * 开启activity并且finish当前界面
     */
    inline fun <reified T: BaseActivity> startActivityAndFinish(){
        startActivity<T>()
        finish()
    }
}