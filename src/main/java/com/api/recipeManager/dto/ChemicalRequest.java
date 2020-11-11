package com.api.recipeManager.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ChemicalRequest {
	public String chemicalName;
	public String description;
}
