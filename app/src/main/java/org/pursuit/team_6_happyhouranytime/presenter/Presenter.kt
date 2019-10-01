package org.pursuit.team_6_happyhouranytime.presenter

import android.util.Log
import org.pursuit.team_6_happyhouranytime.model.Model
import org.pursuit.team_6_happyhouranytime.network.CocktailService
import org.pursuit.team_6_happyhouranytime.presentation.MainContract
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

private const val TAG = "Response"

class Presenter(private val cocktailService: CocktailService, private val viewRef: MainContract.View) : MainContract.Presenter, MainContract.Presenter.OnNetworkCallListener {
    override fun onNetworkCallFinished(drinkList: List<Model.Drinks>) {
        viewRef.showDrink(drinkList[0].strDrinkThumb)
        viewRef.getList(drinkList)

    }

    override fun getRandomDrinks() {
        randomDrinksRequest()

    }


    override fun networkCallFinished(onNetworkCallListener: MainContract.Presenter.OnNetworkCallListener) {


    }

    private fun randomDrinksRequest() {

        cocktailService.getRandomRandom().enqueue(object : Callback<Model.Response> {
            override fun onFailure(call: Call<Model.Response>, t: Throwable) {
                Log.d(TAG, t.message)

            }

            override fun onResponse(call: Call<Model.Response>, response: Response<Model.Response>) {
                Log.d(TAG, "success")
                onNetworkCallFinished(response.body()!!.drinks)


            }


        })

    }
}