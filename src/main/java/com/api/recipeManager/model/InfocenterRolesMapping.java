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


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "RM_NAVLINK_ROLE_MAPPING")
public class InfocenterRolesMapping {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String link_title;
	private String link_to;
	private Long role_id;
	private String role_name;
	private Instant createdOn;
}
