package com.robj.testapp.networking

import com.robj.testapp.networking.models.PodcastListResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("podcasts/trending")
    suspend fun getTrendingPodcasts(): PodcastListResponse

    @GET("search/bytitle")
    suspend fun searchPodcastsByName(@Query("q") query: String): PodcastListResponse

}
