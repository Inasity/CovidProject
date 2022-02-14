package com.example.android.covidproject.ui.main

import android.app.Application
import androidx.lifecycle.*
import com.example.android.covidproject.network.data.CovidResponse
import com.example.android.covidproject.network.networkmodel.ServiceResult
import com.example.android.covidproject.network.repo.CovidRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    application: Application,
    private val repo: CovidRepo,
    private val dispatcher: Dispatchers
) : AndroidViewModel(application) {

    private val _covidFeed = MutableLiveData<CovidResponse?>()

    val covidFeed: LiveData<CovidResponse?>
        get() = _covidFeed

    fun getCountries() {
        viewModelScope.launch(dispatcher.IO) {
            when(val response = repo.fetchCountries()) {
                is ServiceResult.Success -> {
                    _covidFeed.postValue(response.data)
                    Timber.d("Got the country info baby." + response.data)
                }

                is ServiceResult.Error -> {
                    Timber.d("Erro was found when calling the countries :: " + response.exception)
                }

                else -> {
                    Timber.d("Bro.")
                }
            }
        }
    }

}
