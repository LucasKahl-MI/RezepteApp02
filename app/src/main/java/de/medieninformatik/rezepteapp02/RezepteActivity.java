package de.medieninformatik.rezepteapp02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class RezepteActivity extends AppCompatActivity {


    private TextView mRecipeName;
    private TextView mRecipeIngredients;
    private TextView mRecipeSubtitle;
    private TextView mRecipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rezepte_einzelrezept);

        mRecipeName = findViewById(R.id.tv_rezeptname);
        mRecipeIngredients = findViewById(R.id.tv_ingredients);
        mRecipeSubtitle = findViewById(R.id.method);
        mRecipe = findViewById(R.id.tv_rezept);

        Intent intent = getIntent();
        String titel = intent.getExtras().getString("RecipeName");
        String ingedients = intent.getExtras().getString("RecipeIngredients");
        String method = intent.getExtras().getString("RecipeSubtitle");
        String recipe = intent.getExtras().getString("Recipe");

        mRecipeName.setText(titel);
        mRecipeIngredients.setText(ingedients);
        mRecipeSubtitle.setText(method);
        mRecipe.setText(recipe);
    }
}