package com.api.recipeManager.dto;


import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserRegisterRequest {
	public String username;
	public String password;
	public String email;
}
