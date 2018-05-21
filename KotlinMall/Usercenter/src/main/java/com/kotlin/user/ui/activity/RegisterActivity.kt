package com.kotlin.user.ui.activity

import android.os.Bundle
import com.kotlin.base.ui.activity.BaseMvpActivity
import com.kotlin.user.R
import com.kotlin.user.injection.component.DaggerUserComponent
import com.kotlin.user.injection.module.UserModule
import com.kotlin.user.presenter.RegisterPresenter
import com.kotlin.user.presenter.view.RegisterView
import kotlinx.android.synthetic.main.activity_register.*
import org.jetbrains.anko.toast

class RegisterActivity : BaseMvpActivity<RegisterPresenter>() , RegisterView{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        initInjection()
        initView()


    }

    private fun initInjection() {
        DaggerUserComponent
                .builder()
                .activityComponent(activityComponent)//添加activity级别的Component
                .userModule(UserModule())
                .build()
                .inject(this)

        mPresenter.mView = this
    }

    /*
        初始化视图
     */
    private fun initView() {
//        mPresenter = RegisterPresenter()

        mRegisterBtn.setOnClickListener {
            mPresenter.register(mMobileEt.text.toString(),mPwdEt.text.toString(),mVerifyCodeEt.text.toString())
        }
    }


    /*
        注册回调
     */
    override fun onRegisterResult(result: Boolean) {
        toast("成功")
        finish() 
    }


}
