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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        testCallButton = findViewById(R.id.test_call_button);
        drinksText = findViewById(R.id.enter_drinks);

        testCallButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Drinks = drinksText.getText().toString().toLowerCase();

                RetrofitSingleton.getInstance()
                        .getBartenderService().getDrinks(Drinks)
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


            }
        });


    }


}
