package me.hgj.jetpackmvvm.callback.livedata

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.waterdrop.baselibrary.utils.notNull
import java.util.*

/**
 * TODO：防止数据倒灌
 * 对 "数据倒灌" 的状况不理解的小伙伴，可参考《jetpack MVVM 精讲》的解析
 * https://juejin.im/post/5dafc49b6fb9a04e17209922
 * 本类参考了官方 SingleEventLive 的非入侵设计，
 * TODO：并创新性地引入了 "延迟清空消息" 的设计，
 * 如此可确保：
 * 1.一条消息能被多个观察者消费
 * 2.延迟期结束，不再能够收到旧消息的推送
 * 3.并且旧消息在延迟期结束时能从内存中释放，避免内存溢出等问题
 * Create by KunMinX at 19/9/23
 */
class UnPeekLiveData<T> : MutableLiveData<T>() {
    private var isCleaning = false
    private var hasHandled = true
    private var isDelaying = false
    private val mTimer = Timer()
    private var mTask: TimerTask? = null
    private var DELAY_TO_CLEAR_EVENT = 1000

    override fun observe(owner: LifecycleOwner, observer: Observer<in T>) {
        super.observe(owner, Observer {
            if (isCleaning) {
                hasHandled = true
                isDelaying = false
                isCleaning = false
                return@Observer
            }
            if (!hasHandled) {
                hasHandled = true
                isDelaying = true
                observer.onChanged(it)
            } else if (isDelaying) {
                observer.onChanged(it)
            }
        })
    }

    override fun observeForever(observer: Observer<in T>) {
        super.observeForever(Observer {
            if (isCleaning) {
                hasHandled = true
                isDelaying = false
                isCleaning = false
                return@Observer
            }
            if (!hasHandled) {
                hasHandled = true
                isDelaying = true
                observer.onChanged(it)
            } else if (isDelaying) {
                observer.onChanged(it)
            }
        })
    }

    /**
     * 重写的 setValue 方法
     * @param value
     */
    override fun setValue(value: T?) {
        hasHandled = false
        isDelaying = false
        super.setValue(value)
        mTask.notNull({
            it.cancel()
            mTimer.purge()
        })
        mTask = object : TimerTask() {
            override fun run() {
                clear()
            }
        }
        mTimer.schedule(mTask, DELAY_TO_CLEAR_EVENT.toLong())
    }

    private fun clear() {
        hasHandled = true
        isDelaying = false
    }
}