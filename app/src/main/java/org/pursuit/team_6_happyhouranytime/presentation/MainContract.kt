package org.pursuit.team_6_happyhouranytime.presentation

import org.pursuit.team_6_happyhouranytime.model.Model

interface MainContract {

    interface View {

        fun showDrink(imgUri: String?) {


        }
    }


    interface Presenter {
        fun getRandomDrinks()
        interface OnNetworkCallListener {

            fun onNetworkCallFinished(drinkList: List<Model.Drinks>)
        }

        fun networkCallFinished(onNetworkCallListener: OnNetworkCallListener)


    }

    interface DrinkModel
}