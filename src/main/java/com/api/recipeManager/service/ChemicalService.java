package com.api.recipeManager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.api.recipeManager.dao.ChemicalDao;
import com.api.recipeManager.model.Chemical;

@Service
public class ChemicalService {
	private final ChemicalDao chemicalDao;
	
	@Autowired
	public ChemicalService(@Qualifier("postgreschem") ChemicalDao chemicalDao) {
		// TODO Auto-generated constructor stub
		this.chemicalDao = chemicalDao;
	}
	
	public List<Chemical> getAllChemical() {
		return this.chemicalDao.getAllChemical();
	}
	
	public int insertChemical(Chemical chemical) {
		return this.chemicalDao.insertChemical(chemical);
	}
	
	public List<Chemical> getChemical(String objectId) {
		return this.chemicalDao.getChemical(objectId);
	} 
	
	public int deleteChemical(String objectId) {
		return this.chemicalDao.deleteChemical(objectId);
	}
}
