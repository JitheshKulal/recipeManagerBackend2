package com.api.recipeManager.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.api.recipeManager.model.FormSecurity;

public interface FormSecurityModel extends JpaRepository<FormSecurity, Long>{
	Optional<FormSecurity> findByFormname(String form_name);
	void deleteByAccesstypeAndFormname(String accessType,String form_name);
	
	@Query( value = "Select * from RM_FORM_SEC_ROLEMAP where form_name = ?1 "
			+ "and updatedon = (select max(updatedon) from RM_FORM_SEC_ROLEMAP where form_name = ?1)"
			+ "and role_id in (select role_id from RM_USER_ROLE_MAPPING where username = ?2)",nativeQuery = true)
	Optional<FormSecurity> findByUsername(String formname, String username);
}
