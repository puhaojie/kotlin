package com.kotlin.base.rx

import com.kotlin.base.common.ResultCode
import com.kotlin.base.data.protocol.BaseResp
import rx.Observable
import rx.functions.Func1

/**
 * create by phj at 2018-05-21
 * 简介：
 */
class BaseFunc<T>: Func1<BaseResp<T>, Observable<T>> {

    override fun call(t: BaseResp<T>): Observable<T> {
        if (t.status != ResultCode.SUCCESS)
            return Observable.error(BaseException(t.status, t.message))
        return Observable.just(t.data)
    }
}