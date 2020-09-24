package com.api.recipeManager.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Chemical {
	private final String id;
	private final String chemicalName;
	private final String description;
	
	public Chemical(@JsonProperty("id") String id,@JsonProperty("chemicalName") String chemicalName,@JsonProperty("description") String desc) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.chemicalName = chemicalName;
		this.description = desc;
	}

	public String getId() {
		return id;
	}

	public String getChemicalName() {
		return chemicalName;
	}

	public String getDescription() {
		return description;
	}
	
	
}
