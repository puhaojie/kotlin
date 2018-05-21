package com.kotlin.base.presenter.view

/**
 * created by phj at
 * 简介：
 */

interface BaseView {

    fun showLoading()

    fun hideLoading()

    fun onError(text:String)
}