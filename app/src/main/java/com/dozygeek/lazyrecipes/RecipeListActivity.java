package com.dozygeek.lazyrecipes;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.dozygeek.lazyrecipes.models.Recipe;
import com.dozygeek.lazyrecipes.requests.RecipeAPI;
import com.dozygeek.lazyrecipes.requests.ServiceGenerator;
import com.dozygeek.lazyrecipes.requests.responses.RecipeResponse;
import com.dozygeek.lazyrecipes.requests.responses.RecipeSearchResponse;
import com.dozygeek.lazyrecipes.util.Constants;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecipeListActivity extends AppCompatActivity {

    private static final String TAG = "RecipeListActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_list);

        findViewById(R.id.btnTest).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                testGetRecipe();
            }
        });
    }

    private void testRecipeSearch() {
        RecipeAPI recipeAPI = ServiceGenerator.getRecipeAPI();

        Call<RecipeSearchResponse> responseCall = recipeAPI.searchRecipe(
                Constants.API_KEY,
                "chicken",
                "1"
        );
        responseCall.enqueue(new Callback<RecipeSearchResponse>() {
            @Override
            public void onResponse(Call<RecipeSearchResponse> call, Response<RecipeSearchResponse> response) {
                Log.d(TAG, "onResponse: " + response.toString());
                if (response.code() == 200) {
                    Log.d(TAG, "onResponse: " + response.body().toString());
                    List<Recipe> recipeList = new ArrayList<>(response.body().getRecipes());
                    for (Recipe recipe : recipeList) {
                        Log.d(TAG, "onResponse: " + recipe.getTitle());
                    }
                } else {
                    try {
                        Log.d(TAG, "onResponse: " + response.errorBody().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<RecipeSearchResponse> call, Throwable t) {

            }
        });
    }

    private void testGetRecipe(){
        RecipeAPI recipeAPI = ServiceGenerator.getRecipeAPI();

        Call<RecipeResponse> responseCall = recipeAPI.getRecipe(
                "36498",
                Constants.API_KEY
        );

        responseCall.enqueue(new Callback<RecipeResponse>() {
            @Override
            public void onResponse(Call<RecipeResponse> call, Response<RecipeResponse> response) {
                Log.d(TAG, "onResponse: " + response.toString());
                if (response.code() == 200) {
                    Recipe recipe = response.body().getRecipe();
                    Log.d(TAG, "onResponse: " + recipe.getTitle());
                } else {
                    try {
                        Log.d(TAG, "onResponse: " + response.errorBody().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<RecipeResponse> call, Throwable t) {

            }
        });
    }
}