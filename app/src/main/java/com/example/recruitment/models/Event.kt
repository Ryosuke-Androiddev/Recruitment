package com.example.recruitment


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
    @SerializedName("event_id")
    val eventId: Int,
    @SerializedName("event_type")
    val eventType: String,
    @SerializedName("event_url")
    val eventUrl: String,
    @SerializedName("hash_tag")
    val hashTag: String,
    @SerializedName("lat")
    val lat: Any,
    @SerializedName("limit")
    val limit: Int,
    @SerializedName("lon")
    val lon: Any,
    @SerializedName("owner_display_name")
    val ownerDisplayName: String,
    @SerializedName("owner_id")
    val ownerId: Int,
    @SerializedName("owner_nickname")
    val ownerNickname: String,
    @SerializedName("place")
    val place: String,
    @SerializedName("series")
    val series: Series,
    @SerializedName("started_at")
    val startedAt: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("updated_at")
    val updatedAt: String,
    @SerializedName("waiting")
    val waiting: Int
)