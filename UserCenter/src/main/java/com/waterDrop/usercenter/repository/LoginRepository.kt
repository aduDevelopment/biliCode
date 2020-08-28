package com.waterDrop.usercenter.repository

/**
 * Created by payne on 7/28/20.
 * ClassName:LoginRepository
 * Description: 登录模块的的Repository
 */

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.waterDrop.baselibrary.model.userRes
import com.waterDrop.baselibrary.repository.HttpService
import java.net.SocketTimeoutException
import java.net.UnknownHostException

class LoginRepository (private val username: CharSequence?, private val password: CharSequence?){

    private var usersSuccessLiveData = MutableLiveData<userRes>()
    private var errMsg = MutableLiveData<Boolean>()

    /**
     * 登录异常捕获
     */
    suspend fun postLogin(): MutableLiveData<*> {
        try {
            val response = HttpService.service.postLogin(username, password)
            if (response.status === 1) {
                usersSuccessLiveData.postValue(response.body())
                return usersSuccessLiveData
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
        return if(usersSuccessLiveData === null) usersSuccessLiveData else errMsg
    }
    
    companion object {
        val TAG = LoginRepository::class.java.simpleName
    }

}