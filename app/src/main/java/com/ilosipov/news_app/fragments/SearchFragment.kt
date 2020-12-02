package com.ilosipov.news_app.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.ilosipov.news_app.R
import com.ilosipov.news_app.adapters.news.NewsAdapter
import com.ilosipov.news_app.data.NewsItem
import com.ilosipov.news_app.databinding.FragmentSearchBinding

/**
 * Class SearchFragment
 * @author Ilya Osipov (mailto:il.osipov.gm@gmail.com)
 * @since 18.11.2020
 * @version $Id$
 */

class SearchFragment : Fragment() {

    private lateinit var binding: FragmentSearchBinding
    private lateinit var adapterNews: NewsAdapter
    private lateinit var fakeSearchNewsList: List<NewsItem>

    companion object {
        private const val TAG = "SearchFragment"
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        Log.i(TAG, "onCreateView: start fragment")
        binding = DataBindingUtil.inflate(LayoutInflater.from(requireContext()),
            R.layout.fragment_search, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.i(TAG, "onViewCreated: init view")
        fakeSearchNewsList = emptyList()

        checkList(fakeSearchNewsList.isEmpty())
    }

    private fun checkList(isEmpty: Boolean) {
        binding.apply {
            rvSearchNews.visibility = if (isEmpty) View.GONE else View.VISIBLE
            textEmptyList.visibility = if (isEmpty) View.VISIBLE else View.GONE
        }
    }
}