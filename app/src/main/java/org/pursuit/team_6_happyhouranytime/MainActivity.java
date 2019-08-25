package org.pursuit.team_6_happyhouranytime;


import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.widget.Button;
import android.widget.FrameLayout;

import com.google.android.material.tabs.TabLayout;

import org.pursuit.team_6_happyhouranytime.models.Cocktail;
import org.pursuit.team_6_happyhouranytime.models.CocktailModel;
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
    private CocktailsContract.Presenter presenter = new MainPresenter(this);
    private CocktailsContract.Model model;
    public static final String DRINK_KEY = "drinks";
    private AlertDialog.Builder dialog;
    private List<Cocktail> drinkList;
    private CocktailsContract cocktailsContract;
    private Button random_button;
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


    @Override
    public void tabSelection() {

    }

    @Override
    public void refreshData() {

    }
}
