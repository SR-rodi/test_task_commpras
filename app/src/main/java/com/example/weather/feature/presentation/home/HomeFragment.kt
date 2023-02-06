package com.example.weather.feature.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import com.example.weather.core.base.BaseFragment
import com.example.weather.databinding.FragmentHomeBinding
import com.example.weather.feature.domain.Weather

class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    override fun initBinding(inflater: LayoutInflater) = FragmentHomeBinding.inflate(inflater)

    private val viewModel: HomeViewModel by lazy { initViewModel() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.date.text = viewModel.getDate()
        binding.city.text = viewModel.getCityName()
        dataObserve(viewModel.weather) { weathers -> setData(weathers) }
    }

    private fun setData(weather: Weather) {
        binding.weather.apply {

            clouds.text = weather.clouds.toString()
            speedWind.text = weather.windSpeed.toString()
            tempMax.text = weather.TempMax.toInt().toString()
            tempMin.text = weather.TempMin.toInt().toString()
        }
        binding.itemTemp.temperature.text = weather.TempCurrent.toInt().toString()
    }
}