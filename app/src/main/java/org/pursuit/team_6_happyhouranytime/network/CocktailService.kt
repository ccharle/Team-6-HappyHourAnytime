package org.pursuit.team_6_happyhouranytime.network

import dagger.Provides
import okhttp3.OkHttpClient
import org.pursuit.team_6_happyhouranytime.model.CocktailModel
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import javax.inject.Inject

@Inject
private const val BASE_URL: String = "https://www.thecocktaildb.com"


interface CocktailService {

@Provides
    @GET("api/json/v1/1/random.php")
    fun fetchRandomCocktail(): Call<CocktailModel >


    companion object RetrofitBuilder {
        fun create(): CocktailService {
            val client: OkHttpClient = OkHttpClient.Builder().build()
            val retrofit = Retrofit.Builder()
                    .client(client)
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            return retrofit.create(CocktailService::class.java)
        }

    }


}
