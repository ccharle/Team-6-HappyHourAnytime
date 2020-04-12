package org.pursuit.team_6_happyhouranytime.network.webutils

import dagger.Provides
import okhttp3.OkHttpClient
import org.pursuit.team_6_happyhouranytime.model.CocktailModel
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import javax.inject.Inject

interface APIService {
    @Provides
    @GET("api/json/v1/1/random.php")
    fun fetchRandomCocktail(): Call<CocktailModel>
}
