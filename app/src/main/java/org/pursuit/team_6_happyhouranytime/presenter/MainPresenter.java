package org.pursuit.team_6_happyhouranytime.presenter;

import org.pursuit.team_6_happyhouranytime.models.Cocktail;
import org.pursuit.team_6_happyhouranytime.models.CocktailListModel;
import org.pursuit.team_6_happyhouranytime.network.ApiClient;
import org.pursuit.team_6_happyhouranytime.network.CocktailsAPI;
import org.pursuit.team_6_happyhouranytime.presentation.CocktailsContract;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class MainPresenter implements CocktailsContract.Presenter, CocktailsContract.Model.OnFinishedListener {
    private CocktailsAPI cocktailsAPI;
    private CocktailsContract.View viewBeingReferenced;
    private CocktailsContract.Model apiCall;
    private ApiClient apiClient;
    private List<Cocktail> cocktails = new ArrayList<>();
    private WeakReference<CocktailsContract.View> viewWeakReference;


    public void attach(CocktailsContract presentation) {

    }


    public MainPresenter(CocktailsContract.View cocktailsView) {

        this.viewBeingReferenced = cocktailsView;
        apiCall = new CocktailListModel();
    }


    @Override
    public void onDestroy() {
        this.viewBeingReferenced = null;

    }

    @Override
    public void requestData() {
        if (viewBeingReferenced != null) {
            viewBeingReferenced.showProgress();

        }
        apiCall.getRandomCocktailsList(this);

    }

    @Override
    public void onFinished(List<Cocktail> cocktailList) {
        viewBeingReferenced.setDataToRecyclerView(cocktailList);
        if (viewBeingReferenced != null) {
            viewBeingReferenced.hideProgress();

        }

    }

    @Override
    public void onFailure(Throwable t) {
        viewBeingReferenced.onResponseFailure(t);
        if (viewBeingReferenced != null) {
            viewBeingReferenced.hideProgress();
        }

    }

    public void detach() {

    }
}
