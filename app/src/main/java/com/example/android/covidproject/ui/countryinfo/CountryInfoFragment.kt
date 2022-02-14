package com.example.android.covidproject.ui.countryinfo

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.android.covidproject.R
import com.example.android.covidproject.databinding.CountryInfoFragmentBinding

class CountryInfoFragment : Fragment() {

    private val countryInfoArgs by navArgs<CountryInfoFragmentArgs>()

    private val viewModel: CountryInfoViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewModel.country = countryInfoArgs.country

        val binding = CountryInfoFragmentBinding.inflate(inflater)

        binding.lifecycleOwner = viewLifecycleOwner

        binding.viewModel = viewModel

        return binding.root
    }

}
