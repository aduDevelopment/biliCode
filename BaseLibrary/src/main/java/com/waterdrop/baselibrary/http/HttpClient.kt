package com.haoyue.wanandroidkotlin.http

import com.mtool.toolslib.utils.LogUtil
import com.waterDrop.baselibrary.common.ROOT_URL
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * 作者：Nixon
 * date：2020/8/11.
 * 邮箱：jan.romon@gmail.com
 * TODO：网络请求基类
 */
class HttpClient {
    companion object httpClient {

        private fun okHttpClient(headerMap: MutableMap<String, String> = mutableMapOf()): OkHttpClient {
            var logLevel = HttpLoggingInterceptor.Level.BODY
            var logInterceptor = HttpLoggingInterceptor(object : HttpLoggingInterceptor.Logger {
                override fun log(message: String) {
                    LogUtil.logD(message)
                }
            }).setLevel(logLevel)

            var builder = OkHttpClient.Builder()
            if (!headerMap.isNullOrEmpty()) {
                builder.addInterceptor(object : Interceptor {
                    override fun intercept(chain: Interceptor.Chain): Response {
                        var request = chain.request().newBuilder()
                        for (item in headerMap) {
                            request.addHeader(item.key, item.value)
                        }
                        return chain.proceed(request.build())
                    }
                })
            }

            builder.addInterceptor(logInterceptor)
            builder.callTimeout(30 * 1000, TimeUnit.MILLISECONDS)
            builder.connectTimeout(30 * 1000, TimeUnit.MILLISECONDS)
            builder.readTimeout(30 * 1000, TimeUnit.MILLISECONDS)
            builder.writeTimeout(30 * 1000, TimeUnit.MILLISECONDS)
            builder.build()
            var okHttpClient = builder.build()
            return okHttpClient
        }

        private fun getRetrofit(headerMap: MutableMap<String, String> = mutableMapOf<String, String>()): Retrofit {
            return Retrofit.Builder()
                .baseUrl(ROOT_URL)
                .client(okHttpClient(headerMap))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        var retrofit: Retrofit? = null
        var localHeaderMap: MutableMap<String, String> = mutableMapOf()
        fun <T> getService(
            clazz: Class<T>,
            headerMap: MutableMap<String, String> = mutableMapOf()
        ): T {
            /**该方法第一次被调用*/
            if (null == retrofit) {
                retrofit = getRetrofit(headerMap)
            /**从第二次开始，视请求头是否变化，再决定是否重新创建Retrofit对象*/
            } else if (localHeaderMap !== headerMap) {
                retrofit = getRetrofit(headerMap)
            }else{
                //TODO:预留空间
            }
            localHeaderMap = headerMap
            return retrofit!!.create(clazz)
        }

        /**
         * 因为Retrofit请求里面每个请求接口的API不一样，然后每个API对应的interface也就是
         * homeArticleList()方法
         * 对应的内容不一样，以目前还无法将RetrofitClient.getService()方法和RetrofitClient.requestData()方法融合成一个方法。
         * 但是共同点都是返回一个Observable对象，初步的设想方案是通过动态代理来实现。
         */
        suspend fun <V> requestData(
            mObservable: Observable<BaseData<V>>,
            callBack: CallBack<V>
        ): Disposable {
            return mObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Consumer<BaseData<V>> {
                    override fun accept(basedata: BaseData<V>) {
                        if (null == callBack) {
                            throw NullPointerException("the object CallBack: callBack is NULL")
                        }
                        if (basedata != null && basedata.errorCode == 0) {
                            callBack.success(basedata.data)
                            return
                        }
                        if (basedata == null){
                            callBack.failed(Throwable(basedata.errorMsg))
                            return
                        }
                        if (basedata.errorCode == 0){
                            callBack.failed(Throwable("请求失败，请稍后再试"))
                        }
                    }
                }, object : Consumer<Throwable> {
                    override fun accept(t: Throwable) {
                        LogUtil.logD(t.localizedMessage)
                        if (null == callBack) {
                            throw NullPointerException("the object CallBack: callBack is NULL")
                        }
                        callBack.failed(t)
                    }
                })
        }
    }

    interface CallBack<V> {
        fun success(v: V)
        fun failed(t: Throwable)
    }
}