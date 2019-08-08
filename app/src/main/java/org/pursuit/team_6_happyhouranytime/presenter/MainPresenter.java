package org.pursuit.team_6_happyhouranytime.presenter;

import org.pursuit.team_6_happyhouranytime.models.Cocktail;
import org.pursuit.team_6_happyhouranytime.models.CocktailResponse;
import org.pursuit.team_6_happyhouranytime.network.ApiClient;
import org.pursuit.team_6_happyhouranytime.network.CocktailsAPI;
import org.pursuit.team_6_happyhouranytime.presentation.CocktailsContract;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter implements  CocktailsContract.Presenter {
    private CocktailsAPI cocktailsAPI;
    private CocktailsContract cocktailsContract;
    private ApiClient apiClient;
    private List<Cocktail> cocktails = new ArrayList<>();
    private WeakReference<CocktailsContract.View> viewWeakReference;


    public void attach(CocktailsContract presentation) {
        this.cocktailsContract = presentation;
    }

    public void detach() {
        this.cocktailsContract = null;
    }

    public MainPresenter(CocktailsAPI cocktailsAPI) {
        this.cocktailsAPI = cocktailsAPI;
    }


    @Override
    public void onDestroy() {

    }

    @Override
    public void requestData() {

    }
}
