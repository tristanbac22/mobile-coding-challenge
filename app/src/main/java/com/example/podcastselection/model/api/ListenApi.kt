package com.example.podcastselection.model.api

import retrofit2.Response
import retrofit2.http.GET

/**
 * BASE URI would be important to store as constant
 * if we need to perform other types of queries or writing to the database
 * for this application only the one query is necessary
 */
private const val BASE_URI = "https://listen-api-test.listennotes.com/api/v2/"

/*
* This information is retrieved from the mock data since, the test api is called and there is no API
* Key. The mocked data JSON objects are formatted differently from production
* */

interface ListenApi {
    @GET("search?q=startup:")
    //suspend fun fetchPodcasts(): String
    suspend fun fetchPodcasts(): ListenResponse
}