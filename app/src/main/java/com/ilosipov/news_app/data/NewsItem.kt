package com.ilosipov.news_app.data

import java.util.*

/**
 * Class NewsItem
 * @author Ilya Osipov (mailto:il.osipov.gm@gmail.com)
 * @since 18.11.2020
 * @version $Id$
 */

data class NewsItem(
        var id: Int,
        var title: String?,
        var userName: String?,
        var newsImg: String?,
        var userImg: String?,
        var content: String?,
        var bgColor: String?,
        var dateCreation: Date?,
        var viewType: Int
)