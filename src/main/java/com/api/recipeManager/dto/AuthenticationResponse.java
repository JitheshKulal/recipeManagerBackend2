package com.api.recipeManager.dto;

import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {
	public String authenticationToken;
	public String username;
	public Instant expireAt;
	public String refreshToken;
}
