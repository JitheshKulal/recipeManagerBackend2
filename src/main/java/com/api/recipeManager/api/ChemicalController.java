package com.api.recipeManager.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	public int insertChemical(@RequestBody Chemical chemical) {
		return this.chemicalService.insertChemical(chemical);
	}
	
	@GetMapping(path = "/{objectId}")
	public List<Chemical> getChemical(@PathVariable("objectId") String objectId){
		return this.chemicalService.getChemical(objectId);
	}
	
	@DeleteMapping(path = "/{objectId}")
	public int deleteChemical(@PathVariable("objectId") String objectId) {
		return chemicalService.deleteChemical(objectId);
	}
}
