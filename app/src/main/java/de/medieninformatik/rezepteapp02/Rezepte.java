package de.medieninformatik.rezepteapp02;

public class Rezepte {

    private String RecipeName;
    private String RecipeIngredients;
    private String RecipeSubtitle;
    private String Recipe;
    private int Thumbnail;


    public Rezepte(String RecipeName, String RecipeIngredients, String RecipeSubtitle ,String Recipe, int Thumbnail) {
        this.RecipeName = RecipeName;
        this.RecipeIngredients = RecipeIngredients;
        this.RecipeSubtitle = RecipeSubtitle;
        this.Recipe = Recipe;
        this.Thumbnail = Thumbnail;
    }

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
