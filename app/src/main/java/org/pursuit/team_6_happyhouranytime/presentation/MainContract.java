package org.pursuit.team_6_happyhouranytime.presentation;

import org.pursuit.team_6_happyhouranytime.models.Cocktail;

import java.util.List;

/**
 * This interface contains all the methods that our View,
 * CocktailIntractor and FragPresenter going to implement
 **/

public interface MainContract {

    interface CocktailIntractor {


        interface OnFinishedListener {

            void onFinished(List<Cocktail> cocktailResponse);

            void onFailure(Throwable t);
        }

        // void getCocktailList(OnFinishedListener onFinishedListener);

        void getRandomCocktailList(OnFinishedListener onFinishedListener);

    }


    interface FragPresenter {


        void requestRandomCocktail(CocktailIntractor.OnFinishedListener onFinishedListener);


        void requestByCocktail();

        void showError();

    }


    interface ActivityPresenter {

        void requestData();


        void onDestroy();


    }

    interface View {


        void displayCocktailName(String cocktailName);

        void displayCocktailImage(String imgUrl);


        void onResponseFailure(Throwable throwable);
    }


}