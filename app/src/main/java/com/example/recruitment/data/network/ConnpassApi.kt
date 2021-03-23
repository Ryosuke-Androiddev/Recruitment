package com.example.recruitment.data.network

import com.example.recruitment.models.Connpass
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface ConnpassApi {

    @GET("/api/v1/event")
    suspend fun getInformation(
        @QueryMap queries: Map<String,String>
    ): Response<Connpass>
}