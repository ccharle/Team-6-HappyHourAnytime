package org.pursuit.team_6_happyhouranytime.network.webutils

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkClient {
    private const val BASE_URL = "https://www.thecocktaildb.com"

    private val retrofitBuilder: Retrofit.Builder by lazy {
        Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
    }
    val apiService: APIService by lazy {
        retrofitBuilder
                .build()
                .create(APIService::class.java)

    }
}

