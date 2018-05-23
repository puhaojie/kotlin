package com.kotlin.user.data.repository

import com.kotlin.base.data.net.RetrofitFactory
import com.kotlin.base.data.protocol.BaseResp
import com.kotlin.user.data.api.UploadApi
import rx.Observable
import javax.inject.Inject

/**
 * create by phj at 2018-05-23
 * 简介：上传Repository
 */
class UploadRepository @Inject constructor(){

    /*
    获取七牛云上传凭证
 */
    fun getUploadToken(): Observable<BaseResp<String>> {
        return RetrofitFactory.instance.create(UploadApi::class.java).getUploadToken()
    }
}