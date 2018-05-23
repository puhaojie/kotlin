package com.kotlin.user.service

import rx.Observable

/**
 * create by phj at 2018-05-23
 * 简介：上传的Service
 */
interface UploadService {

    fun getUploadToken(): Observable<String>

}