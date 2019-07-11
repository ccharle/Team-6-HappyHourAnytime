package org.pursuit.team_6_happyhouranytime.network;

import org.pursuit.team_6_happyhouranytime.models.DrinksResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface BartenderService {

    @GET("/api/json/v1/1/filter.php?c=Ordinary_Drink")
    Call<DrinksResponse> getDrinks();

    @GET("/api/json/v1/1/random.php")
    Call<DrinksResponse> getRandomDrinks();

    @GET("/api/json/v1/1/filter.php")
    Call<DrinksResponse> getDrinkType(
            @Query("a") String drinkType
    );
    @GET("/api/json/v1/1/filter.php")
    Call<DrinksResponse>getIngredient(
            @Query("i") String drinkIngredient);

    @GET("/api/json/v1/1/lookup.php")
    Call<DrinksResponse> getById(@Query("i") String drinkID);


}
