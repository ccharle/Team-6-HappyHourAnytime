package org.pursuit.team_6_happyhouranytime.presentation;

import org.pursuit.team_6_happyhouranytime.models.Cocktail;
import org.pursuit.team_6_happyhouranytime.models.CocktailResponse;

import java.util.List;

//This interface will contain all the methods that our View,
// Model and Presenter going to implements.
public interface CocktailsContract {

    interface Model {

        void getCocktails(List<CocktailResponse> cocktailResponseList);
    }


    interface Presenter {

        void showCocktail();

        void showIngredient();

        void showInstruction();

        void showError();

    }

    interface View {

        void tabSelection();

        void refreshData();
    }

}