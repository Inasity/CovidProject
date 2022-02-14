package com.example.android.covidproject.network.repoImpl

import com.example.android.covidproject.network.data.CovidResponse
import com.example.android.covidproject.network.endpoint.CovidApiEndPoints
import com.example.android.covidproject.network.networkmodel.ServiceResult
import com.example.android.covidproject.network.repo.CovidRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Exception
import javax.inject.Inject

class CovidRepoImpl @Inject constructor(
    private val dispatcher: Dispatchers,
    private val retroObject: CovidApiEndPoints
) : CovidRepo {
    override suspend fun fetchCountries(): ServiceResult<CovidResponse?> {
        return withContext(dispatcher.IO)
        {
            val dataResponse = retroObject.getCountries()

            if(dataResponse.isSuccessful)
            {
                ServiceResult.Success(dataResponse.body())
            }
            else
            {
                ServiceResult.Error(Exception(dataResponse.errorBody().toString()))
            }
        }

    }
}
