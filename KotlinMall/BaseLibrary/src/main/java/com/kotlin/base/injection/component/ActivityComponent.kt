package com.kotlin.base.injection.component

import android.app.Activity
import android.content.Context
import com.kotlin.base.injection.ActivityScope
import com.kotlin.base.injection.module.ActivityModule
import dagger.Component

/**
 * create by phj at 2018-05-21
 * 简介：Activity 的 Component
 */
@ActivityScope
@Component(modules = arrayOf(ActivityModule::class),dependencies = arrayOf(AppComponent::class))
interface ActivityComponent {
    fun context(): Context

    fun activity(): Activity
}