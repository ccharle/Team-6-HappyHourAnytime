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

        void showProgress();

        void hideProgress();

        void setDataToRecyclerView(List<Cocktail> movieArrayList);

        void onResponseFailure(Throwable throwable);


    }

    interface Presenter {


        void onDestroy();

        void requestData();
    }
}

