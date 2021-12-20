package com.dozygeek.lazyrecipes.requests;

import com.dozygeek.lazyrecipes.requests.responses.RecipeResponse;
import com.dozygeek.lazyrecipes.requests.responses.RecipeSearchResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RecipeAPI {

    @GET("recipes")
    Call<RecipeSearchResponse> searchRecipe(
            @Query("key") String api_key,
            @Query("q") String query,
            @Query("page") String page
    );

    @GET("recipes/{recipe_id}")
    Call<RecipeResponse> getRecipe(
            @Path("recipe_id") int recipe_id,
            @Query("key") String api_key
    );

}
