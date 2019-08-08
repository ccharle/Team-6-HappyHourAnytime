package org.pursuit.team_6_happyhouranytime.network;

import org.pursuit.team_6_happyhouranytime.models.Cocktail;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static ApiClient instance;
    private static Retrofit retrofit;
    private static final String BASE_URL = "https://www.thecocktaildb.com/";


     public static  <S> S createRequest(Class <S> serviceClass){
         if(instance == null){

              Retrofit.Builder builder = new Retrofit.Builder().
                     baseUrl(BASE_URL)
                     .addConverterFactory(GsonConverterFactory.create());
                retrofit = builder.build();
                instance = new ApiClient();


         }

         return  retrofit.create(serviceClass);





     }




}
