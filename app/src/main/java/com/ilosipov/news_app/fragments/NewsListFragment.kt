package com.ilosipov.news_app.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.ilosipov.news_app.R
import com.ilosipov.news_app.adapters.news.DiffUtilNewsItemCallback
import com.ilosipov.news_app.adapters.news.NewsAdapter
import com.ilosipov.news_app.data.FakeDataSource
import com.ilosipov.news_app.databinding.FragmentNewsListBinding

/**
 * Class NewsListFragment
 * @author Ilya Osipov (mailto:il.osipov.gm@gmail.com)
 * @since 18.11.2020
 * @version $Id$
 */

private const val TAG = "NewsListFragment"

class NewsListFragment : Fragment() {

    private lateinit var binding: FragmentNewsListBinding
    private lateinit var adapterNews: NewsAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        Log.i(TAG, "onCreateView: start fragment")
        binding = DataBindingUtil.inflate(LayoutInflater.from(requireContext()),
            R.layout.fragment_news_list, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.i(TAG, "onViewCreated: init view")

        adapterNews = NewsAdapter(DiffUtilNewsItemCallback())
        binding.rvListNews.apply {
            setHasFixedSize(true)
            layoutManager = GridLayoutManager(context, 2)
            adapter = adapterNews
            adapterNews.submitList(FakeDataSource().fakeListNews)
        }
    }
}