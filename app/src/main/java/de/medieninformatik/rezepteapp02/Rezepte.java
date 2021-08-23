package de.medieninformatik.rezepteapp02;

/**
 * @author Lucas Kahl m27606
 * Semesterabgabe Prog4 Android SoSe 2021
 */

public class Rezepte {

    /**
     * Rezepte Klasse
     * Objekte der Klasse dienen zur Speicherung der Bestandteile der Rezepte
     */
    /**
     * Initialisierung der notwendigen Parameter
     */
    private String RecipeName;
    private String RecipeIngredients;
    private String RecipeSubtitle;
    private String Recipe;
    private int Thumbnail;


    /**
     * Konstruktor
     * @param RecipeName
     * @param RecipeIngredients
     * @param RecipeSubtitle
     * @param Recipe
     * @param Thumbnail
     */
    public Rezepte(String RecipeName, String RecipeIngredients, String RecipeSubtitle ,String Recipe, int Thumbnail) {
        this.RecipeName = RecipeName;
        this.RecipeIngredients = RecipeIngredients;
        this.RecipeSubtitle = RecipeSubtitle;
        this.Recipe = Recipe;
        this.Thumbnail = Thumbnail;
    }

    /**
     * Getter und Setter Methodern zum Lesen und Schreiben der Eigenschaften
     *
     * Aktuell werden nur die Getter benutzt.
     * Setter werden interessant wenn die Anbindung an die Datenbank implementiert wurde,
     * um neue Rezepte zu schreiben.
     * @return
     */
    public String getRecipeName() {
        return RecipeName;
    }

    public String getRecipeIngredients() {
        return RecipeIngredients;
    }

    public String getRecipeSubtitle() {
        return RecipeSubtitle;
    }

    public String getRecipe() {
        return Recipe;
    }

    public int getThumbnail() {
        return Thumbnail;
    }

    public void setRecipeName(String recipeName) {
        this.RecipeName = recipeName;
    }

    public void setRecipeIngredients(String recipeIngredients) {
        this.RecipeIngredients = recipeIngredients;
    }

    public void setRecipeSubtitle(String recipeSubtitle) {
        this.RecipeSubtitle = recipeSubtitle;
    }

    public void setRecipe(String recipe) {
        this.Recipe = recipe;
    }

    public void setThumbnail(int thumbnail) {
        this.Thumbnail = thumbnail;
    }
}
