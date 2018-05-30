package com.kotlin.goods.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kotlin.base.ext.setVisible
import com.kotlin.base.ui.fragment.BaseMvpFragment
import com.kotlin.goods.R
import com.kotlin.goods.data.protocol.CartGoods
import com.kotlin.goods.injection.component.DaggerCartComponent
import com.kotlin.goods.injection.module.CartModule
import com.kotlin.goods.presenter.CartListPresenter
import com.kotlin.goods.presenter.view.CartListView
import kotlinx.android.synthetic.main.fragment_cart.*

/**
 * create by phj at 2018-05-30
 * 简介：购物车界面
 */
class CartFragment : BaseMvpFragment<CartListPresenter>(), CartListView {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_cart, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initObserve()
    }

    /**
     *  初始化界面
     */
    private fun initView(){

    }

    /**
     * RxBus观察者注册
     */
    private fun initObserve(){

    }

    override fun injectComponent() {
        DaggerCartComponent.builder().activityComponent(activityComponent).cartModule(CartModule()).build().inject(this)
        mPresenter.mView = this
    }

    override fun onGetCartListResult(result: MutableList<CartGoods>?) {

    }

    override fun onDeleteCartListResult(result: Boolean) {
    }

    override fun onSubmitCartListResult(result: Int) {
    }


    /*
        设置Back是否可见
    */
    fun setBackVisible(isVisible:Boolean){
        mHeaderBar.getLeftView().setVisible(isVisible)
    }
}