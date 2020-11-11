package com.api.recipeManager.service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.api.recipeManager.dto.ChemicalRequest;
import com.api.recipeManager.model.Chemical;
import com.api.recipeManager.repository.ChemicalRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ChemicalService {
	private final ChemicalRepository chemicalRepository;
	
	
	public List<Chemical> getAllChemical() {
		return this.chemicalRepository.findAll();
	}
	
	@Transactional
	public Chemical insertChemical(ChemicalRequest chemicalRequest) {
		Chemical chemical = new Chemical();
		chemical.setChemicalname(chemicalRequest.getChemicalName());
		chemical.setDescription(chemicalRequest.getDescription());
		chemical.setSubmittime(Instant.now());
		return this.chemicalRepository.save(chemical);
	}
	
	public Optional<Chemical> getChemical(Long objectId) {
		return this.chemicalRepository.findById(objectId);
	} 
	
	public void deleteChemical(Long objectId) {
		this.chemicalRepository.deleteById(objectId);
		return;
	}
}
