package org.pursuit.team_6_happyhouranytime.presenter;

import org.pursuit.team_6_happyhouranytime.models.Cocktail;
import org.pursuit.team_6_happyhouranytime.presentation.MainContract;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class FragmentPresenter implements MainContract.FragPresenter, MainContract.NetworkInteractor.OnFinishedListener {
    private MainContract.NetworkInteractor networkInteractor;
    private MainContract.View view;
    private List<Cocktail> cocktails = new ArrayList<>();
    private WeakReference<MainContract.View> viewWeakReference;


    public FragmentPresenter(MainContract.View cocktailsView, MainContract.NetworkInteractor networkInteractor) {

        this.view = cocktailsView;
        this.networkInteractor = networkInteractor;

    }


    @Override
    public void requestRandomCocktail(MainContract.NetworkInteractor.OnFinishedListener onFinishedListener) {

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
