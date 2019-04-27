package org.pursuit.team_6_happyhouranytime.network;

import org.pursuit.team_6_happyhouranytime.models.DrinksResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface BartenderService {

    @GET("/api/json/v1/1/filter.php?c=Ordinary_Drink")
    Call<DrinksResponse> getDrinks(
            @Query("s") String drinkName
    );

    @GET("/api/json/v1/1/random.php")
    Call<DrinksResponse> getRandomDrinks();

    @GET("/api/json/v1/1/filter.php")
    Call<DrinksResponse> getDrinkType(
            @Query("a") String drinkType
    );


    //https://www.thecocktaildb.com/api/json/v1/1/search.php?s=margarita
}
