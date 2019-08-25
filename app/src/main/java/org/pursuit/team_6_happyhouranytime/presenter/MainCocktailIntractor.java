package org.pursuit.team_6_happyhouranytime.presenter;

import android.util.Log;

import org.pursuit.team_6_happyhouranytime.models.Cocktail;
import org.pursuit.team_6_happyhouranytime.models.CocktailResponse;
import org.pursuit.team_6_happyhouranytime.network.ApiClient;
import org.pursuit.team_6_happyhouranytime.presentation.CocktailsContract;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

//This class will have actual business logic for fetching data from a server.
// This class will implement CocktailIntractor Interface from Contract Interface

public class MainCocktailIntractor implements CocktailsContract.CocktailIntractor {
    private CocktailsContract.Presenter presenter = new MainPresenter(this);
    private ApiClient apiClient;
    private final String TAG = "CocktailsListModel";
    private List<Cocktail> cocktailList = new ArrayList<>();
    private List<Cocktail> randomCocktailList = new ArrayList<>();

    public MainCocktailIntractor(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    @Override
    public void getCocktailResponse(OnFinishedListener onFinishedListener) {
        apiClient.getCocktails().enqueue(new Callback<CocktailResponse>() {
            @Override
            public void onResponse(Call<CocktailResponse> call, Response<CocktailResponse> response) {

                if (response.body() != null) {
                    cocktailList.addAll(response.body().getCocktails());
                    onFinishedListener.onFinished(cocktailList);
                    Log.d(TAG, "Random Drinks Response" + response.body());

                }

            }

            @Override
            public void onFailure(Call<CocktailResponse> call, Throwable t) {
                onFinishedListener.onFailure(t);

            }
        });

    }

    @Override
    public void getRandomResponse(OnFinishedListener onFinishedListener) {
        apiClient.getRandom().enqueue(new Callback<CocktailResponse>() {
            @Override
            public void onResponse(Call<CocktailResponse> call, Response<CocktailResponse> response) {
                if (response.body() != null) {
                    randomCocktailList.addAll(response.body().getCocktails());
                   onFinishedListener.onFinished(randomCocktailList);
                    Log.d(TAG, "Random Drinks Response" + response.body());


                }
            }

            @Override
            public void onFailure(Call<CocktailResponse> call, Throwable t) {
                onFinishedListener.onFailure(t);
                Log.d(TAG, "onFailure" + t.getMessage());
            }
        });


    }
}
