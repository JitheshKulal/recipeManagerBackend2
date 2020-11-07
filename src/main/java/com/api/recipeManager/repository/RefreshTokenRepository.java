package com.api.recipeManager.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.recipeManager.model.RefreshToken;

@Repository
public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long>{
	Optional<RefreshToken> findBytoken(String token);
	
	void deleteBytoken(String token);
	
	//void deleteByUsername(String username);
}
