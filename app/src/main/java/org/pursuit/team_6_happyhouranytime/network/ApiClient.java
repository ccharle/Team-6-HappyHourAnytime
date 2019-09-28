package org.pursuit.team_6_happyhouranytime.network;

import org.pursuit.team_6_happyhouranytime.model.CocktailResponse;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static ApiClient instance = null;
    private CocktailsAPI cocktailsAPI;
    private static final String BASE_URL = "https://www.thecocktaildb.com/";


    private ApiClient() {
        initApis();
    }

    public static ApiClient getInstance() {
        if (instance == null) {
            instance = new ApiClient();
            instance.initApis();
            return instance;
        }

        return instance;
    }


    private void initApis() {
        cocktailsAPI = createRetrofit(BASE_URL).create(CocktailsAPI.class);
    }


    private Retrofit createRetrofit(String baseUrl) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        OkHttpClient client = builder.build();
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
    }

    public Call<CocktailResponse> getRandom() {
        return cocktailsAPI.getRandomCocktails();


    }

    public Call<CocktailResponse> getCocktails() {
        return cocktailsAPI.getCocktails();
    }


}



