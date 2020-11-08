package com.api.recipeManager.model;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
@Table(name = "rm_color_data")
public class Color {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private final Long id;
	@NotNull
	private final String colorname;
	private final String description;
	private final Instant submittime;
	
}
