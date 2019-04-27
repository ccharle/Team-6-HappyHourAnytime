package org.pursuit.team_6_happyhouranytime.network;

import android.widget.Button;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitSingleton {

    private static RetrofitSingleton ourInstance = null;
    private BartenderService bartenderService;

    private RetrofitSingleton() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.thecocktaildb.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        bartenderService = retrofit.create(BartenderService.class);
    }

    public static RetrofitSingleton getInstance() {
        if (ourInstance == null) {
            ourInstance = new RetrofitSingleton();


        }
        return ourInstance;


    }

    public BartenderService getBartenderService() {
        return bartenderService;
    }

}
