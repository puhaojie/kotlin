package com.kotlin.user.service.impl

import com.kotlin.base.data.protocol.BaseResp
import com.kotlin.base.ext.execute
import com.kotlin.base.rx.BaseException
import com.kotlin.base.rx.BaseSubscriber
import com.kotlin.user.data.repository.UserRepository
import com.kotlin.user.service.UserService
import rx.Observable
import rx.functions.Func1
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
                .flatMap (object : Func1<BaseResp<String>,Observable<Boolean>>{
                    override fun call(t: BaseResp<String>): Observable<Boolean> {
                        if (t.status == 0){
                            return Observable.just(true)
                        }

                        return Observable.error(BaseException(t.status,t.message))
                    }
                })
    }
}