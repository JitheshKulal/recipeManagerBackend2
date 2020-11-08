package com.api.recipeManager.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.recipeManager.model.Color;

@Repository
public interface ColorRepository extends JpaRepository<Color, Long> {
	void deleteById(Long id); 
}
