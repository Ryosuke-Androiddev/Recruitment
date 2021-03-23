package com.example.recruitment.models


import com.google.gson.annotations.SerializedName

data class Connpass(
        @SerializedName("events")
    val events: List<Event>
        )