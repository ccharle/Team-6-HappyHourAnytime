package org.pursuit.team_6_happyhouranytime.presenter;

import org.pursuit.team_6_happyhouranytime.models.Cocktail;
import org.pursuit.team_6_happyhouranytime.models.CocktailResponse;
import org.pursuit.team_6_happyhouranytime.presentation.CocktailsContract;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class MainPresenter implements CocktailsContract.Presenter {
    private CocktailsContract.Model model;
    private CocktailsContract.View viewBeingReferenced;

    private List<Cocktail> cocktails = new ArrayList<>();
    private WeakReference<CocktailsContract.View> viewWeakReference;


    public MainPresenter(CocktailsContract.View cocktailsView) {

        this.viewBeingReferenced = cocktailsView;
    }

    public MainPresenter(CocktailsContract.Model model) {
        this.model = model;
    }


    @Override
    public void showCocktail(List<CocktailResponse> cocktailResponse) {

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
