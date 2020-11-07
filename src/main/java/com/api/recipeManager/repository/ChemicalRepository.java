package com.api.recipeManager.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.recipeManager.model.Chemical;

@Repository
public interface ChemicalRepository extends JpaRepository<Chemical, Long>{
	void deleteById(Long id); 
}
