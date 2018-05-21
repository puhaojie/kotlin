package com.kotlin.user.service.impl

import com.kotlin.base.ext.convertBoolean
import com.kotlin.base.rx.BaseFuncBoolean
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
}