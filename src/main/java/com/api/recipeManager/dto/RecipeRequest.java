package com.api.recipeManager.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RecipeRequest {
	public String shadeNo;
	public String colors;
	public String chemicals;
}
