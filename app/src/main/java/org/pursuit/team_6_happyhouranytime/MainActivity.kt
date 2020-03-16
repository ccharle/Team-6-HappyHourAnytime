package org.pursuit.team_6_happyhouranytime;


import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import org.pursuit.team_6_happyhouranytime.model.CocktailResponse
import org.pursuit.team_6_happyhouranytime.network.CocktailService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

private const val TAG = "OnResponse"

class MainActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cocktailService by lazy {

            CocktailService.create()


        }
        fetch(cocktailService)

    }

private fun fetch(cocktailService: CocktailService){
    cocktailService.fetchRandomCocktail().enqueue(object :Callback<CocktailResponse> {
        override fun onFailure(call: Call<CocktailResponse>, t: Throwable){
            Log.d(TAG, "Failure")
        }

        override fun onResponse(call: Call<CocktailResponse>, response: Response<CocktailResponse>) {
            Log.d(TAG, response.body().toString())
        }

    })
}

}




