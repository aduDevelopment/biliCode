package com.waterDrop.baselibrary.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import me.jessyan.autosize.internal.CustomAdapt
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.runOnUiThread
import org.jetbrains.anko.support.v4.toast

/**
 * Created by payne on 7/28/20.
 * ClassName:BaseFragment
 * Description:所有fragment的基类
 */

abstract class BaseFragment : Fragment() ,AnkoLogger,CustomAdapt{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    override fun isBaseOnWidth() = false

    override fun getSizeInDp() = 667F
    /**
     * fragment初始化
     */
    open protected fun init() {

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return initView()
    }

    /**
     * 获取布局view
     */
    abstract fun initView(): View?

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initListener()
        initData()

    }

    /**
     * 数据的初始化
     */
    protected open fun initData() {

    }

    /**
     * adapter listener
     */
    protected open fun initListener() {

    }

    /**
     * toast封装
     */

    fun myToast(msg:String){
        context?.runOnUiThread { toast(msg) }
    }
}