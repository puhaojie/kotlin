package com.kotlin.mall.ui.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import com.ashokvarma.bottomnavigation.BottomNavigationBar
import com.eightbitlab.rxbus.Bus
import com.eightbitlab.rxbus.registerInBus
import com.kotlin.base.common.AppManager
import com.kotlin.base.utils.AppPrefsUtils
import com.kotlin.goods.common.GoodsConstant
import com.kotlin.goods.event.UpdateCartSizeEvent
import com.kotlin.goods.ui.fragment.CartFragment
import com.kotlin.goods.ui.fragment.CategoryFragment
import com.kotlin.mall.R
import com.kotlin.mall.ui.fragment.HomeFragment
import com.kotlin.mall.ui.fragment.MeFragment
import com.kotlin.message.ui.fragment.MessageFragment
import com.kotlin.provider.event.MessageBadgeEvent
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast
import java.util.*

class MainActivity : AppCompatActivity() {

    private var pressTime: Long = 0
    //Fragment 栈管理
    private val mStack = Stack<Fragment>()
    //主界面Fragment
    private val mHomeFragment by lazy { HomeFragment() }
    //商品分类Fragment
    private val mCategoryFragment by lazy { CategoryFragment() }
    //购物车Fragment
    private val mCartFragment by lazy { CartFragment() }
    //消息Fragment
    private val mMsgFragment by lazy { MessageFragment() }
    //"我的"Fragment
    private val mMeFragment by lazy { MeFragment() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initFragment()
        initBottomNav()
        initObserve()
        changeFragment(0)


    }

    private fun initBottomNav() {
        mBottomNavBars.setTabSelectedListener(object : BottomNavigationBar.OnTabSelectedListener{
            override fun onTabReselected(position: Int) {

            }

            override fun onTabUnselected(position: Int) {
            }

            override fun onTabSelected(position: Int) {
                changeFragment(position)
            }

        })
        mBottomNavBars.checkMsgBadge(false)
    }

    /**
     *  初始化Fragment
     */
    private fun initFragment() {
        val manager = supportFragmentManager.beginTransaction()
        manager.add(R.id.mContaier, mHomeFragment)
        manager.add(R.id.mContaier, mCategoryFragment)
        manager.add(R.id.mContaier, mCartFragment)
        manager.add(R.id.mContaier, mMsgFragment)
        manager.add(R.id.mContaier, mMeFragment)
        manager.commit()

        mStack.add(mHomeFragment)
        mStack.add(mCategoryFragment)
        mStack.add(mCartFragment)
        mStack.add(mMsgFragment)
        mStack.add(mMeFragment)

    }

    /*
    初始化监听，购物车数量变化及消息标签是否显示
 */
    private fun initObserve(){
        Bus.observe<UpdateCartSizeEvent>()
                .subscribe {
                    loadCartSize()
                }.registerInBus(this)

        Bus.observe<MessageBadgeEvent>()
                .subscribe {
                    t: MessageBadgeEvent ->
                    run {
                        mBottomNavBars.checkMsgBadge(t.isVisible)
                    }
                }.registerInBus(this)
    }

    /**
     *  提供Fragment切换方法啊
     */
    private fun changeFragment(position: Int) {
        val manager = supportFragmentManager.beginTransaction()
        for (fragment in mStack) {
            manager.hide(fragment)
        }

        manager.show(mStack[position])
        manager.commit()
    }

    /*
        加载购物车数量
    */
    private fun loadCartSize(){
        mBottomNavBars.checkCartBadge(AppPrefsUtils.getInt(GoodsConstant.SP_CART_SIZE))
    }

    /*
        取消Bus事件监听
     */
    override fun onDestroy() {
        super.onDestroy()
        Bus.unregister(this)
    }


    /**
     *  返回键处理
     */
    override fun onBackPressed() {
        val time = System.currentTimeMillis()
        if (time - pressTime > 2000){
            toast("再按一次退出程序")
            pressTime = time
        } else{
            AppManager.instance.exitApp(this)
        }
    }
}
