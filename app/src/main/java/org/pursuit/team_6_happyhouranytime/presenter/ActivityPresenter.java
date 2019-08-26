package org.pursuit.team_6_happyhouranytime.presenter;

import org.pursuit.team_6_happyhouranytime.models.Cocktail;
import org.pursuit.team_6_happyhouranytime.presentation.MainContract;

import java.util.List;

public class ActivityPresenter implements MainContract.ActivityPresenter, MainContract.CocktailIntractor.OnFinishedListener {
    private MainContract.View view;
    private MainCocktailIntractor mainCocktailIntractor;

    public ActivityPresenter(MainContract.View view, MainCocktailIntractor mainCocktailIntractor) {
        this.view = view;
        this.mainCocktailIntractor = mainCocktailIntractor;
    }

    @Override
    public void requestData() {
        mainCocktailIntractor.getRandomCocktailList(this);
    }

    @Override
    public void onDestroy() {
        view = null;

    }

    @Override
    public void onFinished(List<Cocktail> cocktailResponse) {


    }

    @Override
    public void onFailure(Throwable t) {

    }
}
