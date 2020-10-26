package com.api.recipeManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.recipeManager.model.VerificationToken;

@Repository
public interface UserTokenRepository extends JpaRepository<VerificationToken, Long> {

}
