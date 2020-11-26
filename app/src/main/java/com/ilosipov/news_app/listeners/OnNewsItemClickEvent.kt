package com.ilosipov.news_app.listeners

import android.view.View

/**
 * OnNewsItemClickEvent
 * @author Ilya Osipov (mailto:il.osipov.gm@gmail.com)
 * @since 19.11.2020
 * @version $Id$
 */

interface OnNewsItemClickEvent {
    fun onItemClick(view: View, position: Int)
}