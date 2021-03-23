package com.example.recruitment.data

import com.example.recruitment.data.network.ConnpassApi
import com.example.recruitment.models.Connpass
import retrofit2.Response
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
        private val connpassApi: ConnpassApi
) {

    suspend fun getInformation(queries: Map<String,String>): Response<Connpass>{
        return connpassApi.getInformation(queries)
    }
}