package org.pursuit.team_6_happyhouranytime;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.widget.TextView;

import com.google.gson.Gson;

import org.pursuit.team_6_happyhouranytime.models.Drinks;
import org.pursuit.team_6_happyhouranytime.models.DrinksResponse;
import org.pursuit.team_6_happyhouranytime.network.RetrofitSingleton;
import org.pursuit.team_6_happyhouranytime.recyclerview.DrinkAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RandomDrinkSelected extends AppCompatActivity {

    private static final String TAG = "random";

    private TextView randomDrinkSelectedTextview;
    private TextView randomDrinkSelectedIngredientsTextView;
    private List <Drinks> drinkList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_drink_selected);

        randomDrinkSelectedTextview = findViewById(R.id.name_of_random_drink_textview);
        randomDrinkSelectedIngredientsTextView  = findViewById(R.id.random_drink_ingredients_textview);
        getRetrofitCall();
    }

    public void getRetrofitCall() {
        RetrofitSingleton.getInstance()
                .getBartenderService()
                .getRandomDrinks()
                .enqueue(new Callback<DrinksResponse>() {
                    @Override
                    public void onResponse(Call<DrinksResponse> call, Response<DrinksResponse> response) {
                        Log.d(TAG, "OnResponse" + response.body());
                        drinkList = new ArrayList<>();
                        if (response.body() != null) {
                            drinkList.addAll(response.body().getDrinks());
                        }
                        randomDrinkSelectedTextview.setText(drinkList.get(0).getStrIngredient1());
                        randomDrinkSelectedIngredientsTextView.setText(drinkList.get(0).getStrDrink());
                    }

                    @Override
                    public void onFailure(Call<DrinksResponse> call, Throwable t) {
                        Log.d(TAG, t.getMessage());
                    }
                });
    }

}
