package com.ilosipov.news_app.data

import java.util.*

/**
 * Class NewsItem
 * @author Ilya Osipov (mailto:il.osipov.gm@gmail.com)
 * @since 18.11.2020
 * @version $Id$
 */

data class NewsItem(
        val id: Int,
        val title: String,
        val userName: String,
        val newsImg: String,
        val userImg: String,
        val content: String,
        val bgColor: String,
        val dateCreation: Date,
        val viewType: Int,
        val videoUrl: String,
        var isFav: Boolean = false
)