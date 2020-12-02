package com.ilosipov.news_app.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.ilosipov.news_app.R
import com.ilosipov.news_app.adapters.news.DiffUtilNewsItemCallback
import com.ilosipov.news_app.adapters.news.NewsAdapter
import com.ilosipov.news_app.data.FakeDataSource
import com.ilosipov.news_app.data.NewsItem
import com.ilosipov.news_app.databinding.FragmentNewsFavBinding
import com.ilosipov.news_app.listeners.OnNewsItemClickEvent

/**
 * Class NewsFavFragment
 * @author Ilya Osipov (mailto:il.osipov.gm@gmail.com)
 * @since 18.11.2020
 * @version $Id$
 */

class NewsFavFragment : Fragment(), OnNewsItemClickEvent {

    private lateinit var binding: FragmentNewsFavBinding
    private lateinit var adapterNews: NewsAdapter
    private lateinit var fakeStaticListNews: List<NewsItem>

    companion object {
        private const val TAG = "NewsFavFragment"
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        Log.i(TAG, "onCreateView: start fragment")
        binding = DataBindingUtil.inflate(LayoutInflater.from(requireContext()),
            R.layout.fragment_news_fav, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.i(TAG, "onViewCreated: init view")

        fakeStaticListNews = FakeDataSource().fakeStaticListNews
        binding.rvFavNews.apply {
            setHasFixedSize(true)
            layoutManager = GridLayoutManager(requireContext(), 2)
            adapterNews = NewsAdapter(DiffUtilNewsItemCallback()).apply {
                setOnNewsItemClickListener(this@NewsFavFragment)
            }
            adapter = adapterNews
            adapterNews.submitList(fakeStaticListNews)
        }
    }

    override fun onItemClick(view: View, position: Int) {
        findNavController().navigate(R.id.action_newsFavFragment_to_newsDetailsFragment,
                Bundle().apply { putSerializable("news_item_data", fakeStaticListNews[position]) })
    }
}