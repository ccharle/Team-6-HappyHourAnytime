package org.pursuit.team_6_happyhouranytime.models;

import android.util.Log;

import org.pursuit.team_6_happyhouranytime.network.ApiClient;
import org.pursuit.team_6_happyhouranytime.presentation.CocktailsContract;
import org.pursuit.team_6_happyhouranytime.presenter.MainPresenter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

//This class will have actual business logic for fetching data from a server.
// This class will implement Model Interface from Contract Interface

public class CocktailModel implements CocktailsContract.Model {
    private CocktailsContract.Presenter presenter = new MainPresenter(this);
    private ApiClient apiClient;
    private final String TAG = "CocktailsListModel";
    private List<Cocktail> cocktailList = new ArrayList<>();
    private List<Cocktail> randomCocktail = new ArrayList<>();

    public CocktailModel(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    @Override
    public void getCocktails() {
        apiClient.getCocktails().enqueue(new Callback<CocktailResponse>() {
            @Override
            public void onResponse(Call<CocktailResponse> call, Response<CocktailResponse> response) {

                if (response.body() != null) {
                    cocktailList.addAll(response.body().getDrinks());
                    Log.d(TAG, "Random Drinks Response" + response.body());

                }

            }

            @Override
            public void onFailure(Call<CocktailResponse> call, Throwable t) {

            }
        });


    }

    @Override
    public void getRandom() {
        apiClient.getRandom().enqueue(new Callback<CocktailResponse>() {
            @Override
            public void onResponse(Call<CocktailResponse> call, Response<CocktailResponse> response) {
                if (response.body() != null) {
                    randomCocktail.addAll(response.body().getDrinks());
                    Log.d(TAG, "Random Drinks Response" + response.body());

                }
            }

            @Override
            public void onFailure(Call<CocktailResponse> call, Throwable t) {
                Log.d(TAG, "onFailure" + t.getMessage());
            }
        });


    }
}
