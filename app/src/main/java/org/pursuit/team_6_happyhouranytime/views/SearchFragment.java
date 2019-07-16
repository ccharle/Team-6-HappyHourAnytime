package org.pursuit.team_6_happyhouranytime.views;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.pursuit.team_6_happyhouranytime.R;
import org.pursuit.team_6_happyhouranytime.models.Drinks;
import org.pursuit.team_6_happyhouranytime.models.DrinksResponse;
import org.pursuit.team_6_happyhouranytime.network.RetrofitSingleton;
import org.pursuit.team_6_happyhouranytime.recyclerview.DrinkAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchFragment extends Fragment implements SearchView.OnQueryTextListener {
    private static final String TAG = "search";
    private SearchView searchView;
    private List<Drinks> drinkList;
    private DrinkAdapter adapter;
    private RecyclerView recyclerView;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.search_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setViews(view);
    }

    private void setViews(View v) {
        searchView = v.findViewById(R.id.searchView);
        recyclerView = v.findViewById(R.id.search_recyclerView);
        recyclerView.setHasFixedSize(true);
        getRetrofitCall();


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
                        adapter = new DrinkAdapter(drinkList);
                        recyclerView.setAdapter(adapter);
                        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                    }

                    @Override
                    public void onFailure(Call<DrinksResponse> call, Throwable t) {
                        Log.d(TAG, t.getMessage());
                    }
                });

        searchView.setOnQueryTextListener(this);
    }
}
