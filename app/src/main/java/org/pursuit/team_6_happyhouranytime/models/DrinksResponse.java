package org.pursuit.team_6_happyhouranytime.models;

import java.util.List;

public class DrinksResponse {
    private List<Drinks>drinks;

    public DrinksResponse(List<Drinks> drinks) {
        this.drinks = drinks;
    }

    public List<Drinks> getDrinks() {
        return drinks;
    }
}
