package com.kotlin.base.injection

import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import javax.inject.Scope
/**
 * create by phj at 2018-05-21
 * 简介：标识一个Activity所用的Scope
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
annotation class ActivityScope