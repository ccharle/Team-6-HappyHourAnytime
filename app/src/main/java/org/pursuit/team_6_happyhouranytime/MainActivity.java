package org.pursuit.team_6_happyhouranytime;


import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import org.pursuit.team_6_happyhouranytime.models.Cocktail;
import org.pursuit.team_6_happyhouranytime.models.CocktailListModel;
import org.pursuit.team_6_happyhouranytime.presentation.CocktailsContract;
import org.pursuit.team_6_happyhouranytime.presenter.MainPresenter;
import org.pursuit.team_6_happyhouranytime.views.RandomDrinksFragment;

import java.util.List;

import butterknife.BindView;


public class MainActivity extends AppCompatActivity implements CocktailsContract.View,CocktailsContract.Model.OnFinishedListener {
    private static final String TAG = "main";
    private MainPresenter mainPresenter;
    public static final String DRINK_KEY = "drinks";
    private AlertDialog.Builder dialog;
    private List<Cocktail> drinkList;
    private CocktailListModel.OnFinishedListener onFinishedListener;
    private CocktailsContract cocktailsContract;
    private Button random_button;
    @BindView(R.id.main_container)
    FrameLayout mainContainer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainPresenter = new MainPresenter(this);
        setViews();

    }

    private void setViews() {
        RandomDrinksFragment randomDrinksFragment = new RandomDrinksFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main_container,randomDrinksFragment )
                .commit();


    }


    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void setDataToRecyclerView(List<Cocktail> movieArrayList) {

    }

    @Override
    public void onResponseFailure(Throwable throwable) {

    }

    @Override
    public void onFinished(List<Cocktail> cocktailList) {

    }

    @Override
    public void onFailure(Throwable t) {

    }


}
