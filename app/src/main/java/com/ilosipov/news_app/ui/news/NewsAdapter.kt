package com.ilosipov.news_app.ui.news

import android.content.Context
import android.text.Layout
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.ilosipov.news_app.R
import com.ilosipov.news_app.data.NewsItem
import com.ilosipov.news_app.listeners.OnNewsItemClickEvent

/**
 * Class NewsAdapter
 * @author Ilya Osipov (mailto:il.osipov.gm@gmail.com)
 * @since 19.11.2020
 * @version $Id$
 */

class NewsAdapter(diffCallback: DiffUtil.ItemCallback<NewsItem>) : RecyclerView.Adapter<BaseViewHolder>() {

    private lateinit var listener: OnNewsItemClickEvent

    companion object {
        private const val VIEWTYPE_NEWS_TEXT = 0
        private const val VIEWTYPE_NEWS_IMAGE = 1
        private const val VIEWTYPE_NEWS_VIDEO = 2
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder =
            when (viewType) {
                VIEWTYPE_NEWS_TEXT -> TextViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context),
                        R.layout.item_news_text, parent, false)
                )
                VIEWTYPE_NEWS_IMAGE -> ImageViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context),
                        R.layout.item_news_image, parent, false)
                )
                else -> TextViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context),
                        R.layout.item_news_text, parent, false)
                )
            }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    fun setOnNewsItemClickListener(listener: OnNewsItemClickEvent) {
        this.listener = listener
    }
}