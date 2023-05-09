package com.example.podcastselection.model

data class PodcastListItem(
    val id: String,
    val title: String,
    val author: String,
    val fullImage: String,
    val thumbnail: String,
    val description: String,
    val isFavourite: Boolean
)
