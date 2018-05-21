package com.kotlin.base.injection.module

import android.app.Activity
import com.kotlin.base.injection.ActivityScope
import dagger.Module
import dagger.Provides

/**
 * create by phj at 2018-05-21
 * 简介：
 */
@Module
class ActivityModule(private val activity : Activity) {

    @ActivityScope
    @Provides
    fun providesActivity(): Activity {
        return activity
    }

}
