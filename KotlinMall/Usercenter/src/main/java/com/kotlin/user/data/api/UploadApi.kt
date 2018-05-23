package com.kotlin.user.data.api

import com.kotlin.base.data.protocol.BaseResp
import retrofit2.http.POST
import rx.Observable

/**
 * create by phj at 2018-05-23
 * 简介：
 */
interface UploadApi {
    /*
    获取七牛云上传凭证
 */
    @POST("common/getUploadToken")
    fun getUploadToken(): Observable<BaseResp<String>>
}