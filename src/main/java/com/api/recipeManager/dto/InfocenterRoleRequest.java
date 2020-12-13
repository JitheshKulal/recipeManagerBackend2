package com.api.recipeManager.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class InfocenterRoleRequest {
	private String link_title;
	private String link_to;
	private Long role_id;
	private String role_name;
}
