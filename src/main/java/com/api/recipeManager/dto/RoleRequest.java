package com.api.recipeManager.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RoleRequest {
	public String role_name;
	public String description;
}
