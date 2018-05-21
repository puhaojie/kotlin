package com.kotlin.base.ui.activity

import android.os.Bundle
import android.os.PersistableBundle
import com.kotlin.base.common.BaseApplication
import com.kotlin.base.injection.component.ActivityComponent
import com.kotlin.base.injection.component.DaggerActivityComponent
import com.kotlin.base.injection.module.ActivityModule
import com.kotlin.base.presenter.BasePresenter
import com.kotlin.base.presenter.view.BaseView
import org.jetbrains.anko.toast
import javax.inject.Inject


/**
 * created by phj at 2018-05-20
 * 简介：基础的基于MVP的Activity
 */


abstract class BaseMvpActivity<Presenter : BasePresenter<*>>: BaseActivity(),BaseView {

    @Inject
    lateinit var mPresenter : Presenter

    lateinit var activityComponent : ActivityComponent

    public override  fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initActivityInjection()
    }

    private fun initActivityInjection() {
        activityComponent = DaggerActivityComponent.builder().appComponent((application as BaseApplication).appComponent)
                .activityModule(ActivityModule(this))
                .build()

    }

    override fun showLoading() {

    }

    override fun hideLoading() {
    }

    override fun onError(text: String) {
        toast(text)
    }

}