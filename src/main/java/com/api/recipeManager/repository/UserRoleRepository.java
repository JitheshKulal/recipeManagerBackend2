package com.api.recipeManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.recipeManager.model.UserRole;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
	void deleteById(Long id);
}
