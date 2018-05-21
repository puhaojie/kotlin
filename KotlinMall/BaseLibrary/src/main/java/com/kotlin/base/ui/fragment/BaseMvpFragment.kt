package com.kotlin.base.ui.fragment

import android.os.Bundle
import com.kotlin.base.common.BaseApplication
import com.kotlin.base.injection.component.ActivityComponent
import com.kotlin.base.injection.component.DaggerActivityComponent
import com.kotlin.base.injection.module.ActivityModule
import com.kotlin.base.injection.module.LifecycleProviderModule
import com.kotlin.base.presenter.BasePresenter
import com.kotlin.base.presenter.view.BaseView
import org.jetbrains.anko.support.v4.toast
import javax.inject.Inject

/**
 * created by phj at 2018-05-20
 * 简介：基础的基于MVP的Fragment
 */


abstract class BaseMvpFragment<Presenter : BasePresenter<*>>: BaseFragment(), BaseView {

    @Inject
    lateinit var mPresenter : Presenter

    lateinit var activityComponent : ActivityComponent

    public override  fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initActivityInjection()
        injectComponent()

    }

    abstract fun injectComponent()

    private fun initActivityInjection() {
        activityComponent = DaggerActivityComponent.builder()
                .appComponent((activity!!.application as BaseApplication).appComponent)
                .lifecycleProviderModule(LifecycleProviderModule(this))
                .activityModule(ActivityModule(activity!!))
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