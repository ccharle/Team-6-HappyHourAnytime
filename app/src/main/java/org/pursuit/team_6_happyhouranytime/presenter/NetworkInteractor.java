package org.pursuit.team_6_happyhouranytime.presenter;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import org.pursuit.team_6_happyhouranytime.models.Cocktail;
import org.pursuit.team_6_happyhouranytime.models.CocktailResponse;
import org.pursuit.team_6_happyhouranytime.network.ApiClient;
import org.pursuit.team_6_happyhouranytime.presentation.MainContract;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

//This class will have actual business logic for fetching data from a server.
// This class will implement NetworkInteractor Interface from Contract Interface

public class NetworkInteractor implements MainContract.NetworkInteractor {
    private Context context;
    private ApiClient apiClient;
    private final String TAG = "CocktailsListModel";
    private List<Cocktail> cocktailList = new ArrayList<>();
    private List<Cocktail> randomCocktailList;

    public NetworkInteractor(ApiClient apiClient, Context context) {
        this.apiClient = apiClient;
        this.context = context;
    }

//    @Override
//    public void getCocktailList(OnFinishedListener onFinishedListener) {
//        apiClient.getCocktails().enqueue(new Callback<CocktailResponse>() {
//            @Override
//            public void onResponse(Call<CocktailResponse> call, Response<CocktailResponse> response) {
//
//                if (response.body() != null) {
//                    cocktailList.addAll(response.body().getCocktails());
//                    onFinishedListener.onFinished(cocktailList);
//                    Log.d(TAG, "Random Drinks Response" + response.body());
//
//                }
//
//            }
//
//            @Override
//            public void onFailure(Call<CocktailResponse> call, Throwable t) {
//                onFinishedListener.onFailure(t);
//
//            }
//        });
//
//    }

    @Override
    public void getRandomCocktailList(OnFinishedListener onFinishedListener) {
        apiClient.getRandom().enqueue(new Callback<CocktailResponse>() {
            @Override
            public void onResponse(Call<CocktailResponse> call, Response<CocktailResponse> response) {
                if (response.body() != null) {
                    randomCocktailList = new ArrayList<>();
                    Toast.makeText(context,"sweet",Toast.LENGTH_LONG).show();
                    randomCocktailList.addAll(response.body().getDrinks()) ;
                   onFinishedListener.onFinished(randomCocktailList);
                    Log.d(TAG, "Random Drinks Response" + response.body());


                }
            }

            @Override
            public void onFailure(Call<CocktailResponse> call, Throwable t) {
                onFinishedListener.onFailure(t);
                Toast.makeText(context,"Fail",Toast.LENGTH_LONG).show();
                Log.d(TAG, "onFailure" + t.getMessage());
            }
        });


    }
}