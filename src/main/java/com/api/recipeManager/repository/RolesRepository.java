package com.api.recipeManager.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.recipeManager.model.Roles;

@Repository
public interface RolesRepository extends JpaRepository<Roles, Long> {
	Optional<Roles> findByrolename(String role_name);
}
