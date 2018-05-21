package com.kotlin.base.ext

import com.kotlin.base.rx.BaseSubscriber
import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * create by phj at 2018-05-20
 * 简介：kotlin 中的扩展方法
 */
fun <T> Observable<T>.execute(subscriber: BaseSubscriber<T>){

    this.observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe( subscriber)
}