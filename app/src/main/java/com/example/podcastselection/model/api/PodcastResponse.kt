package com.example.podcastselection.model.api

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class PodcastResponse(
    val podcast: Podcast,
    @Json(name = "description_original")
    val descriptionOriginal: String
)
