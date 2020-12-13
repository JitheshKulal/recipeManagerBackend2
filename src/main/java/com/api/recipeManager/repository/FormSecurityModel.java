package com.api.recipeManager.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.recipeManager.model.FormSecurity;

public interface FormSecurityModel extends JpaRepository<FormSecurity, Long>{
	Optional<FormSecurity> findByFormname(String form_name);
	void deleteByAccesstypeAndFormname(String accessType,String form_name);
}
