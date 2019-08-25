package org.pursuit.team_6_happyhouranytime.presenter;

import org.pursuit.team_6_happyhouranytime.models.Cocktail;
import org.pursuit.team_6_happyhouranytime.presentation.CocktailsContract;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class MainPresenter implements CocktailsContract.Presenter {
    private CocktailsContract.CocktailIntractor cocktailIntractor;
    private CocktailsContract.View view;

    private List<Cocktail> cocktails = new ArrayList<>();
    private WeakReference<CocktailsContract.View> viewWeakReference;


    public MainPresenter(CocktailsContract.View cocktailsView) {

        this.view = cocktailsView;
    }

    public MainPresenter(CocktailsContract.CocktailIntractor cocktailIntractor) {
        this.cocktailIntractor = cocktailIntractor;
    }


    @Override
    public void showCocktail(List<Cocktail> cocktailResponse) {
       cocktails = cocktailIntractor

    }

    @Override
    public void showRandomCocktail(List<Cocktail> cocktailResponse) {
        cocktailIntractor.getRandomResponse();

    }

    @Override
    public void showIngredient() {

    }

    @Override
    public void showInstruction() {

    }

    @Override
    public void showError() {

    }
}
