package com.ilosipov.news_app.fragments

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.ilosipov.news_app.R
import com.ilosipov.news_app.adapters.news.DiffUtilNewsItemCallback
import com.ilosipov.news_app.adapters.news.NewsAdapter
import com.ilosipov.news_app.data.FakeDataSource
import com.ilosipov.news_app.data.NewsItem
import com.ilosipov.news_app.databinding.FragmentNewsListBinding
import com.ilosipov.news_app.listeners.OnNewsItemClickEvent
import java.io.Serializable

/**
 * Class NewsListFragment
 * @author Ilya Osipov (mailto:il.osipov.gm@gmail.com)
 * @since 18.11.2020
 * @version $Id$
 */

class NewsListFragment : Fragment(), OnNewsItemClickEvent {

    private lateinit var binding: FragmentNewsListBinding
    private lateinit var adapterNews: NewsAdapter
    private lateinit var fakeNewsList: List<NewsItem>

    companion object {
        private const val TAG = "NewsListFragment"
    }

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

        fakeNewsList = FakeDataSource().fakeListNews
        binding.rvListNews.apply {
            setHasFixedSize(true)
            layoutManager = GridLayoutManager(requireContext(), 2)
            adapterNews = NewsAdapter(DiffUtilNewsItemCallback()).apply {
                setOnNewsItemClickListener(this@NewsListFragment
//                        object : OnNewsItemClickEvent {
//                    override fun onItemClick(view: View, position: Int) {
//                        findNavController().navigate(R.id.action_newsFragment_to_newsDetailsFragment,
//                                Bundle().apply {
//                                    putSerializable("news_item_data", fakeNewsList[position])
//                                })
//                    }
//                }
                )
            }
            adapter = adapterNews
            adapterNews.submitList(fakeNewsList)
        }

        binding.newsSwipeRefresh.setOnRefreshListener {
            Handler(Looper.getMainLooper()).postDelayed({
                run {
                    adapterNews.submitList(FakeDataSource().fakeUpdatedStaticListNews)
                    binding.newsSwipeRefresh.isRefreshing = false

                    adapterNews.registerAdapterDataObserver(object : RecyclerView.AdapterDataObserver() {
                        override fun onItemRangeInserted(positionStart: Int, itemCount: Int) {
                            super.onItemRangeInserted(positionStart, itemCount)
                            binding.rvListNews.smoothScrollToPosition(positionStart)
                        }
                    })
                }
            }, 1200)
        }
    }

    override fun onItemClick(view: View, position: Int) {
        findNavController().navigate(R.id.action_newsFragment_to_newsDetailsFragment,
                Bundle().apply {
                    putSerializable("news_item_data", fakeNewsList[position])
                })
    }
}