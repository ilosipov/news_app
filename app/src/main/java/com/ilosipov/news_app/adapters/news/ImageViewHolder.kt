package com.ilosipov.news_app.adapters.news

import com.ilosipov.news_app.adapters.BaseViewHolder
import com.ilosipov.news_app.data.NewsItem
import com.ilosipov.news_app.databinding.ItemNewsImageBinding
import com.ilosipov.news_app.databinding.ItemNewsTextBinding

/**
 * Class ImageViewHolder
 * @author Ilya Osipov (mailto:il.osipov.gm@gmail.com)
 * @since 18.11.2020
 * @version $Id$
 */

class ImageViewHolder(private var itemNewsImageBinding: ItemNewsImageBinding) :
        BaseViewHolder(itemNewsImageBinding.root) {

    override fun bindData(item: NewsItem) {
        itemNewsImageBinding.newsItemImage = item
    }

    override fun getItemNewsTextBinding(): ItemNewsTextBinding? = null

    override fun getItemNewsImageBinding(): ItemNewsImageBinding? = null
}