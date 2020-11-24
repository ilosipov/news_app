package com.ilosipov.news_app.adapters.news

import com.ilosipov.news_app.adapters.BaseViewHolder
import com.ilosipov.news_app.data.NewsItem
import com.ilosipov.news_app.databinding.ItemNewsImageBinding
import com.ilosipov.news_app.databinding.ItemNewsTextBinding


/**
 * Class TextViewHolder
 * @author Ilya Osipov (mailto:il.osipov.gm@gmail.com)
 * @since 18.11.2020
 * @version $Id$
 */

class TextViewHolder(private var itemNewsTextBinding: ItemNewsTextBinding)
    : BaseViewHolder(itemNewsTextBinding.root) {

    override fun bindData(item: NewsItem) {
        itemNewsTextBinding.newsItemText = item
    }

    override fun getItemNewsTextBinding(): ItemNewsTextBinding? {
        return null
    }

    override fun getItemNewsImageBinding(): ItemNewsImageBinding? {
        return null
    }

}