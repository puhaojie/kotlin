package com.kotlin.user.presenter

import com.kotlin.base.ext.execute
import com.kotlin.base.presenter.BasePresenter
import com.kotlin.base.rx.BaseSubscriber
import com.kotlin.user.presenter.view.RegisterView
import com.kotlin.user.service.UserService
import javax.inject.Inject

/**
 * created by phj at 2018-05-20
 * 简介：
 */


class RegisterPresenter @Inject constructor(): BasePresenter<RegisterView>() {

    @Inject
    lateinit var userService  : UserService

    fun register(mobile:String,pwd:String,verifyCode:String){
        userService.register(mobile, pwd, verifyCode)
                .execute(object : BaseSubscriber<Boolean>(mView){
                    override fun onNext(t: Boolean) {
                        if (t)
                            mView.onRegisterResult("注册成功")
                    }
                },lifecycleProvider)
//                .observeOn(Schedulers.io())
//                .subscribeOn(AndroidSchedulers.mainThread())
//                .subscribe( object :Subscriber<Boolean>() {
//                    override fun onCompleted() {
//
//                    }
//
//                    override fun onError(e: Throwable?) {
//                    }
//
//                    override fun onNext(t: Boolean?) {
//                        mView.onRegisterResult(mobile+pwd+verifyCode)
//                    }
//                })

    }

}