package org.pursuit.team_6_happyhouranytime.presentation;

import org.pursuit.team_6_happyhouranytime.models.Cocktail;
import org.pursuit.team_6_happyhouranytime.models.CocktailResponse;

import java.util.List;

//This interface will contain all the methods that our View,
// CocktailIntractor and Presenter going to implements.
public interface CocktailsContract {

    interface CocktailIntractor {


        interface OnFinishedListener {

            void onFinished(List<Cocktail> cocktailResponse);

            void onFailure(Throwable t);
        }

        void getCocktailResponse(OnFinishedListener onFinishedListener);

        void getRandomResponse(OnFinishedListener onFinishedListener);

    }


    interface Presenter {

        void showCocktail(List<Cocktail> cocktailResponse);

        void showRandomCocktail(List<Cocktail> cocktailResponse);

        void showIngredient();

        void showInstruction();

        void showError();

    }

    interface View {

        void displayCocktails(List<Cocktail> cocktailResponse);

        void displayRandomCocktails(List<Cocktail> cocktailResponse);

        void tabSelection();

        void refreshData();
    }

}