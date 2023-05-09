package com.example.podcastselection.model.api

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**Class for capturing remote data
 * id: provided identifier
 * title: Name of Podcast
 * author: Publisher of podcast
 * description: the full text description of the podcast
 * fullImage: url of the full size podcast icon image
 * thumbnail: url of the thumbnail icon for podcast
 */

@JsonClass(generateAdapter = true)
data class Podcast(
    val id: String,
    @Json(name = "title_original") val title: String,
    @Json(name = "publisher_original") val author: String,
    @Json(name = "image")val fullImage: String,
    val thumbnail: String
)
