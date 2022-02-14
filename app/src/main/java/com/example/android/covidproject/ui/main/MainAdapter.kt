package com.example.android.covidproject.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.android.covidproject.databinding.ListItemCountryBinding
import com.example.android.covidproject.network.data.Country


class MainAdapter: ListAdapter<Country, MainAdapter.ViewHolder>(DiffCallback) {

    class ViewHolder(private var binding: ListItemCountryBinding) :
            RecyclerView.ViewHolder(binding.root) {
                fun bind(country: Country) {
                    binding.country = country
                    if (country.cases.active == null)
                    {
                        binding.itemCases.text = "No cases!"
                    }
                    else
                    {
                        binding.itemCases.text = country.cases.active.toString()
                    }
                    binding.executePendingBindings()

                    binding.imageView.setOnClickListener { v: View ->
                        v.findNavController()
                            .navigate(
                                MainFragmentDirections.actionMainFragmentToCountryInfoFragment(
                                    country
                                )
                            )
                    }
                }
            }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ListItemCountryBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val countryFeed = getItem(position)
        holder.bind(countryFeed)
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Country>() {
        override fun areItemsTheSame(oldItem: Country, newItem: Country): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Country, newItem: Country): Boolean {
            return oldItem.country == newItem.country
        }
    }
}
