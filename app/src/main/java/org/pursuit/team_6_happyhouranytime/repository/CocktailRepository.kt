package org.pursuit.team_6_happyhouranytime.repository

import org.pursuit.team_6_happyhouranytime.model.CocktailModel
import org.pursuit.team_6_happyhouranytime.network.webutils.NetworkCall
import org.pursuit.team_6_happyhouranytime.network.webutils.NetworkClient

object CocktailRepository {
    fun getRandomCocktail() = NetworkCall<CocktailModel>().makeCall(NetworkClient.apiService.fetchRandomCocktail())
}