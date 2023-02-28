package com.robj.testapp.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.robj.testapp.networking.ApiRepo
import com.robj.testapp.networking.ApiService
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit

private val json = Json {
    ignoreUnknownKeys = true
    coerceInputValues = true
}

val repositoryModule = module {

    single { ApiRepo(get()) }

    factory {
        OkHttpClient.Builder()
            .addInterceptor(
                HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                }
            )
            .build()
    }

    single<Retrofit> {
        val contentType = "application/json".toMediaType()
        @Suppress("OPT_IN_USAGE")
        Retrofit.Builder()
            .baseUrl("https://api.podcastindex.org/api/1.0/")
            .client(get())
            .addConverterFactory(json.asConverterFactory(contentType))
            .build()
    }

    single { get<Retrofit>().create(ApiService::class.java) }

}

private const val DB_PASS = "db_pass"
