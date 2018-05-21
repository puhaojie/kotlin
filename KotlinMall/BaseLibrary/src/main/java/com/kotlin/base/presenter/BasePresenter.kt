package com.kotlin.base.presenter

import com.kotlin.base.presenter.view.BaseView
import com.trello.rxlifecycle.LifecycleProvider
import javax.inject.Inject

/**
 * 基础的Presenter
 */
open class BasePresenter<V:BaseView> {

    @Inject
    lateinit var lifecycleProvider: LifecycleProvider<*>

    lateinit var mView:V

}