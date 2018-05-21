package com.kotlin.user.injection.module

import com.kotlin.user.service.UserService
import com.kotlin.user.service.impl.UserServiceImpl
import dagger.Module
import dagger.Provides

/**
 * create by phj at 2018-05-20
 * 简介：
 */
@Module
class UserModule  {

    @Provides
    fun providesUserService(serviceImpl: UserServiceImpl):UserService{
        return serviceImpl
    }

}