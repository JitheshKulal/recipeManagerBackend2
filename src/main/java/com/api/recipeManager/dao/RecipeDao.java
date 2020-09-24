package com.api.recipeManager.dao;

import java.util.List;

import com.api.recipeManager.model.Recipe;

public interface RecipeDao {
	
	int insertRecipe(Recipe recipe);
	
	int deleteRecipe(String objectId);
	
	List<Recipe> getRecipe(String objectId);
	
	List<Recipe> getAllRecipe();
	
	List<String> getColorForRecipe(String objectId);
	
	List<String> getChemicalForRecipe(String objectId);
}
