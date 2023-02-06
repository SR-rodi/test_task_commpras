package com.example.weather.feature.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import com.example.weather.R
import com.example.weather.core.LoadState
import com.example.weather.core.base.BaseFragment
import com.example.weather.databinding.FragmentHomeBinding
import com.example.weather.feature.domain.model.Weather

class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    override fun initBinding(inflater: LayoutInflater) = FragmentHomeBinding.inflate(inflater)

    private val viewModel: HomeViewModel by lazy { initViewModel() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.start()
        clickOnSettings()

        dataObserve(viewModel.weather) { weathers -> setData(weathers) }
        dataObserve(viewModel.loadState) { state -> loadStateListener(state) }
    }

    private fun loadStateListener(state: LoadState) = binding.itemTemp.apply {
        progressBar.isVisible = state == LoadState.LOADING
        networkError.isVisible = state == LoadState.ERROR
    }

    private fun setData(weathers: Weather) = binding.apply {
        city.text = weathers.cityName
        date.text = viewModel.getDate()
        descriptions.text = weathers.weatherDescriptions.replaceFirstChar(Char::titlecase)
        weather.apply {
            clouds.text = weathers.clouds.toString()
            speedWind.text = weathers.windSpeed.toString()
            humidity.text = weathers.humidity.toString()
            pressure.text = weathers.pressure.toString()
        }
        itemTemp.apply {
            temperature.text = weathers.TempCurrent.toInt().toString()
            icon.setImageResource(weathers.icon)
        }
    }

    private fun clickOnSettings() =
        binding.settings.setOnClickListener {
            findNavController().navigate(R.id.action_navigation_home_to_navigation_dashboard)
        }
}