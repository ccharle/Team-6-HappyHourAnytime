package org.pursuit.team_6_happyhouranytime.models;

public class Drinks {
    private String strDrink;
    private String strInstructions;
    private String strIngredient1;
    private String strIngredient2;
    private String strIngredient3;
    private String strMeasure1;
    private String strMeasure2;
    private String strMeasure3;

    public Drinks(String strDrink, String strInstructions, String strIngredient1, String strIngredient2, String strIngredient3, String strMeasure1, String strMeasure2, String strMeasure3) {
        this.strDrink = strDrink;
        this.strInstructions = strInstructions;
        this.strIngredient1 = strIngredient1;
        this.strIngredient2 = strIngredient2;
        this.strIngredient3 = strIngredient3;
        this.strMeasure1 = strMeasure1;
        this.strMeasure2 = strMeasure2;
        this.strMeasure3 = strMeasure3;
    }

    public String getStrDrink() {
        return strDrink;
    }

    public String getStrInstructions() {
        return strInstructions;
    }

    public String getStrIngredient1() {
        return strIngredient1;
    }

    public String getStrIngredient2() {
        return strIngredient2;
    }

    public String getStrIngredient3() {
        return strIngredient3;
    }

    public String getStrMeasure1() {
        return strMeasure1;
    }

    public String getStrMeasure2() {
        return strMeasure2;
    }

    public String getStrMeasure3() {
        return strMeasure3;
    }
}
