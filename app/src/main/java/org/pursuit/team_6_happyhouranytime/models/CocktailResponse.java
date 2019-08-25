package org.pursuit.team_6_happyhouranytime.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CocktailResponse {
    private List<Cocktail> drinks;
    private List<String> ingredientsList;
    private Cocktail cocktail ;


    public CocktailResponse(List<Cocktail> drinks) {
        this.drinks = drinks;
    }

    public List<Cocktail> getDrinks() {
        return drinks;
    }
//
//
//    public String ingredientsList() {
//        ingredientsList = new ArrayList<>();
//        ingredientsList.add(drinks.get(0).getStrIngredient1());
//        ingredientsList.add(drinks.get(0).getStrIngredient2());
//        ingredientsList.add(drinks.get(0).getStrIngredient3());
//        ingredientsList.add(drinks.get(0).getStrIngredient4());
//        ingredientsList.add(drinks.get(0).getStrIngredient5());
//        ingredientsList.add(drinks.get(0).getStrIngredient6());
//        ingredientsList.add(drinks.get(0).getStrIngredient7());
//        ingredientsList.add(drinks.get(0).getStrIngredient8());
//        ingredientsList.add(drinks.get(0).getStrIngredient9());
//        ingredientsList.add(drinks.get(0).getStrIngredient10());
//        ingredientsList.add(drinks.get(0).getStrIngredient11());
//        ingredientsList.add(drinks.get(0).getStrIngredient12());
//        ingredientsList.add(drinks.get(0).getStrIngredient13());
//        ingredientsList.add(drinks.get(0).getStrIngredient14());
//        ingredientsList.add(drinks.get(0).getStrIngredient15());
//
//        ingredientsList.removeAll(Arrays.asList(""));
//
//    }
}
