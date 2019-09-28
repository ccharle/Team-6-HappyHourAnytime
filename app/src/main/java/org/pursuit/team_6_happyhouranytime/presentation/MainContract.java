package org.pursuit.team_6_happyhouranytime.presentation;

import org.pursuit.team_6_happyhouranytime.model.Response;

import java.util.List;

/**
 * This interface contains all the methods that our View,
 * NetworkInteractor and FragPresenter going to implement
 **/

public interface MainContract {

    interface NetworkInteractor {


        interface OnFinishedListener {

            void onFinished(List<Response> cocktailResponse);

            void onFailure(Throwable t);
        }

        // void getCocktailList(OnFinishedListener onFinishedListener);

        void getRandomCocktailList(OnFinishedListener onFinishedListener);

    }


    interface FragPresenter {



        void requestRandomCocktail(NetworkInteractor.OnFinishedListener onFinishedListener);


        void requestByCocktail();

        void showError();

        void requestData();

    }


    interface ActivityPresenter {


        void onDestroy();


    }

    interface View {

        void refreshData();

        void displayCocktailName(String cocktailName);

        void displayCocktailImage(String imgUrl);

        void onResponseFailure(Throwable throwable);
    }


}