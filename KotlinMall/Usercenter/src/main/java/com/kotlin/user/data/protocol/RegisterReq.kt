package com.kotlin.user.data.protocol

/**
 * create by phj at 2018-05-20
 * 简介：注册请求实体类
 */
data class RegisterReq(val mobile:String,val pwd:String,val verifyCode:String)