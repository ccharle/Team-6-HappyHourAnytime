package org.pursuit.team_6_happyhouranytime;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;

import org.pursuit.team_6_happyhouranytime.models.Drinks;
import org.pursuit.team_6_happyhouranytime.models.DrinksResponse;
import org.pursuit.team_6_happyhouranytime.network.RetrofitSingleton;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchViewActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    private static final String TAG = "search";

    private List<Drinks> drinkList;
    private DrinkAdapter adapter;
    private String input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_view);
        RecyclerView recyclerView = findViewById(R.id.search_recyclerView);
        recyclerView.setHasFixedSize(true);
        getRetrofitCall();
    }

    public void getRetrofitCall() {
        RetrofitSingleton.getInstance()
                .getBartenderService()
                .getDrinks()
                .enqueue(new Callback<DrinksResponse>() {

                    @Override
                    public void onResponse(Call<DrinksResponse> call, Response<DrinksResponse> response) {
                        Log.d(TAG, "OnResponse" + response.body());
                        drinkList = new ArrayList<>();
                        if (response.body() != null) {
                            drinkList.addAll(response.body().getDrinks());
                        }
                    }

                    @Override
                    public void onFailure(Call<DrinksResponse> call, Throwable t) {
                        Log.d(TAG, t.getMessage());
                    }
                });
    }

    @Override
    public boolean onQueryTextSubmit(String s) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {
        List<Drinks> newDrinkList = new ArrayList<>();
        for (Drinks d : drinkList) {
            if (d.getStrDrink().toLowerCase().startsWith(input.toLowerCase()))
                newDrinkList.add(d);
        }
        adapter.setData(newDrinkList);
        return false;
    }
}