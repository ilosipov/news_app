package com.ilosipov.news_app.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
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
import com.ilosipov.news_app.databinding.FragmentSearchBinding
import com.ilosipov.news_app.listeners.OnNewsItemClickEvent
import com.ilosipov.news_app.util.keyboard.ShowSoftwareKeyboard

/**
 * Class SearchFragment
 * @author Ilya Osipov (mailto:il.osipov.gm@gmail.com)
 * @since 18.11.2020
 * @version $Id$
 */

class SearchFragment : Fragment(), OnNewsItemClickEvent, TextWatcher {

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
        fakeSearchNewsList = FakeDataSource().fakeListNews

        binding.searchEditText.addTextChangedListener(this)
        binding.rvSearchNews.apply {
            setHasFixedSize(true)
            layoutManager = GridLayoutManager(requireContext(), 2)
            adapterNews = NewsAdapter(DiffUtilNewsItemCallback()).apply {
                setOnNewsItemClickListener(this@SearchFragment)
            }
            adapter = adapterNews
            adapterNews.submitList(fakeSearchNewsList)
        }

        checkList(fakeSearchNewsList.isEmpty())
    }

    private fun checkList(isEmpty: Boolean) {
        binding.apply {
            rvSearchNews.visibility = if (isEmpty) View.GONE else View.VISIBLE
            textEmptyList.visibility = if (isEmpty) View.VISIBLE else View.GONE
        }
    }

    override fun onPause() {
        super.onPause()
        Log.i(TAG, "onPause")
        ShowSoftwareKeyboard(requireActivity()).isShow(isVisibility = false)
    }

    override fun beforeTextChanged(char: CharSequence?, start: Int, count: Int, after: Int) {
    }

    override fun onTextChanged(char: CharSequence?, start: Int, before: Int, count: Int) {
        Log.i(TAG, "onTextChanged: char = $char")
    }

    override fun afterTextChanged(editable: Editable?) {
    }

    override fun onItemClick(view: View, position: Int) {
        findNavController().navigate(R.id.action_searchFragment_to_newsDetailsFragment,
                Bundle().apply {
                    putSerializable("news_item_data", fakeSearchNewsList[position])
                })
    }
}