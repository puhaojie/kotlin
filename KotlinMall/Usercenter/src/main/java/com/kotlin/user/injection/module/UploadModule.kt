package com.kotlin.user.injection.module

import com.kotlin.user.service.UploadService
import com.kotlin.user.service.impl.UploadServiceImpl
import dagger.Module
import dagger.Provides

/**
 * create by phj at 2018-05-20
 * 简介：
 */
@Module
class UploadModule {

    @Provides
    fun providesUploadService(serviceImpl: UploadServiceImpl): UploadService {
        return serviceImpl
    }

}