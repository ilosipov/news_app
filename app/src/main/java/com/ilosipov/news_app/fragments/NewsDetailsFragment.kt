package com.ilosipov.news_app.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.ilosipov.news_app.R
import com.ilosipov.news_app.data.NewsItem
import com.ilosipov.news_app.databinding.FragmentNewsDetailsBinding

/**
 * Class NewsDetailsFragment
 * @author Ilya Osipov (mailto:il.osipov.gm@gmail.com)
 * @since 18.11.2020
 * @version $Id$
 */

class NewsDetailsFragment : Fragment() {

    private lateinit var binding: FragmentNewsDetailsBinding

    companion object {
        private const val TAG = "NewsDetailsFragment"
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        Log.i(TAG, "onCreateView: start fragment")
        binding = DataBindingUtil.inflate(LayoutInflater.from(requireContext()),
            R.layout.fragment_news_details, container, false)
        binding.newsItemData = requireArguments().get("news_item_data") as NewsItem

        return binding.root
    }
}