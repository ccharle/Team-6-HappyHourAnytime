package org.pursuit.team_6_happyhouranytime.network;

import org.pursuit.team_6_happyhouranytime.models.DrinksResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface BartenderService {

    @GET("/api/json/v1/1/search.php")
    Call<DrinksResponse> getDrinks(
           @Query("s") String drinkName
    );
    //https://www.thecocktaildb.com/api/json/v1/1/search.php?s=margarita
}
