package com.api.recipeManager.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.recipeManager.dto.AuthenticationResponse;
import com.api.recipeManager.dto.LoginRequest;
import com.api.recipeManager.dto.UserRegisterRequest;
import com.api.recipeManager.service.AuthService;

@RestController
@RequestMapping("api/auth/")
public class AuthController {
	
	private final AuthService authService;
	
	@Autowired
	public AuthController(AuthService authService) {
		// TODO Auto-generated constructor stub
		this.authService = authService;
	}
	@PostMapping("/signup")
	public ResponseEntity<String> signup(@RequestBody UserRegisterRequest registerRequest) {
		this.authService.signup(registerRequest);
		return new ResponseEntity<>("User Registration Successful",
                HttpStatus.OK);
	}
	
	@PostMapping("/login")
	public AuthenticationResponse Login(@RequestBody LoginRequest loginRequest) {
		return authService.login(loginRequest);
	}
	
}
