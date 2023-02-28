package com.robj.testapp.networking

import com.robj.testapp.networking.models.Podcast

class ApiRepo(
    private val apiService: ApiService
) {

    suspend fun getTrendingPodcasts(): Result<List<Podcast>> = runCatching {
        apiService.getTrendingPodcasts().feeds
    }

    suspend fun searchPodcastsByName(query: String): Result<List<Podcast>> = runCatching {
        apiService.searchPodcastsByName(query).feeds
    }
}
