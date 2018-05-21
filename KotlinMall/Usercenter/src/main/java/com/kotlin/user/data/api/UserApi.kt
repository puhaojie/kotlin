package com.kotlin.user.data.api

import com.kotlin.base.data.protocol.BaseResp
import com.kotlin.user.data.protocol.RegisterReq
import retrofit2.http.Body
import retrofit2.http.POST
import rx.Observable

/**
 * create by phj at 2018-05-20
 * 简介：用户有关的网络请求API
 */
interface UserApi {
    /*
      用户注册
   */
    @POST("userCenter/register")
    fun register(@Body req: RegisterReq): Observable<BaseResp<String>>
}