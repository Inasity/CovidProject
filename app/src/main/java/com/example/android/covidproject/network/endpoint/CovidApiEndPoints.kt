package com.example.android.covidproject.network.endpoint

import com.example.android.covidproject.network.data.CovidResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

interface CovidApiEndPoints {
    @GET("/statistics")
    suspend fun getCountries(
        @Header("x-rapidapi-host") host: String = "covid-193.p.rapidapi.com",
        @Header("x-rapidapi-key") key: String = "4291a61388msh1f5b018fde8a27bp16e251jsn494b88af4524"
    ): Response<CovidResponse>
}
