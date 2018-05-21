package com.kotlin.base.data.protocol

/**
 * create by phj at 2018-05-20
 * 简介：网络数据，返回的基本数据结构
 */
data class BaseResp<out T>(val status:Int,val message:String,val data:T)