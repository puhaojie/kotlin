package com.kotlin.base.presenter

import com.kotlin.base.presenter.view.BaseView

/**
 * 基础的Presenter
 */
open class BasePresenter<V:BaseView> {

    lateinit var mView:V

}