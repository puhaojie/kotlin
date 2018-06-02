package com.kotlin.base.ui.activity

import android.os.Bundle
import android.os.PersistableBundle
import com.alibaba.android.arouter.launcher.ARouter
import com.kotlin.base.common.BaseApplication
import com.kotlin.base.injection.component.ActivityComponent
import com.kotlin.base.injection.component.DaggerActivityComponent
import com.kotlin.base.injection.module.ActivityModule
import com.kotlin.base.injection.module.LifecycleProviderModule
import com.kotlin.base.presenter.BasePresenter
import com.kotlin.base.presenter.view.BaseView
import com.kotlin.base.widgets.ProgressLoading
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

    lateinit var progressLoading : ProgressLoading

    public override  fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        progressLoading = ProgressLoading.create(this)
        initActivityInjection()
        injectComponent()
        //ARouter注册
        ARouter.getInstance().inject(this)
    }

    abstract fun injectComponent()

    private fun initActivityInjection() {
        activityComponent = DaggerActivityComponent.builder()
                .appComponent((application as BaseApplication).appComponent)
                .lifecycleProviderModule(LifecycleProviderModule(this))
                .activityModule(ActivityModule(this))
                .build()

    }

    override fun showLoading() {
        progressLoading.showLoading()
    }

    override fun hideLoading() {
            progressLoading.hideLoading()

    }

    override fun onError(text: String) {
        toast(text)
    }

}