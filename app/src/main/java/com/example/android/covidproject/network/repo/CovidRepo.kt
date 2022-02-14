package com.example.android.covidproject.network.repo

import com.example.android.covidproject.network.data.CovidResponse
import com.example.android.covidproject.network.networkmodel.ServiceResult

interface CovidRepo {
    suspend fun fetchCountries()
    : ServiceResult<CovidResponse?>
}
