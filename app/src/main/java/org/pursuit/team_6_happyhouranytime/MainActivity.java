package org.pursuit.team_6_happyhouranytime;


import android.os.Bundle;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

import org.pursuit.team_6_happyhouranytime.models.Cocktail;
import org.pursuit.team_6_happyhouranytime.models.CocktailListModel;
import org.pursuit.team_6_happyhouranytime.presentation.CocktailsContract;
import org.pursuit.team_6_happyhouranytime.presenter.MainPresenter;

import java.util.List;


public class MainActivity extends AppCompatActivity implements CocktailsContract.View,CocktailsContract.Model.OnFinishedListener {
    private static final String TAG = "main";
    private MainPresenter mainPresenter;
    public static final String DRINK_KEY = "drinks";
    private AlertDialog.Builder dialog;
    private List<Cocktail> drinkList;
    private CocktailListModel.OnFinishedListener onFinishedListener;
    private CocktailsContract cocktailsContract;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainPresenter = new MainPresenter(this);


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

    private void setViews() {
        CocktailListModel cocktailListModel = new CocktailListModel();
        cocktailListModel.getRandomCocktailsList(onFinishedListener);


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
