package org.pursuit.team_6_happyhouranytime.presenter;

import org.pursuit.team_6_happyhouranytime.models.Cocktail;
import org.pursuit.team_6_happyhouranytime.models.CocktailListModel;
import org.pursuit.team_6_happyhouranytime.network.ApiClient;
import org.pursuit.team_6_happyhouranytime.network.CocktailsAPI;
import org.pursuit.team_6_happyhouranytime.presentation.CocktailsContract;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class MainPresenter implements CocktailsContract.Presenter {
    private CocktailsAPI cocktailsAPI;
    private CocktailsContract.View viewBeingReferenced;
    private CocktailsContract.Model apiCall;
    private ApiClient apiClient;
    private List<Cocktail> cocktails = new ArrayList<>();
    private WeakReference<CocktailsContract.View> viewWeakReference;



    public MainPresenter(CocktailsContract.View cocktailsView) {

        this.viewBeingReferenced = cocktailsView;
        apiCall = new CocktailListModel();
    }


    public void detach() {

    }

    @Override
    public void showCocktail() {

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
