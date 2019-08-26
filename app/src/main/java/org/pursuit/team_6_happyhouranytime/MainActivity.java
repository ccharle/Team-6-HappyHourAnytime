package org.pursuit.team_6_happyhouranytime;


import android.os.Bundle;
import android.widget.Button;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.tabs.TabLayout;

import org.pursuit.team_6_happyhouranytime.presentation.MainContract;
import org.pursuit.team_6_happyhouranytime.views.RandomDrinksFragment;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity implements MainContract.View {
    private static final String TAG = "main";
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
    public void refreshData() {

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
