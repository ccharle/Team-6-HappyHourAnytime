package org.pursuit.team_6_happyhouranytime.models;

import android.util.Log;

import org.pursuit.team_6_happyhouranytime.network.ApiClient;
import org.pursuit.team_6_happyhouranytime.network.CocktailsAPI;
import org.pursuit.team_6_happyhouranytime.presentation.CocktailsContract;
import org.pursuit.team_6_happyhouranytime.presenter.MainPresenter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

//This class will have actual business logic for fetching data from a server.
// This class will implement Model Interface from Contract Interface

public class CocktailListModel implements CocktailsContract.Model {
    /**
     * This function will fetch cocktail data
     *
     * @param onFinishedListener
     */
    private ApiClient apiClient;
    private MainPresenter mainPresenter = new MainPresenter()
    private final String TAG = "CocktailsListModel";
    private List<Cocktail> cocktails = new ArrayList<>();


    @Override
    public void getCocktails(List<CocktailResponse> cocktailResponseList) {
        apiClient = ApiClient.getInstance();
        apiClient.getRandom().enqueue(new Callback<CocktailResponse>() {
            @Override
            public void onResponse(Call<CocktailResponse> call, Response<CocktailResponse> response) {

                cocktails.addAll(response.body().getDrinks());
                Log.d(TAG, "Random Drinks Response" + response.body());

            }

            @Override
            public void onFailure(Call<CocktailResponse> call, Throwable t) {
                Log.d(TAG, "onFailure" + t.getMessage());
            }
        });

    }
}
