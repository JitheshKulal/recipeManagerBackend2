package com.api.recipeManager.model;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "RM_FORM_SEC_ROLEMAP")
public class FormSecurity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "form_name")
	private String formname;
	@Column(name = "access_type")
	private String accesstype;
	private Long role_id;
	private String role_name;
	private Instant updatedon;
}
