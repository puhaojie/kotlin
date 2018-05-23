package com.kotlin.user.service.impl

import com.kotlin.base.ext.convert
import com.kotlin.user.data.repository.UploadRepository
import com.kotlin.user.service.UploadService
import rx.Observable
import javax.inject.Inject

/**
 * create by phj at 2018-05-20
 * 简介：上传的业务接口实现
 */
class UploadServiceImpl @Inject constructor(): UploadService {

    @Inject
    lateinit var userRepository : UploadRepository


    override fun getUploadToken(): Observable<String> {
        return userRepository.getUploadToken().convert()
    }



}