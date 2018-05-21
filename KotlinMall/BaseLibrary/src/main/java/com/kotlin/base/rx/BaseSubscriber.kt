package com.kotlin.base.rx

import com.kotlin.base.presenter.view.BaseView
import rx.Subscriber

/**
 * create by phj at 2018-05-20
 * 简介：
 */
open class BaseSubscriber<T>(private val mView : BaseView) : Subscriber<T>() {
    override fun onNext(t: T) {

    }

    override fun onCompleted() {

    }

    override fun onError(e: Throwable) {
        if (e is BaseException)
            mView.onError(e.msg)
    }
}