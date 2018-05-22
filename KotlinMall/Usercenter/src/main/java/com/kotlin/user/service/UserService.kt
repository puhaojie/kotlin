package com.kotlin.user.service

import com.kotlin.user.data.protocol.UserInfo
import rx.Observable

/**
 * create by phj at 2018-05-20
 * 简介：用户相关的业务接口
 */
interface UserService {

    /**
     * 注册
     */
    fun register(mobile:String,pwd:String,verifyCode:String):Observable<Boolean>

    //用户登录
    fun login(mobile:String,pwd:String,pushId:String):Observable<UserInfo>

    //忘记密码
    fun forgetPwd(mobile:String,verifyCode:String):Observable<Boolean>

    //重置密码
    fun resetPwd(mobile:String,pwd:String):Observable<Boolean>

    //编辑用户资料
    fun editUser(userIcon:String,userName:String,userGender:String,userSign:String):Observable<UserInfo>
}