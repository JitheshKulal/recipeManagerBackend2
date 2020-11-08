package com.api.recipeManager.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.api.recipeManager.model.Color;
import com.api.recipeManager.repository.ColorRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ColorService {
	
	private final ColorRepository ColorRep;
	
	public List<Color> getAllColor() {
		return this.ColorRep.findAll();
	}
	
	public Color insertColor(Color color) {
		return this.ColorRep.save(color);
	}
	
	public Optional<Color> getColor(Long objectId) {
		return this.ColorRep.findById(objectId);
	} 
	
	public void deleteColor(Long objectId) {
		this.ColorRep.deleteById(objectId);
	}
}
