package com.api.recipeManager.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserRoleRequest {
	private String username;
	private String role_id;
	private String role_name;
}
