package com.api.recipeManager.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RefreshTokenRequest {
	@NonNull
	public String refreshToken;
	public String username;
}
