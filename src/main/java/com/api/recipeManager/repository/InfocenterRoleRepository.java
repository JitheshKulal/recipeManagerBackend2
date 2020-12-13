package com.api.recipeManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.recipeManager.model.InfocenterRolesMapping;

public interface InfocenterRoleRepository extends JpaRepository<InfocenterRolesMapping, Long>{
	void deleteById(Long id);
}
