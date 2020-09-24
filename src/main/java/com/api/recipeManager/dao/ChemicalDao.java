package com.api.recipeManager.dao;

import java.util.List;

import com.api.recipeManager.model.Chemical;


public interface ChemicalDao {
	
	int insertChemical(Chemical chemical);
	
	int deleteChemical(String objectId);
	
	List<Chemical> getChemical(String objectId);
	
	List<Chemical> getAllChemical();
}
