package com.ilosipov.news_app

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import com.ilosipov.news_app.util.AppSettings

/**
 * Class App
 * @author Ilya Osipov (mailto:il.osipov.gm@gmail.com)
 * @since 09.12.2020
 * @version $Id$
 */

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        when (AppSettings(this).getTheme()) {
            AppSettings.THEME_LIGHT -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            AppSettings.THEME_DARK -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            AppSettings.THEME_SYSTEM -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.getDefaultNightMode())
            else -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.getDefaultNightMode())
        }
    }
}