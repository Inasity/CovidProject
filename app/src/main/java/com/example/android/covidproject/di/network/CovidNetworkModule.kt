package com.example.android.covidproject.di.network

import com.example.android.covidproject.network.endpoint.CovidApiEndPoints
import com.example.android.covidproject.network.repo.CovidRepo
import com.example.android.covidproject.network.repoImpl.CovidRepoImpl
import com.example.android.covidproject.network.retrofit.RetrofitFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object CovidNetworkModule {
    private const val CovidBaseUrl = "https://covid-193.p.rapidapi.com/"

    @Singleton
    @Provides
    fun provideCovidRetrofit(): CovidApiEndPoints {
        return RetrofitFactory.retrofitProvider(
            CovidApiEndPoints::class.java,
            CovidBaseUrl
        )
    }

    @Singleton
    @Provides
    fun provideCovidRepo(
        dispatcher: Dispatchers,
        retroObject: CovidApiEndPoints
    ): CovidRepo {
        return CovidRepoImpl(dispatcher, retroObject)
    }
}
