package com.kotlin.user.service

import rx.Observable

/**
 * create by phj at 2018-05-20
 * 简介：用户相关的业务接口
 */
interface UserService {

    fun register(mobile:String,pwd:String,verifyCode:String):Observable<Boolean>

}