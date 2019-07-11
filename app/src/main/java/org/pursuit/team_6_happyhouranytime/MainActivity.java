package org.pursuit.team_6_happyhouranytime;


import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import org.pursuit.team_6_happyhouranytime.models.Drinks;
import org.pursuit.team_6_happyhouranytime.recyclerview.IngredientSearchView;
import org.pursuit.team_6_happyhouranytime.views.SearchFragment;

import java.util.List;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = "main";
    public static final String DRINK_KEY = "drinks";
    private AlertDialog.Builder dialog;
    private List<Drinks> drinkList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setViews();
//        dialog = new AlertDialog.Builder(MainActivity.this);
//        dialog.setCancelable(false);
//        dialog.setTitle("WARNING!!!");
//        dialog.setMessage("GOVERNMENT WARNING: (1) According to the Surgeon General, women should not drink alcoholic beverages during pregnancy because of the risk of birth defects. (2) Consumption of alcoholic beverages impairs your ability to drive a car or operate machinery, and may cause health problems.");
//        dialog.setPositiveButton("Acknowledge", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog1, int id) {
//                Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content), "Happy Drinking!!!", Snackbar.LENGTH_LONG);
//                View view = snackbar.getView();
//                TextView tv = view.findViewById(android.support.design.R.id.snackbar_text);
//                tv.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.snackColor));
//                tv.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
//                snackbar.show();
//            }
//
//        })
//
//                .setIcon(android.R.drawable.ic_dialog_alert)
//                .show();
    }

        private void setViews () {
            Button searchByNameButton = findViewById(R.id.search_by_name_button);
            Button searchByIngredientsButton = findViewById(R.id.search_by_ingredients_button);
            Button pickADrinkAtRandomButton = findViewById(R.id.pick_random_drink_button);

            searchByNameButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    SearchFragment searchFragment = new SearchFragment();
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.main_container, searchFragment)
                            .commit();

                    Toast.makeText(getApplicationContext(), "Clicked", Toast.LENGTH_SHORT).show();
                }


            });


            searchByIngredientsButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, IngredientSearchView.class);
                    startActivity(intent);


                }
            });

            pickADrinkAtRandomButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, RandomDrinkSelected.class);

                    startActivity(intent);
                }
            });
        }
}
