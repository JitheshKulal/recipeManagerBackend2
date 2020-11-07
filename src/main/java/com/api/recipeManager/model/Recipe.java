package com.api.recipeManager.model;


import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * Model for the recipe data object
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "rm_recipe_data")
public class Recipe {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	private String shadeNo;
	private String colors;
	private String chemicals;
	private Instant submitTime;
}
