package com.kotlin.base.injection

import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import javax.inject.Scope

/**
 * create by phj at 2018-05-21
 * 简介：组件级别的作用域
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
annotation class PerComponentScope