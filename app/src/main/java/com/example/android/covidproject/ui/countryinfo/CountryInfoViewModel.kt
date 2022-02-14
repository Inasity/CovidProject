package com.example.android.covidproject.ui.countryinfo

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.example.android.covidproject.network.data.Country
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CountryInfoViewModel @Inject constructor(
    application: Application
) : AndroidViewModel(application) {
    lateinit var country: Country
}
