package com.kotlin.base.common

import android.app.Application
import android.content.Context
import com.kotlin.base.injection.component.AppComponent
import com.kotlin.base.injection.component.DaggerAppComponent
import com.kotlin.base.injection.module.AppModule

/**
 * create by phj at 2018-05-20
 * 简介：
 */
class BaseApplication : Application() {

    lateinit var appComponent: AppComponent

    /*
     全局伴生对象
  */
    companion object {
        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()
        context = this
        initAppInjection()
    }

    private fun initAppInjection() {
        appComponent = DaggerAppComponent.builder().appModule(AppModule(this)).build()
    }
}