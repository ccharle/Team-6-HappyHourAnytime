package org.pursuit.team_6_happyhouranytime.network;

import org.pursuit.team_6_happyhouranytime.model.CocktailResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CocktailsAPI {

    @GET("/api/json/v1/1/filter.php?c=Ordinary_Drink")
    Call<CocktailResponse> getCocktails();

    @GET("/api/json/v1/1/random.php")
    Call<CocktailResponse> getRandomCocktails();

    @GET("/api/json/v1/1/filter.php")
    Call<CocktailResponse> getDrinkType(
            @Query("a") String drinkType
    );
    @GET("/api/json/v1/1/filter.php")
    Call<CocktailResponse>getIngredient(
            @Query("i") String drinkIngredient);

    @GET("/api/json/v1/1/lookup.php")
    Call<CocktailResponse> getById(@Query("i") String drinkID);


}
