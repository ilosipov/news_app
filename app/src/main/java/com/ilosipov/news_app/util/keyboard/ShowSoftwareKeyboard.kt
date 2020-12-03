package com.ilosipov.news_app.util.keyboard

import android.app.Activity
import android.content.Context.INPUT_METHOD_SERVICE
import android.view.inputmethod.InputMethodManager

/**
 * Class ShowSoftwareKeyboard
 * @author Ilya Osipov (mailto:il.osipov.gm@gmail.com)
 * @since 03.12.2020
 * @version $Id$
 */

class ShowSoftwareKeyboard(private val context: Activity) : ShowKeyboard {

    private val inputMethod = context.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager?

    override fun isShow(isVisibility: Boolean) {
        inputMethod?.hideSoftInputFromWindow(context.currentFocus?.windowToken,
                if (isVisibility) InputMethodManager.SHOW_FORCED else InputMethodManager.HIDE_NOT_ALWAYS)
    }
}