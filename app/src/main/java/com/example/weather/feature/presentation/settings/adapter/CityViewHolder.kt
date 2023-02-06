package com.example.weather.feature.presentation.settings.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.weather.databinding.ItemCityBinding
import com.example.weather.feature.data.City

class CityViewHolder(
    private val binding: ItemCityBinding,
    private val onClickItem: (name: String) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    private var cityName: String? = null

    init {
        binding.root.setOnClickListener {
            onClickItem(requireNotNull(cityName))
        }
    }

    fun bind(item: City) {
        cityName = item.name
        binding.city.text = item.ru
        binding.divider.isSelected = item.isSelected
    }
}