package com.ilosipov.news_app.util

import android.content.Context
import android.content.SharedPreferences

/**
 * Class AppSettings
 * @author Ilya Osipov (mailto:il.osipov.gm@gmail.com)
 * @since 09.12.2020
 * @version $Id$
 */

class AppSettings(context: Context) {

    private var prefs: SharedPreferences = context.getSharedPreferences("pref_app", Context.MODE_PRIVATE)
    private var theme: Int = prefs.getInt(THEME_KEY, 2)

    companion object {
        const val THEME_KEY = "news_app_theme"
        const val THEME_LIGHT = 0
        const val THEME_DARK = 1
        const val THEME_SYSTEM = 2
    }

    fun getTheme(): Int = theme

    fun setTheme(theme: Int) {
        this.theme = theme
        prefs.edit().putInt(THEME_KEY, theme).apply()
    }
}