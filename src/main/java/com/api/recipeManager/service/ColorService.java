package com.api.recipeManager.service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.api.recipeManager.dto.ColorRequest;
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
	
	public Color insertColor(ColorRequest colorRequest) {
		Color color  = new Color();
		color.setColorname(colorRequest.getColorName());
		color.setDescription(colorRequest.getDescription());
		color.setSubmittime(Instant.now());
		return this.ColorRep.save(color);
	}
	
	public Optional<Color> getColor(Long objectId) {
		return this.ColorRep.findById(objectId);
	} 
	
	public void deleteColor(Long objectId) {
		this.ColorRep.deleteById(objectId);
	}
}
