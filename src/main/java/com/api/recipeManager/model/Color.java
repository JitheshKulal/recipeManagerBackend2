package com.api.recipeManager.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Color {
	private final String id;
	private final String colorName;
	private final String description;
	
	public Color(@JsonProperty("id") String id,@JsonProperty("colorName") String colorName,@JsonProperty("description") String desc) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.colorName = colorName;
		this.description = desc;
	}
	
	public String getId() {
		return id;
	}
	public String getColorName() {
		return colorName;
	}
	public String getDescription() {
		return description;
	}

}
