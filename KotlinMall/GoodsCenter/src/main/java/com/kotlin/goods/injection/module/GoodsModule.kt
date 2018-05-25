package com.kotlin.goods.injection.module

import com.kotlin.goods.service.GoodsService
import com.kotlin.goods.service.impl.GoodsServiceImpl
import dagger.Module
import dagger.Provides

/**
 * Created by phj on 2018/5/25.
 * 描述：商品Module
 */

@Module
class GoodsModule {

    @Provides
    fun provideGoodservice(goodsService: GoodsServiceImpl): GoodsService {
        return goodsService
    }

}
