package com.api.recipeManager.dao;

import java.util.List;

import com.api.recipeManager.model.Color;

public interface ColorDao {
	
	int insertColor(Color color);
	
	int deleteColor(String objectId);
	
	List<Color> getColor(String objectId);
	
	List<Color> getAllColor();

}
