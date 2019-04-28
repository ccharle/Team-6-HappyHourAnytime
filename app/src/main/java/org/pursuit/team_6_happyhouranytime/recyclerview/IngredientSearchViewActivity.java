package org.pursuit.team_6_happyhouranytime.recyclerview;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import org.pursuit.team_6_happyhouranytime.R;
import org.pursuit.team_6_happyhouranytime.models.Drinks;
import org.pursuit.team_6_happyhouranytime.models.DrinksResponse;
import org.pursuit.team_6_happyhouranytime.network.RetrofitSingleton;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class IngredientSearchViewActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    private static final String TAG = "ingredient";

    private RecyclerView recyclerView;
    private SearchView searchView;
    private List<Drinks> drinkList;
    private DrinkAdapter adapter;
    private String input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_view);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        recyclerView = findViewById(R.id.search_recyclerView);
        recyclerView.setHasFixedSize(true);
        getRetrofitCall();
    }

    public void getRetrofitCall() {
        RetrofitSingleton.getInstance()
                .getBartenderService()
                .getIngredient(input)
                .enqueue(new Callback<DrinksResponse>() {

                    @Override
                    public void onResponse(Call<DrinksResponse> call, Response<DrinksResponse> response) {
                        Log.d(TAG, "OnResponse" + response.body());
                        drinkList = new ArrayList<>();
                        if (response.body() != null) {
                            drinkList.addAll(response.body().getDrinks());
                        }
                        adapter = new DrinkAdapter(drinkList);
                        recyclerView.setAdapter(adapter);
                        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                    }

                    @Override
                    public void onFailure(Call<DrinksResponse> call, Throwable t) {
                        Log.d(TAG, t.getMessage());
                    }
                });
        searchView = findViewById(R.id.searchView);
        searchView.setOnQueryTextListener(this);
    }

    @Override
    public boolean onQueryTextSubmit(String s) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {
        List<Drinks> newDrinkList = new ArrayList<>();
        for (Drinks d : drinkList) {
            if (d.getStrDrink().toLowerCase().startsWith(s.toLowerCase()))
                newDrinkList.add(d);
        }
        adapter.setData(newDrinkList);
        return false;
    }

}
