package com.kotlin.user.ui.activity

import android.os.Bundle
import android.view.View
import com.kotlin.base.ext.enable
import com.kotlin.base.ext.onClick
import com.kotlin.base.ui.activity.BaseMvpActivity
import com.kotlin.user.R
import com.kotlin.user.data.protocol.UserInfo
import com.kotlin.user.injection.component.DaggerUserComponent
import com.kotlin.user.injection.module.UserModule
import com.kotlin.user.presenter.LoginPresenter
import com.kotlin.user.presenter.view.LoginView
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

/**
 * Created by phj on 10:08.
 * 描述：登录界面
 */
class LoginActivity : BaseMvpActivity<LoginPresenter>() , LoginView, View.OnClickListener{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        initView()
    }

    private fun initView() {
        mLoginBtn.enable(mMobileEt,{isBtnEnable()})
        mLoginBtn.enable(mPwdEt,{isBtnEnable()})

        mLoginBtn.onClick(this)
        mHeaderBar.getRightView().onClick(this)
        mForgetPwdTv.onClick(this)
    }

    override fun onLoginResult(result: UserInfo) {
        toast("登录成功")
    }

    /*
    判断按钮是否可用
    */
    private fun isBtnEnable():Boolean{
        return mMobileEt.text.isNullOrEmpty().not() &&
                mPwdEt.text.isNullOrEmpty().not()
    }

    override fun injectComponent() {
        DaggerUserComponent
                .builder()
                .activityComponent(activityComponent)//添加activity级别的Component
                .userModule(UserModule())
                .build()
                .inject(this)

        mPresenter.mView = this
    }

    override fun onClick(view: View) {
        when(view.id){
            R.id.mRightTv -> {startActivity<RegisterActivity>()}

            R.id.mLoginBtn -> {
                mPresenter.login(mMobileEt.text.toString(),mPwdEt.text.toString(),"")
            }
            R.id.mForgetPwdTv -> {
                startActivity<ForgetPwdActivity>()
            }
        }
    }

}