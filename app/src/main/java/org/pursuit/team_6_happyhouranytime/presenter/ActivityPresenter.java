package org.pursuit.team_6_happyhouranytime.presenter;

import org.pursuit.team_6_happyhouranytime.model.Response;
import org.pursuit.team_6_happyhouranytime.presentation.MainContract;

import java.util.List;

public class ActivityPresenter implements MainContract.ActivityPresenter, MainContract.NetworkInteractor.OnFinishedListener {
    private MainContract.View view;
    private NetworkInteractor networkInteractor;

    public ActivityPresenter(MainContract.View view, NetworkInteractor networkInteractor) {
        this.view = view;
        this.networkInteractor = networkInteractor;
    }


    @Override
    public void onDestroy() {
        view = null;

    }

    @Override
    public void onFinished(List<Response> cocktailResponse) {


    }

    @Override
    public void onFailure(Throwable t) {

    }
}
