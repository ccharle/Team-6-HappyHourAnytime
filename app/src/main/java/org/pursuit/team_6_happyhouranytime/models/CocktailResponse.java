package org.pursuit.team_6_happyhouranytime.models;

import java.util.List;

public class CocktailResponse {
    private List<Cocktail>drinks;

    public CocktailResponse(List<Cocktail> drinks) {
        this.drinks = drinks;
    }

    public List<Cocktail> getDrinks() {
        return drinks;
    }
}
