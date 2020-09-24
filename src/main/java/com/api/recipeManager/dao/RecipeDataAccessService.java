package com.api.recipeManager.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.api.recipeManager.model.Recipe;

@Repository("postgresrec")
public class RecipeDataAccessService implements RecipeDao {
	
	private final JdbcTemplate jdbctemplate;
	
	public RecipeDataAccessService(JdbcTemplate jdbctemplate) {
		// TODO Auto-generated constructor stub
		this.jdbctemplate = jdbctemplate;
	}
	
	@Override
	public int insertRecipe(Recipe recipe) {
		// TODO Auto-generated method stub
		System.out.println(recipe.toString());
		final String sql = "INSERT INTO RM_RECIPE_DATA ("
				+ "id,"
				+ "shadeNo,"
				+ "colors,"
				+ "chemicals,"
				+ "submittime) VALUES("
				+ "'REC-'||nextval('RM_RECIPE_SEQ'),"
				+ "?,"
				+ "?,"
				+ "?,"
				+ "CURRENT_DATE)";
		return jdbctemplate.update(sql,recipe.getShadeNo(),recipe.getColors(),recipe.getChemicals());
	}
	
	@Override
	public List<Recipe> getAllRecipe() {
		// TODO Auto-generated method stub
		final String sql = "SELECT id,shadeno,colors,chemicals from RM_RECIPE_DATA";
		return jdbctemplate.query(sql, (resultSet,i) -> {
			return new Recipe(resultSet.getString("id"),resultSet.getString("shadeno"),resultSet.getString("colors"),resultSet.getString("chemicals"));
		});
		
	}
	
	@Override
	public List<Recipe> getRecipe(String objectId) {
		// TODO Auto-generated method stub
		final String sql = "SELECT id,shadeno,colors,chemicals from RM_RECIPE_DATA where id = ?";
		return jdbctemplate.query(sql, (resultSet,i) -> {
			return new Recipe(resultSet.getString("id"),resultSet.getString("shadeno"),resultSet.getString("colors"),resultSet.getString("chemicals"));
		},objectId);
	}
	
	@Override
	public int deleteRecipe(String objectId) {
		// TODO Auto-generated method stub
		final String sql = "DELETE from RM_RECIPE_DATA where id = ?";
		return jdbctemplate.update(sql,objectId);
	}
	
	@Override
	public List<String> getChemicalForRecipe(String objectId) {
		// TODO Auto-generated method stub
		final String sql = "SELECT chemicals from RM_RECIPE_DATA where id = ?";
		return jdbctemplate.query(sql, (resultSet,i) -> {
			return resultSet.getString("chemicals");
		},objectId);
	}
	
	@Override
	public List<String> getColorForRecipe(String objectId) {
		// TODO Auto-generated method stub
		final String sql = "SELECT colors from RM_RECIPE_DATA where id = ?";
		return jdbctemplate.query(sql, (resultSet,i) -> {
			return resultSet.getString("colors");
		},objectId);
	}
}
