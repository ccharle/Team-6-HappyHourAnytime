package org.pursuit.team_6_happyhouranytime.presenter;

import android.widget.Toast;

import org.pursuit.team_6_happyhouranytime.models.Cocktail;
import org.pursuit.team_6_happyhouranytime.presentation.MainContract;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class FragmentPresenter implements MainContract.FragPresenter, MainContract.CocktailIntractor.OnFinishedListener {
    private MainContract.CocktailIntractor cocktailIntractor;
    private MainContract.View view;
    private List<Cocktail> cocktails = new ArrayList<>();
    private WeakReference<MainContract.View> viewWeakReference;


    public FragmentPresenter(MainContract.View cocktailsView, MainContract.CocktailIntractor cocktailIntractor) {

        this.view = cocktailsView;
        this.cocktailIntractor = cocktailIntractor;

    }


    @Override
    public void requestRandomCocktail(MainContract.CocktailIntractor.OnFinishedListener onFinishedListener) {

    }


    @Override
    public void requestByCocktail() {

    }


    @Override
    public void showError() {

    }

    @Override
    public void onFinished(List<Cocktail> cocktailResponse) {
        if (view != null) {
            view.displayCocktailImage(cocktailResponse.get(0).getStrDrinkThumb());
            view.displayCocktailName(cocktailResponse.get(0).getStrDrink());


        }

    }

    @Override
    public void onFailure(Throwable t) {
        if (view != null) {
            view.onResponseFailure(t);
        }

    }
}
