package com.waterDrop.usercenter.ui.activity

/**
 * Created by payne on 8/6/20.
 * ClassName:RegisterActivity
 * Description:登录页
 */

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.liveData
import com.haoyue.wanandroidkotlin.http.HttpClient
import com.waterDrop.baselibrary.model.userRes
import com.waterDrop.baselibrary.ui.activity.BaseMvvmActivity
import com.waterDrop.usercenter.R
import com.waterDrop.usercenter.databinding.ActivityRegisterBinding
import com.waterDrop.usercenter.model.ArticleList
import com.waterDrop.usercenter.repository.RegisterRepository
import com.waterDrop.usercenter.viewModel.RegisterViewModel
import com.waterDrop.usercenter.viewModel.view.RegisterView
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.coroutines.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast
import kotlin.coroutines.CoroutineContext

class RegisterActivity : BaseMvvmActivity<RegisterViewModel>(), RegisterView, CoroutineScope {

    private var job: Job = Job()
    var id: Int = 0

    lateinit var binding : ActivityRegisterBinding

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    override fun onDestroy() {
        super.onDestroy()
        job.cancel()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      //  setContentView(R.layout.activity_register)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_register)
        mViewModel.mView = this
        onClick()
    }

    override fun getViewModel(): RegisterViewModel {
        return RegisterViewModel()
    }

    override suspend fun onRegisterResult(mobile: String, verifyCode: String) {
        /**
         * 双向绑定实现
         */
        var reqData = MutableLiveData<userRes>()
        liveData {
            try {
                var req: Deferred<MutableLiveData<userRes>> =
                    async { RegisterRepository(mobile, verifyCode).postRegister() }
                reqData = req.await()
                emit(reqData.value?.username.toString())
                toast("注册成功")
//                startActivityAndFinish<LoginActivity>()
            } catch (e: Exception) {
                emit(reqData)
            }
        }.observe(this, Observer {
            showMsg.text = "${it.toString()}恭喜你注册成功"
        })
    }

    /**
    点击事件
     */
    fun onClick() {
        registerBtn.setOnClickListener {
            startActivity<LoginActivity>()
        }
        headerContainer.setOnClickListener {
            launch {
                mViewModel.register("099988888888", "1234")
            }
        }

        btnRequest.setOnClickListener {
            launch {
                mViewModel.requestData(id.toString(), binding)
                id++
            }
            println("打印请求结果：${binding.articleList}")
        }
    }
}
