package com.example.recruitment.models


import com.google.gson.annotations.SerializedName

data class Event(
    @SerializedName("accepted")
    val accepted: Int,
    @SerializedName("address")
    val address: String,
    @SerializedName("catch")
    val `catch`: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("ended_at")
    val endedAt: String,
    @SerializedName("limit")
    val limit: Int,
    @SerializedName("owner_display_name")
    val ownerDisplayName: String,
    @SerializedName("place")
    val place: String,
    @SerializedName("started_at")
    val startedAt: String,
    @SerializedName("title")
    val title: String,
)