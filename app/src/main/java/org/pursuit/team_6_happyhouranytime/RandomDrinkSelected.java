package org.pursuit.team_6_happyhouranytime;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.widget.ImageView;

import android.util.Log;

import android.widget.TextView;


import com.squareup.picasso.Picasso;

import org.pursuit.team_6_happyhouranytime.models.Drinks;
import org.pursuit.team_6_happyhouranytime.models.DrinksResponse;
import org.pursuit.team_6_happyhouranytime.network.RetrofitSingleton;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class  RandomDrinkSelected extends AppCompatActivity {

    private static final String TAG = "random";

    private TextView randomDrinkSelectedTextview;
    private TextView randomDrinkSelectedIngredientsTextView;
    private TextView randomInstuctions;
    private ImageView randomDrinkSelectedImageView;

    private List <Drinks> drinkList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.random_drinks);

        randomDrinkSelectedTextview = findViewById(R.id.name_of_random_drink_textview);
        randomDrinkSelectedIngredientsTextView  = findViewById(R.id.random_drink_ingredients_textview);
        randomDrinkSelectedImageView = findViewById(R.id.random_selected_drink_imageView);
        randomInstuctions = findViewById(R.id.instructions);
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
                        randomDrinkSelectedTextview.setText(drinkList.get(0).getStrDrink());

                        String firstIngredient = drinkList.get(0).getStrIngredient1();
                        String secondIngredient = drinkList.get(0).getStrIngredient2();
                        String thirdIngredient = drinkList.get(0).getStrIngredient3();

                        String drinkInstruction = drinkList.get(0).getStrInstructions();

                        randomDrinkSelectedIngredientsTextView.setText(firstIngredient + "\n "+ secondIngredient + "\n" +thirdIngredient);
                        randomInstuctions.setText(drinkInstruction);

                        String drinkImage = drinkList.get(0).getStrDrinkThumb();
                        Picasso.get()
                                .load(drinkImage)
                                .into(randomDrinkSelectedImageView);
                    }

                    @Override
                    public void onFailure(Call<DrinksResponse> call, Throwable t) {
                        Log.d(TAG, t.getMessage());
                    }
                });
    }

}
