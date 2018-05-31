package com.kotlin.order.ui.activity

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.kotlin.base.ui.activity.BaseActivity
import com.kotlin.order.R
import com.kotlin.provider.router.RouterPath

/**
 * create by phj at 2018-05-31
 * 简介：订单确认界面
 */
@Route(path = RouterPath.OrderCenter.PATH_ORDER_CONFIRM)
class OrderConfirmActivity : BaseActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_confirm)
    }

}