package org.pursuit.team_6_happyhouranytime;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.pursuit.team_6_happyhouranytime.models.DrinksResponse;
import org.pursuit.team_6_happyhouranytime.network.RetrofitSingleton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private Button testCallButton;
    private EditText drinksText;
    private final String TAG = "Drink Response";
    private Button seachByNameButton;
    private Button seachByIngredientsButton;
    private Button pickADrinkAtRandomButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      findViews();
      
        testCallButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Drinks = drinksText.getText().toString().toLowerCase();

                RetrofitSingleton.getInstance()
                       // .getBartenderService().getDrinks(Drinks)
                        .enqueue(new Callback<DrinksResponse>() {
                            @Override
                            public void onResponse(Call<DrinksResponse> call, Response<DrinksResponse> response) {
                                Log.d(TAG, "OnResponse" + response.body());
                            }

                            @Override
                            public void onFailure(Call<DrinksResponse> call, Throwable t) {
                                Log.d(TAG, t.getMessage());
                            }
                        });

private void findViews(){
    testCallButton = findViewById(R.id.test_call_button);
        drinksText = findViewById(R.id.enter_drinks);

        seachByNameButton = findViewById(R.id.search_by_name_button);
        seachByIngredientsButton = findViewById(R.id.search_by_ingredients_button);
        pickADrinkAtRandomButton = findViewById(R.id.pick_random_drink_button);


        seachByNameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });

        seachByIngredientsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



            }
        });
}
  

    }



        pickADrinkAtRandomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });
    }

}
