package org.pursuit.team_6_happyhouranytime.network;

import com.google.gson.Gson;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {
   static Retrofit.Builder builder = new Retrofit.Builder()
            .baseUrl("https://www.thecocktaildb.com/")
            .addConverterFactory(GsonConverterFactory.create());

    static Retrofit retrofit = builder.build();

    public static <T> T createService(Class<T> serviceClass){
        return  retrofit.create(serviceClass);
    }



}
