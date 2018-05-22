package com.kotlin.user.presenter.view

import com.kotlin.base.presenter.view.BaseView

/**
 * Created by phj on 2018/5/22.
 * 描述：忘记密码 视图回调
 */

interface ForgetPwdView : BaseView {

    /*
        忘记密码回调
     */
    fun onForgetPwdResult(result:String)
}
