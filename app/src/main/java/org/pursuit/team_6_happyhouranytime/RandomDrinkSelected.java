package org.pursuit.team_6_happyhouranytime;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class RandomDrinkSelected extends AppCompatActivity {

    private TextView randomDrinkSelectedTextview;
    private TextView randomDrinkSelectedIngredientsTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_drink_selected);

        randomDrinkSelectedTextview = findViewById(R.id.name_of_random_drink_textview);
        randomDrinkSelectedIngredientsTextView  = findViewById(R.id.random_drink_ingredients_textview);
    }

}
