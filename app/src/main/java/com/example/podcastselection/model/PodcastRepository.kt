package com.example.podcastselection.model

import com.example.podcastselection.model.api.ListenApi
import com.example.podcastselection.model.api.ListenResponse
import com.example.podcastselection.model.api.PodcastResponse
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create

class PodcastRepository {
    private val listenApi:ListenApi
    init {
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://listen-api-test.listennotes.com/api/v2/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

        listenApi = retrofit.create()
    }

    /*
    * Function that fetches the data for the list and formats the data
    * before handing it over to the view model
    * */
    suspend fun fetchPodcasts(): List<PodcastListItem> {
        var podcastResponses = listenApi.fetchPodcasts().results
        var podcastListItems = mutableListOf<PodcastListItem>()
        for(entry in podcastResponses){
            val item = PodcastListItem(
                entry.podcast.id,
                entry.podcast.title,
                entry.podcast.author,
                entry.podcast.fullImage,
                entry.podcast.thumbnail,
                entry.descriptionOriginal,
                false
            )
            podcastListItems.add(item)
        }
        return podcastListItems
    }

}