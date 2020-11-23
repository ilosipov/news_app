package com.ilosipov.news_app.adapters.news

import androidx.recyclerview.widget.DiffUtil
import com.ilosipov.news_app.data.NewsItem

/**
 * Class DiffUtilNewsItemCallback
 * @author Ilya Osipov (mailto:il.osipov.gm@gmail.com)
 * @since 23.11.2020
 * @version $Id$
 */

class DiffUtilNewsItemCallback : DiffUtil.ItemCallback<NewsItem>() {

    override fun areItemsTheSame(oldItem: NewsItem, newItem: NewsItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: NewsItem, newItem: NewsItem): Boolean {
        return oldItem.id == newItem.id
    }
}