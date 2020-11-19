package com.ilosipov.news_app.ui.news

import com.ilosipov.news_app.data.NewsItem
import com.ilosipov.news_app.databinding.ItemNewsImageBinding
import com.ilosipov.news_app.databinding.ItemNewsTextBinding

/**
 * Class TextViewHolder
 * @author Ilya Osipov (mailto:il.osipov.gm@gmail.com)
 * @since 18.11.2020
 * @version $Id$
 */

class TextViewHolder(private var itemNewsTextBinding: ItemNewsTextBinding) :
        BaseViewHolder(itemNewsTextBinding.root) {

    override fun bindData(item: NewsItem) {
        itemNewsTextBinding.newsItemText = item
    }

    override fun getItemNewsTextBinding(): ItemNewsTextBinding {
        TODO("Not yet implemented")
    }

    override fun getItemNewsImageBinding(): ItemNewsImageBinding {
        TODO("Not yet implemented")
    }
}