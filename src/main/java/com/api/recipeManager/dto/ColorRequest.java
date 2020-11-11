package com.api.recipeManager.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ColorRequest {
	public String colorName;
	public String description;
}
