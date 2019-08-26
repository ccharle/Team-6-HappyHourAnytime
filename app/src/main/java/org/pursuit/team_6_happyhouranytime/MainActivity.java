package org.pursuit.team_6_happyhouranytime;


import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.widget.Button;
import android.widget.FrameLayout;

import com.google.android.material.tabs.TabLayout;

import org.pursuit.team_6_happyhouranytime.models.Cocktail;
import org.pursuit.team_6_happyhouranytime.network.ApiClient;
import org.pursuit.team_6_happyhouranytime.presentation.MainContract;
import org.pursuit.team_6_happyhouranytime.presenter.ActivityPresenter;
import org.pursuit.team_6_happyhouranytime.views.RandomDrinksFragment;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity implements MainContract.View {
    private static final String TAG = "main";
    private MainContract.ActivityPresenter activityPresenter;
    private MainContract.NetworkInteractor networkInteractor;
    private org.pursuit.team_6_happyhouranytime.presenter.NetworkInteractor networkInteractor;
    public static final String DRINK_KEY = "drinks";
    private AlertDialog.Builder dialog;
    private List<Cocktail> drinkList;
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
        final ApiClient apiClient = ApiClient.getInstance();
        networkInteractor = new org.pursuit.team_6_happyhouranytime.presenter.NetworkInteractor(apiClient,this);
        activityPresenter = new ActivityPresenter(this, networkInteractor);
        activityPresenter.requestData();
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
    public void displayCocktailName(String cocktailName) {

    }

    @Override
    public void displayCocktailImage(String imgUrl) {

    }


    @Override
    public void onResponseFailure(Throwable throwable) {

    }
}
