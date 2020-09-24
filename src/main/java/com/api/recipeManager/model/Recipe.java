package com.api.recipeManager.model;


import com.fasterxml.jackson.annotation.JsonProperty;

/*
 * Model for the recipe data object
 */
public class Recipe {

	private final String id;
	private final String shadeNo;
	private final String colors;
	private final String chemicals;
	
	public Recipe(@JsonProperty("id") String id,@JsonProperty("shadeNo") String shadeNo,@JsonProperty("colors") String colors,@JsonProperty("chemicals") String checmicals) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.shadeNo = shadeNo;
		this.chemicals = checmicals;
		this.colors = colors;
		System.out.println(this.toString());
	}

	public String getColors() {
		return colors;
	}

	public String getChemicals() {
		return chemicals;
	}

	
	public String getId() {
		return id;
	}

	public String getShadeNo() {
		return shadeNo;
	}

	@Override
	public String toString() {
		return "Recipe [id=" + id + ", shadeNo=" + shadeNo + ", colors=" + colors + ", chemicals=" + chemicals
				+ "]";
	}
	
}
