package com.api.recipeManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.recipeManager.model.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe, Long>{
	void deleteById(Long id);
}
