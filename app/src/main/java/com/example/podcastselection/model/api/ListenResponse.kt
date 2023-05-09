package com.example.podcastselection.model.api

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ListenResponse(
    val results:List<PodcastResponse>
)
