package com.api.recipeManager.service;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.api.recipeManager.dto.AuthenticationResponse;
import com.api.recipeManager.dto.LoginRequest;
import com.api.recipeManager.dto.RefreshTokenRequest;
import com.api.recipeManager.dto.UserRegisterRequest;
import com.api.recipeManager.exception.RecipeManagerException;
import com.api.recipeManager.model.RefreshToken;
import com.api.recipeManager.model.Users;
import com.api.recipeManager.model.VerificationToken;
import com.api.recipeManager.repository.RefreshTokenRepository;
import com.api.recipeManager.repository.UserRepository;
import com.api.recipeManager.repository.UserTokenRepository;
import com.api.recipeManager.security.JWTProvider;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@AllArgsConstructor
@Log4j2
public class AuthService {
	
	private final PasswordEncoder passwordEncoder;
	private final UserRepository userRepository;
	private final UserTokenRepository tokenReporsitory;
	private final AuthenticationManager authenticationManager;
	private final JWTProvider jwtProvider;
	private final RefreshTokenRepository refreshTokenRepository;
	
	@Transactional
	public void signup(UserRegisterRequest registerRequest) throws RecipeManagerException{
		log.info("Inside Signup Service with data -> {}", registerRequest);
		if(checkUserExists(registerRequest.username)) {
			throw new RecipeManagerException("The username requested to login already exists");
		}
		Users newUser = new Users();
		newUser.setCreatedOn(Instant.now());
		newUser.setEmail(registerRequest.email);
		newUser.setUsername(registerRequest.username);
		newUser.setPassword(passwordEncoder.encode(registerRequest.password));
		newUser.setActive(true);
		userRepository.save(newUser);
		//generateVerificationToken(newUser);
		return;
	}

	private void generateVerificationToken(Users newUser) {
		// TODO Auto-generated method stub
		String token  = UUID.randomUUID().toString();
		VerificationToken verificationToken = new VerificationToken();
		verificationToken.setToken(token);
		//verificationToken.setUser(newUser);
		tokenReporsitory.save(verificationToken);
	}

	public AuthenticationResponse login(LoginRequest loginRequest) {
		// TODO Auto-generated method stub
		log.info("Entering login service with data -> {}", loginRequest);
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.username, loginRequest.password));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String token = jwtProvider.generateToken(authentication);
		return new AuthenticationResponse(token,loginRequest.getUsername(),Instant.now().plusMillis(jwtProvider.getJWTExpireTimeinMillisecs()),generateRefreshToken().getToken());
	}
	
	public boolean checkUserExists(String username) {
		Optional<Users> userList = userRepository.findByUsername(username);
		return userList.isPresent();
	}
	
	@Transactional
	public RefreshToken generateRefreshToken() {
		// TODO Auto-generated method stub
		RefreshToken newRefreshToken = new RefreshToken();
		newRefreshToken.setCreatedon(Instant.now());
		newRefreshToken.setToken(UUID.randomUUID().toString());
		return refreshTokenRepository.save(newRefreshToken);
	}
	
	@Transactional
	public void validateToken(String token) {
		refreshTokenRepository.findBytoken(token).orElseThrow(() -> new RecipeManagerException("Refresh Token not found"));
	}
	
	@Transactional
	public void deleteToken(String token) {
		refreshTokenRepository.deleteBytoken(token);
	}
	
	public AuthenticationResponse refreshToken(RefreshTokenRequest refreshTokenRequest) {
		// TODO Auto-generated method stub
		validateToken(refreshTokenRequest.getRefreshToken());
		String token = jwtProvider.generateTokenByUserName(refreshTokenRequest.getUsername());
		return new AuthenticationResponse(token, refreshTokenRequest.getUsername(), 
				Instant.now().plusMillis(jwtProvider.getJWTExpireTimeinMillisecs()), refreshTokenRequest.getRefreshToken());
	}
}
