package com.api.recipeManager.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.recipeManager.model.Color;
import com.api.recipeManager.service.ColorService;

@RequestMapping("api/color")
@RestController
public class ColorController {
	private final ColorService colorService;
	
	@Autowired
	public ColorController(ColorService colorService) {
		// TODO Auto-generated constructor stub
		this.colorService = colorService;
	}
	
	@GetMapping
	public List<Color> getAllColor(){
		return this.colorService.getAllColor();
	}
	
	@PostMapping
	public int insertColor(@RequestBody Color color) {
		return this.colorService.insertColor(color);
	}
	
	@GetMapping(path = "/{objectId}")
	public List<Color> getColor(@PathVariable("objectId") String objectId){
		return this.colorService.getColor(objectId);
	}
	
	@DeleteMapping(path = "/{objectId}")
	public int deleteColor(@PathVariable("objectId") String objectId) {
		return colorService.deleteColor(objectId);
	}
}
