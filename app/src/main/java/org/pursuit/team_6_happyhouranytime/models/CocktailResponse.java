package org.pursuit.team_6_happyhouranytime.models;

import java.util.List;

public class CocktailResponse {
    private List<Cocktail> cocktailList;
    private List<String> ingredientsList;



    public CocktailResponse(List<Cocktail> cocktailList) {
        this.cocktailList = cocktailList;
    }

    public List<Cocktail> getCocktails() {
        return cocktailList;
    }
//
//
//    public String ingredientsList() {
//        ingredientsList = new ArrayList<>();
//        ingredientsList.add(cocktailList.get(0).getStrIngredient1());
//        ingredientsList.add(cocktailList.get(0).getStrIngredient2());
//        ingredientsList.add(cocktailList.get(0).getStrIngredient3());
//        ingredientsList.add(cocktailList.get(0).getStrIngredient4());
//        ingredientsList.add(cocktailList.get(0).getStrIngredient5());
//        ingredientsList.add(cocktailList.get(0).getStrIngredient6());
//        ingredientsList.add(cocktailList.get(0).getStrIngredient7());
//        ingredientsList.add(cocktailList.get(0).getStrIngredient8());
//        ingredientsList.add(cocktailList.get(0).getStrIngredient9());
//        ingredientsList.add(cocktailList.get(0).getStrIngredient10());
//        ingredientsList.add(cocktailList.get(0).getStrIngredient11());
//        ingredientsList.add(cocktailList.get(0).getStrIngredient12());
//        ingredientsList.add(cocktailList.get(0).getStrIngredient13());
//        ingredientsList.add(cocktailList.get(0).getStrIngredient14());
//        ingredientsList.add(cocktailList.get(0).getStrIngredient15());
//
//        ingredientsList.removeAll(Arrays.asList(""));
//
//    }
}
