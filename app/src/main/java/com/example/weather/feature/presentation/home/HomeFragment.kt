package com.example.weather.feature.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import com.example.weather.core.base.BaseFragment
import com.example.weather.databinding.FragmentHomeBinding

class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    override fun initBinding(inflater: LayoutInflater) = FragmentHomeBinding.inflate(inflater)

    private val viewModel: HomeViewModel by lazy { initViewModel() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel
    }
}