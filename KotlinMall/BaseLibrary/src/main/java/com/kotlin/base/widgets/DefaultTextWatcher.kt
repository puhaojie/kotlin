package com.kotlin.base.widgets

import android.text.Editable
import android.text.TextWatcher

/**
 * create by phj at 2018-05-21
 * 简介：
 */
/*
    默认TextWatcher，空实现
 */
open class DefaultTextWatcher: TextWatcher {
    override fun afterTextChanged(s: Editable?) {
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
    }
}