package org.pursuit.team_6_happyhouranytime.network

import okhttp3.OkHttpClient
import org.pursuit.team_6_happyhouranytime.model.Model
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


interface CocktailService {
    @GET("/api/json/v1/1/random.php")
    fun getRandomRandom(): Call<Model.Response>

    companion object {
        private const val BASE_URL: String = "https://www.thecocktaildb.com/"

        fun create(): CocktailService {

            val builder: OkHttpClient.Builder = OkHttpClient.Builder()
            val client: OkHttpClient = builder.build()
            val retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()



            return retrofit.create(CocktailService::class.java)

        }
    }
}