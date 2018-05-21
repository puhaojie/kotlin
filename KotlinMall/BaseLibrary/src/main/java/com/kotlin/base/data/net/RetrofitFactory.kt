package com.kotlin.base.data.net

import android.util.Log
import com.kotlin.base.common.BaseConstant
import com.kotlin.base.utils.AppPrefsUtils
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * create by phj at 2018-05-20
 * 简介： 网络请求创建工厂
 */
class RetrofitFactory private constructor() {

    private val TAG = "RetrofitFactory"

    // 伴生对象 生成单例 by lazy 就是线程安全的
    companion object {
        val instance :RetrofitFactory by lazy { RetrofitFactory() }
    }

    private var retrofit : Retrofit
    private val interceptor: Interceptor

    init {

        interceptor = Interceptor {
            chain ->
            val  request = chain.request()
                    .newBuilder()
                    .addHeader("Content-Type","application/json")
                    .addHeader("charset","utf-8")
//                    .addHeader("token", AppPrefsUtils.getString(BaseConstant.KEY_SP_TOKEN))
                    .build()
            chain.proceed(request)
        }

        retrofit = Retrofit.Builder()
                .baseUrl(BaseConstant.SERVER_ADDRESS)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(initClient())
                .build()
    }

    private fun initClient(): OkHttpClient {
        return OkHttpClient
                .Builder()
                .addInterceptor(interceptor)
                .addInterceptor(initLogInterceptor())
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .build()
    }

    /**
     *  创建日志拦截器方法
     */
    private fun initLogInterceptor(): Interceptor {
        return HttpLoggingInterceptor(HttpLoggingInterceptor.Logger {
            message ->  Log.d(TAG,message)
        }).setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    // 外部访问的接口
    fun <T> create(service:Class<T>) : T{
        return retrofit.create(service)
    }

}