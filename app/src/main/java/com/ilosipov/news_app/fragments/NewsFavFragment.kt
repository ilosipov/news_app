package com.ilosipov.news_app.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.ilosipov.news_app.R
import com.ilosipov.news_app.databinding.FragmentNewsFavBinding

/**
 * Class NewsFavFragment
 * @author Ilya Osipov (mailto:il.osipov.gm@gmail.com)
 * @since 18.11.2020
 * @version $Id$
 */

class NewsFavFragment : Fragment() {

    private lateinit var binding: FragmentNewsFavBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(LayoutInflater.from(requireContext()),
            R.layout.fragment_news_fav, container, false)
        return binding.root
    }
}