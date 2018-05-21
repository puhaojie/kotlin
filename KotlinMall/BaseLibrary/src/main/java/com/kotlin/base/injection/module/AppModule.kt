package com.kotlin.base.injection.module

import android.content.Context
import com.kotlin.base.common.BaseApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * create by phj at 2018-05-21
 * 简介：
 */
@Module
class AppModule(private val context : BaseApplication) {

    @Singleton
    @Provides
    fun providesContext(): Context {
        return context
    }

}