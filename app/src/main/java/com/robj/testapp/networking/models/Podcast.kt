package com.robj.testapp.networking.models

import kotlinx.serialization.Serializable

@Serializable
data class Podcast(
    val id: Int,
    val url: String,
    val title: String,
    val description: String,
    val author: String,
    val image: String,
    val artwork: String,
    val newestItemPublishTime: Int? = null,
    val itunesId: Int? = null,
    val trendScore: Int? = null,
    val language: String,
)
