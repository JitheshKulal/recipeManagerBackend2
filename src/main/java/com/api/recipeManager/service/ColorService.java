package com.api.recipeManager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.api.recipeManager.dao.ColorDao;
import com.api.recipeManager.model.Color;

@Service
public class ColorService {
	private final ColorDao colorDao;
	
	@Autowired
	public ColorService(@Qualifier("postgrescol") ColorDao colorDao) {
		// TODO Auto-generated constructor stub
		this.colorDao = colorDao;
	}
	
	public List<Color> getAllColor() {
		return this.colorDao.getAllColor();
	}
	
	public int insertColor(Color color) {
		return this.colorDao.insertColor(color);
	}
	
	public List<Color> getColor(String objectId) {
		return this.colorDao.getColor(objectId);
	} 
	
	public int deleteColor(String objectId) {
		return this.colorDao.deleteColor(objectId);
	}
}
