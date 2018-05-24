package com.kotlin.provider.common

import com.kotlin.base.common.BaseConstant
import com.kotlin.base.utils.AppPrefsUtils

/**
 * create by phj at 2018-05-24
 * 简介：
 */
fun isLogined():Boolean{
    return AppPrefsUtils.getString(BaseConstant.KEY_SP_TOKEN).isNotEmpty()
}