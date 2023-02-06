package com.example.weather.feature.presentation.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.weather.core.base.BaseFragment
import com.example.weather.databinding.FragmentSettingsBinding
import com.example.weather.feature.presentation.settings.adapter.CityAdapter

class SettingsFragment : BaseFragment<FragmentSettingsBinding>() {

    override fun initBinding(inflater: LayoutInflater) = FragmentSettingsBinding.inflate(inflater)

    private val viewModel: SettingsViewModel by lazy { initViewModel() }

    private val adapter by lazy { CityAdapter{ cityName-> setOnItemClick(cityName)} }

    private fun setOnItemClick(cityName: String) {
        viewModel.setCiteInQuery(cityName)
        findNavController().popBackStack()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataObserve(viewModel.city) { list ->
            adapter.submitList(list)
            binding.cityRecycler.adapter = adapter
        }
    }

}