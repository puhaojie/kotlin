package com.kotlin.base.ext

import android.view.View
import android.widget.Button
import android.widget.EditText
import com.kotlin.base.data.protocol.BaseResp
import com.kotlin.base.rx.BaseFunc
import com.kotlin.base.rx.BaseFuncBoolean
import com.kotlin.base.rx.BaseSubscriber
import com.kotlin.base.widgets.DefaultTextWatcher
import com.trello.rxlifecycle.LifecycleProvider
import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * create by phj at 2018-05-20
 * 简介：kotlin 中的扩展方法
 */
fun <T> Observable<T>.execute(subscriber: BaseSubscriber<T>,lifecycleProvider : LifecycleProvider<*>){

    this.observeOn(AndroidSchedulers.mainThread())
            .compose(lifecycleProvider.bindToLifecycle())
            .subscribeOn(Schedulers.io())
            .subscribe( subscriber)
}

/*
    扩展数据转换
 */
fun <T> Observable<BaseResp<T>>.convert():Observable<T>{
    return this.flatMap(BaseFunc())
}

/*
    扩展Boolean类型数据转换
 */
fun <T> Observable<BaseResp<T>>.convertBoolean():Observable<Boolean>{
    return this.flatMap(BaseFuncBoolean())
}

/**
 * 点击事件扩展
 */
fun View.onClick(listener : View.OnClickListener){
    this.setOnClickListener(listener)
}

fun View.onClick(method : ()->Unit){
    this.setOnClickListener{method()}
}

/**
 *  扩展Button可用性
 */
fun Button.enable(et: EditText, method: () -> Boolean){
    val btn = this
    et.addTextChangedListener(object : DefaultTextWatcher(){
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            btn.isEnabled = method()
        }
    })

}