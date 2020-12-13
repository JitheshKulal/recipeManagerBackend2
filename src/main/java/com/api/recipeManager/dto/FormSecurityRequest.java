package com.api.recipeManager.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FormSecurityRequest {
	public String form_name;
	public String access_type;
	public Long role_id;
	public String role_name;
}
