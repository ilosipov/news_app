package com.ilosipov.news_app.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatDelegate
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.ilosipov.news_app.R
import com.ilosipov.news_app.databinding.FragmentSettingsBinding
import com.ilosipov.news_app.util.AppSettings

/**
 * Class SettingsFragment
 * @author Ilya Osipov (mailto:il.osipov.gm@gmail.com)
 * @since 18.11.2020
 * @version $Id$
 */

class SettingsFragment : Fragment() {

    private lateinit var binding: FragmentSettingsBinding
    private lateinit var settings: AppSettings

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(LayoutInflater.from(requireContext()),
            R.layout.fragment_settings, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        settings = AppSettings(requireContext())

        binding.apply {
            when (settings.getTheme()) {
                AppSettings.THEME_LIGHT -> rbLight.isChecked = true
                AppSettings.THEME_DARK -> rbDark.isChecked = true
                AppSettings.THEME_SYSTEM -> rbSystem.isChecked = true
                else -> rbSystem.isChecked = true
            }

            radioGroupTheme.setOnCheckedChangeListener { _, checkedId ->
                when (checkedId) {
                    R.id.rb_light -> settings.setTheme(AppSettings.THEME_LIGHT)
                    R.id.rb_dark -> settings.setTheme(AppSettings.THEME_DARK)
                    R.id.rb_system -> settings.setTheme(AppSettings.THEME_SYSTEM)
                    else -> settings.setTheme(AppSettings.THEME_SYSTEM)
                }
            }
        }
    }
}