package org.pursuit.team_6_happyhouranytime;


import android.content.Intent;
import android.content.DialogInterface;
import android.os.Parcelable;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.TextView;

import org.pursuit.team_6_happyhouranytime.models.Drinks;
import org.pursuit.team_6_happyhouranytime.models.DrinksResponse;
import org.pursuit.team_6_happyhouranytime.network.RetrofitSingleton;
import org.pursuit.team_6_happyhouranytime.recyclerview.DrinkAdapter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import retrofit2.Response;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = "main";
    public static final String DRINK_KEY = "drinks";

    private Button seachByNameButton;
    private Button seachByIngredientsButton;
    private Button pickADrinkAtRandomButton;
    private AlertDialog.Builder dialog;
    private List<Drinks> drinkList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();

        dialog = new AlertDialog.Builder(MainActivity.this);
        dialog.setCancelable(false);
        dialog.setTitle("WARNING!!!");
        dialog.setMessage("GOVERNMENT WARNING: (1) According to the Surgeon General, women should not drink alcoholic beverages during pregnancy because of the risk of birth defects. (2) Consumption of alcoholic beverages impairs your ability to drive a car or operate machinery, and may cause health problems.");
        dialog.setPositiveButton("Acknowledge", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog1, int id) {


                Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content), "Happy Drinking!!!", Snackbar.LENGTH_LONG);
                View view = snackbar.getView();
                TextView tv = view.findViewById(android.support.design.R.id.snackbar_text);
                tv.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.snackColor));
                tv.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                snackbar.show();
            }

        })
                .setNegativeButton("Don't Acknowledge", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        finish();
                        System.exit(0);
                    }
                })

                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();

    }

    private void findViews() {
        seachByNameButton = findViewById(R.id.search_by_name_button);
        seachByIngredientsButton = findViewById(R.id.search_by_ingredients_button);
        pickADrinkAtRandomButton = findViewById(R.id.pick_random_drink_button);

        seachByNameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SearchViewActivity.class);
                startActivity(intent);
            }
        });

        seachByIngredientsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });

        pickADrinkAtRandomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        MainActivity.this, RandomDrinkSelected.class);
                startActivity(intent);
            }
        });
    }
}
