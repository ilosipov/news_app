package com.ilosipov.news_app.ui.news

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.ilosipov.news_app.data.NewsItem
import com.ilosipov.news_app.databinding.ItemNewsImageBinding
import com.ilosipov.news_app.databinding.ItemNewsTextBinding

/**
 * Class BaseViewHolder
 * @author Ilya Osipov (mailto:il.osipov.gm@gmail.com)
 * @since 18.11.2020
 * @version $Id$
 */

abstract class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    abstract fun bindData(item: NewsItem)

    abstract fun getItemNewsTextBinding(): ItemNewsTextBinding
    abstract fun getItemNewsImageBinding(): ItemNewsImageBinding
}