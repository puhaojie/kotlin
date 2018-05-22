package com.kotlin.user.injection.component

import com.kotlin.base.injection.PerComponentScope
import com.kotlin.base.injection.component.ActivityComponent
import com.kotlin.user.injection.module.UserModule
import com.kotlin.user.ui.activity.ForgetPwdActivity
import com.kotlin.user.ui.activity.LoginActivity
import com.kotlin.user.ui.activity.RegisterActivity
import com.kotlin.user.ui.activity.ResetPwdActivity
import dagger.Component

/**
 * create by phj at 2018-05-20
 * 简介：
 */
@PerComponentScope
@Component(dependencies = arrayOf(ActivityComponent::class),modules = arrayOf(UserModule::class))
interface UserComponent {
    fun inject(activity: RegisterActivity)

    fun inject(activity: LoginActivity)

    fun  inject(activity: ForgetPwdActivity)

    fun inject(activity: ResetPwdActivity)
}