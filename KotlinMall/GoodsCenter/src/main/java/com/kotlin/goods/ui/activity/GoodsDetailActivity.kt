package com.kotlin.goods.ui.activity

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.view.Gravity
import com.eightbitlab.rxbus.Bus
import com.eightbitlab.rxbus.registerInBus
import com.kotlin.base.ext.onClick
import com.kotlin.base.ui.activity.BaseActivity
import com.kotlin.base.utils.AppPrefsUtils
import com.kotlin.goods.R
import com.kotlin.goods.common.GoodsConstant
import com.kotlin.goods.event.AddCartEvent
import com.kotlin.goods.event.UpdateCartSizeEvent
import com.kotlin.goods.ui.adapter.GoodsDetailVpAdapter
import com.kotlin.provider.common.afterLogin
import kotlinx.android.synthetic.main.activity_goods_detail.*
import q.rorbin.badgeview.QBadgeView

/**
 * create by phj at 2018-05-28
 * 简介：商品详情Activity
 */
class GoodsDetailActivity:BaseActivity() {

    private lateinit var mCartBadge: QBadgeView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_goods_detail)
        initView()
        initObserve()
        loadCartSize()
    }

    /**
     * init View
     */
    private fun initView() {
        mGoodsDetailTab.tabMode = TabLayout.MODE_FIXED
        mGoodsDetailVp.adapter = GoodsDetailVpAdapter(supportFragmentManager,this)
        //TabLayout关联ViewPager
        mGoodsDetailTab.setupWithViewPager(mGoodsDetailVp)

        mAddCartBtn.onClick {
            afterLogin {
                Bus.send(AddCartEvent())
            }
        }

        mEnterCartTv.onClick {
//            startActivity<CartActivity>()
        }

        mLeftIv.onClick {
            finish()
        }

        mCartBadge = QBadgeView(this)
    }

    /**
     * 加载购物车大小
     */
    private fun loadCartSize() {
        setCartBadge()
    }


    /**
     * init 观察者
     */
    private fun initObserve() {
        Bus.observe<UpdateCartSizeEvent>()
                .subscribe {
                    setCartBadge()
                }.registerInBus(this)
    }

    /*
        设置购物车标签
     */
    private fun setCartBadge() {
        mCartBadge.badgeGravity = Gravity.END or Gravity.TOP
        mCartBadge.setGravityOffset(22f,-2f,true)
        mCartBadge.setBadgeTextSize(6f,true)
        mCartBadge.bindTarget(mEnterCartTv).badgeNumber = AppPrefsUtils.getInt(GoodsConstant.SP_CART_SIZE)

    }

    /*
        Bus取消监听
     */
    override fun onDestroy() {
        super.onDestroy()
        Bus.unregister(this)
    }


}