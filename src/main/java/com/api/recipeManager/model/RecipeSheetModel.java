package com.api.recipeManager.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RecipeSheetModel {
	private final String selectedShadeNo;
	private final String count;
	private final String mass; 
	private final String customer;
	private final String liqourValue;
	private final String machineNo;
	private final String dyeingDate;
	private final String colorDetailsPDF;
	private final String chemicalDetailsPDF;
	
	public RecipeSheetModel(@JsonProperty("selectedShadeNo") String selectedShadeNo, @JsonProperty("count") String count, @JsonProperty("mass") String mass, @JsonProperty("customer") String customer, @JsonProperty("liqourValue") String liqourValue,
			@JsonProperty("machineNo") String machineNo,@JsonProperty("dyeingDate") String dyeingDate, @JsonProperty("colorDetailsPDF") String colorDetailsPDF, @JsonProperty("chemicalDetailsPDF") String chemicalDetailsPDF) {
		super();
		this.selectedShadeNo = selectedShadeNo;
		this.count = count;
		this.mass = mass;
		this.customer = customer;
		this.liqourValue = liqourValue;
		this.machineNo = machineNo;
		this.dyeingDate = dyeingDate;
		this.colorDetailsPDF = colorDetailsPDF;
		this.chemicalDetailsPDF = chemicalDetailsPDF;
	}

	public String getSelectedShadeNo() {
		return selectedShadeNo;
	}

	public String getCount() {
		return count;
	}

	public String getMass() {
		return mass;
	}

	public String getCustomer() {
		return customer;
	}

	public String getLiqourValue() {
		return liqourValue;
	}

	public String getMachineNo() {
		return machineNo;
	}

	public String getDyeingDate() {
		return dyeingDate;
	}

	public String getColorDetailsPDF() {
		return colorDetailsPDF;
	}

	public String getChemicalDetailsPDF() {
		return chemicalDetailsPDF;
	}
	
	
	
}
