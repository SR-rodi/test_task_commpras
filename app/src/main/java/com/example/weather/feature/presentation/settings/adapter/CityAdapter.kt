package com.example.weather.feature.presentation.settings.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.weather.databinding.ItemCityBinding
import com.example.weather.feature.data.City

class CityAdapter(
    private val onClick: (name: String) -> Unit
) : RecyclerView.Adapter<CityViewHolder>() {

    private var items = emptyList<City>()

    fun submitList(list: List<City>) {
        items = list
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = CityViewHolder(
        ItemCityBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    ) { name -> onClick(name) }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: CityViewHolder, position: Int) {
        holder.bind(items[position])
    }
}