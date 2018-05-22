package com.kotlin.user.service.impl

import com.kotlin.base.ext.convert
import com.kotlin.base.ext.convertBoolean
import com.kotlin.base.rx.BaseFuncBoolean
import com.kotlin.user.data.protocol.UserInfo
import com.kotlin.user.data.repository.UserRepository
import com.kotlin.user.service.UserService
import rx.Observable
import javax.inject.Inject

/**
 * create by phj at 2018-05-20
 * 简介：用户相关的业务接口实现
 */
class UserServiceImpl @Inject constructor(): UserService {

    @Inject
    lateinit var userRepository : UserRepository

    override fun register(mobile: String, pwd: String, verifyCode: String)
       :Observable<Boolean>{
        return userRepository.register(mobile, pwd, verifyCode)
                .convertBoolean()
    }


    /*
    登录
 */
    override fun login(mobile: String, pwd: String, pushId: String): Observable<UserInfo> {
        return userRepository.login(mobile, pwd, pushId).convert()
    }

    /*
        忘记密码
     */
    override fun forgetPwd(mobile: String, verifyCode: String): Observable<Boolean> {
        return userRepository.forgetPwd(mobile, verifyCode).convertBoolean()
    }

    /*
        重置密码
     */
    override fun resetPwd(mobile: String, pwd: String): Observable<Boolean> {
        return userRepository.resetPwd(mobile, pwd).convertBoolean()
    }

    /*
        修改用户资料
     */
    override fun editUser(userIcon: String, userName: String, userGender: String, userSign: String): Observable<UserInfo> {
        return userRepository.editUser(userIcon,userName,userGender,userSign).convert()
    }

}