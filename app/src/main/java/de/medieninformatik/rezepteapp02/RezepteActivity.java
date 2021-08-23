package de.medieninformatik.rezepteapp02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

/**
 * @author Lucas Kahl m27606
 * Semesterabgabe Prog4 Android SoSe 2021
 */

public class RezepteActivity extends AppCompatActivity {

    /**
     * Initialisierung der notwendigen Parameter
     */
    private TextView mRecipeName;
    private TextView mRecipeIngredients;
    private TextView mRecipeSubtitle;
    private TextView mRecipe;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rezepte_einzelrezept);

        /**
         * GUI-Elemente werden über ihre ID den entsprechenden Parametern zugewiesen
         */
        mRecipeName = findViewById(R.id.tv_rezeptname);
        mRecipeIngredients = findViewById(R.id.tv_ingredients);
        mRecipeSubtitle = findViewById(R.id.method);
        mRecipe = findViewById(R.id.tv_rezept);

        /**
         * Übergabe der richtigen Daten für das jeweilige Rezept
         * Dabei dient der Attributsname als Parameter
         */
        Intent intent = getIntent();
        String titel = intent.getExtras().getString("RecipeName");
        String ingedients = intent.getExtras().getString("RecipeIngredients");
        String method = intent.getExtras().getString("RecipeSubtitle");
        String recipe = intent.getExtras().getString("Recipe");

        /**
         * Die gelesenen Daten werden in die entsprechenden TextViews geschrieben
         */
        mRecipeName.setText(titel);
        mRecipeIngredients.setText(ingedients);
        mRecipeSubtitle.setText(method);
        mRecipe.setText(recipe);
    }
}