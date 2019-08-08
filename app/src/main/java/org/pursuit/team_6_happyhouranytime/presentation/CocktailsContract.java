package org.pursuit.team_6_happyhouranytime.presentation;

import org.pursuit.team_6_happyhouranytime.models.Cocktail;

import java.util.List;

//This interface will contain all the methods that our View,
// Model and Presenter going to implements.
public interface CocktailsContract {

    interface Model {

        interface OnFinishedListener {

            void onFinished(List<Cocktail> cocktailList);

            void onFailure(Throwable t);

        }

        void getRandomCocktailsList(OnFinishedListener onFinishedListener);

        void searchCocktails(OnFinishedListener onFinishedListener);
    }

    interface View {

        void refresh();

        void showLoading();

        void showFailedMessage();

        void showRandomCocktail();


    }

    interface Presenter {


        void onDestroy();

        void requestData();
    }
}

