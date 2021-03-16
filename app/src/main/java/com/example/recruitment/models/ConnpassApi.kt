package com.example.recruitment


import com.google.gson.annotations.SerializedName

data class connpassApi(
    @SerializedName("events")
    val events: List<EventX>,
    @SerializedName("results_available")
    val resultsAvailable: Int,
    @SerializedName("results_returned")
    val resultsReturned: Int,
    @SerializedName("results_start")
    val resultsStart: Int
)