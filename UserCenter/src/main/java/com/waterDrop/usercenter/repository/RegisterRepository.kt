package com.waterDrop.usercenter.repository

/**
 * Created by payne on 7/28/20.
 * ClassName: RegisterRepository
 * Description: 注册模块的的Repository
 */

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.waterDrop.baselibrary.model.userRes
import com.waterDrop.baselibrary.repository.HttpService
import java.net.SocketTimeoutException
import java.net.UnknownHostException

class RegisterRepository(private val mobile: CharSequence?, private val verifyCode: CharSequence?) {

    private var usersSuccessLiveData = MutableLiveData<userRes>()
    private var errMsg = MutableLiveData<Boolean>()

    /**
     * 登录异常捕获
     */
    suspend fun postRegister(): MutableLiveData<userRes> {
        try {
            val response = HttpService.service.postRegister(mobile, verifyCode)
            if (response.status === 1) {
                usersSuccessLiveData.value = response
            } else {
                errMsg.postValue(true)
            }

        } catch (e: UnknownHostException) {
            Log.e(TAG, e.message)
            errMsg.postValue(true)
        } catch (e: SocketTimeoutException) {
            Log.e(TAG, e.message)
            errMsg.postValue(true)
        } catch (e: Exception) {
            Log.e(TAG, e.message)
            errMsg.postValue(true)
        }
        return usersSuccessLiveData
    }

    companion object {
        val TAG = RegisterRepository::class.java.simpleName
    }

}