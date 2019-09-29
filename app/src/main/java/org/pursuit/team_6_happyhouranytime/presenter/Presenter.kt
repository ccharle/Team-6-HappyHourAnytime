package org.pursuit.team_6_happyhouranytime.presenter

import org.pursuit.team_6_happyhouranytime.model.Model
import org.pursuit.team_6_happyhouranytime.network.CocktailService
import org.pursuit.team_6_happyhouranytime.presentation.MainContract
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class Presenter(val cocktailService: CocktailService) : MainContract.Presenter{




fun getRandomDrinks() {
    cocktailService.getRandomRandom().enqueue(object: Callback<Model.Response>{
        override fun onFailure(call: Call<Model.Response>, t: Throwable) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun onResponse(call: Call<Model.Response>, response: Response<Model.Response>) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }
    })


}



}