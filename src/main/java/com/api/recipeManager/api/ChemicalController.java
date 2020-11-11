package com.api.recipeManager.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.recipeManager.dto.ChemicalRequest;
import com.api.recipeManager.model.Chemical;
import com.api.recipeManager.service.ChemicalService;

@RequestMapping("api/chemical")
@RestController
public class ChemicalController {

	private final ChemicalService chemicalService;
	
	@Autowired
	public ChemicalController(ChemicalService chemicalService) {
		// TODO Auto-generated constructor stub
		this.chemicalService = chemicalService;
	}
	
	@GetMapping
	public List<Chemical> getAllChemical(){
		return this.chemicalService.getAllChemical();
	}
	
	@PostMapping
	public Chemical insertChemical(@RequestBody ChemicalRequest chemicalRequest) {
		return this.chemicalService.insertChemical(chemicalRequest);
	}
	
	@GetMapping(path = "/{objectId}")
	public Optional<Chemical> getChemical(@PathVariable("objectId") Long objectId){
		return this.chemicalService.getChemical(objectId);
	}
	
	@DeleteMapping(path = "/{objectId}")
	public void deleteChemical(@PathVariable("objectId") Long objectId) {
		chemicalService.deleteChemical(objectId);
		return;
	}
}
