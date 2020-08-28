package com.waterDrop.baselibrary.ui.activity;

/**
 * Created by payne on 8/6/20.
 * ClassName:BaseMvvmActivity
 * Description: 基础双向Activity
 */

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dyhdyh.widget.loadingbar2.LoadingBar
import com.waterDrop.baselibrary.ui.viewModel.BaseViewModel
import com.waterDrop.baselibrary.ui.viewModel.view.BaseViewInterface
import com.waterdrop.baselibrary.widget.CustomDialogFactory
import me.jessyan.autosize.internal.CustomAdapt
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

abstract class BaseMvvmActivity<T : BaseViewModel<*>> : BaseActivity(), BaseViewInterface, AnkoLogger, CustomAdapt {
    lateinit var mViewModel: T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewModel = getViewModel()
        initListener()
        initData()
    }

    abstract fun getViewModel(): T

    override fun showLoading() {
        LoadingBar.dialog(this)
            .setFactory(CustomDialogFactory())
            .show()
    }

    override fun hideLoading() {
        LoadingBar.dialog(this).cancel()
        LoadingBar.release()
    }

    override fun onError(text: String) {
        LoadingBar.dialog(this).cancel()
        LoadingBar.release()
    }
}
