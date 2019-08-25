package org.pursuit.team_6_happyhouranytime;


import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.widget.Button;
import android.widget.FrameLayout;

import com.google.android.material.tabs.TabLayout;

import org.pursuit.team_6_happyhouranytime.models.Cocktail;
import org.pursuit.team_6_happyhouranytime.models.CocktailListModel;
import org.pursuit.team_6_happyhouranytime.models.CocktailResponse;
import org.pursuit.team_6_happyhouranytime.network.ApiClient;
import org.pursuit.team_6_happyhouranytime.presentation.CocktailsContract;
import org.pursuit.team_6_happyhouranytime.presenter.MainPresenter;
import org.pursuit.team_6_happyhouranytime.views.RandomDrinksFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity implements CocktailsContract.View {
    private static final String TAG = "main";
    private MainPresenter mainPresenter;
    public static final String DRINK_KEY = "drinks";
    private AlertDialog.Builder dialog;
    private List<Cocktail> drinkList;
    private CocktailListModel.OnFinishedListener onFinishedListener;
    private CocktailsContract cocktailsContract;
    private Button random_button;
    private ApiClient apiClient;
    @BindView(R.id.info_tablayout)
    TabLayout infoTabLayout;
    @BindView(R.id.main_container)
    FrameLayout mainContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setViews();
        viewBehaviours();

    }

    private void setViews() {
        RandomDrinksFragment randomDrinksFragment = new RandomDrinksFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main_container, randomDrinksFragment)
                .commit();


    }


    private void viewBehaviours() {
        infoTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {


            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    private void getRandomCocktails() {

        apiClient = ApiClient.getInstance();
        apiClient.getRandom().enqueue(new Callback<CocktailResponse>() {
            @Override
            public void onResponse(Call<CocktailResponse> call, Response<CocktailResponse> response) {
                if (response.body() != null) {
                    drinkList = new ArrayList<>();
                    drinkList.addAll(response.body().getDrinks());
                }

            }

            @Override
            public void onFailure(Call<CocktailResponse> call, Throwable t) {
                Log.d(TAG, "OnFailure" + t.getMessage());

            }
        });
    }

    @Override
    public void tabSelection() {

    }

    @Override
    public void refreshData() {

    }
}
