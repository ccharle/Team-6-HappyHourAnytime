package org.pursuit.team_6_happyhouranytime;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import org.pursuit.team_6_happyhouranytime.models.Drinks;
import org.pursuit.team_6_happyhouranytime.models.DrinksResponse;
import org.pursuit.team_6_happyhouranytime.network.RetrofitSingleton;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NameOrIngredientActivityDisplay extends AppCompatActivity {
    private TextView displayName, displayIngredient, ingredientInfo, instructionText, glassText, glassInfoText;
    private ImageView displayDrink;
    private String drinkId;
    private List<Drinks> drinkList;
    private final String TAG = "IDsearch";
    private final String ID_KEY = "identification";
    private final String TOAST_ERROR = "Check Connection";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name_or_ingredient_display);
        Intent intent = getIntent();
        drinkId = intent.getStringExtra(ID_KEY);
        findViews();
        getRetrofitCall();
    }

    private void getRetrofitCall() {
        RetrofitSingleton.getInstance()
                .getBartenderService()
                .getById(drinkId)
                .enqueue(new Callback<DrinksResponse>() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onResponse(Call<DrinksResponse> call, Response<DrinksResponse> response) {
                        Log.d(TAG, "OnResponse" + response.body());
                        drinkList = new ArrayList<>();
                        if (response.body() != null) {
                            drinkList.addAll(response.body().getDrinks());
                            displayName.setText(drinkList.get(0).getStrDrink());
                            ingredientInfo.setText(drinkList.get(0).getStrIngredient1()
                                    + "\n" + drinkList.get(0).getStrIngredient2()
                                    + "\n" + drinkList.get(0).getStrIngredient3()
                                    + "\n" +  drinkList.get(0).getStrIngredient4()
                                    + "\n" +  drinkList.get(0).getStrIngredient5()
                                    + "\n" +  drinkList.get(0).getStrIngredient6()
                            );
                            Picasso.get().load(drinkList.get(0).getStrDrinkThumb()).placeholder(R.drawable.ic_launcher_foreground)
                                    .resize(500, 500).into(displayDrink);

                        } else {
                            Toast.makeText(
                                    NameOrIngredientActivityDisplay.this, TOAST_ERROR,
                                    Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<DrinksResponse> call, Throwable t) {

                    }
                });
    }

    public void findViews() {
        displayName = findViewById(R.id.name_drink_textview);
        //displayIngredient = findViewById(R.id.inst_info_textView);
        ingredientInfo = findViewById(R.id.inst_info_textView);
        instructionText = findViewById(R.id.inst_header_textView);
        glassText = findViewById(R.id.glass_textView);
        displayDrink = findViewById(R.id.selected_drink_imageView);
    }
}

