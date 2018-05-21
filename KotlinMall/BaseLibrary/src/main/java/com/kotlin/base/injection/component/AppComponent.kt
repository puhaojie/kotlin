package com.kotlin.base.injection.component

import android.content.Context
import com.kotlin.base.injection.module.AppModule
import dagger.Component
import javax.inject.Singleton

/**
 * create by phj at 2018-05-21
 * 简介：
 */
@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {
    fun context():Context


}