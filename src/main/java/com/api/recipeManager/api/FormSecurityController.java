package com.api.recipeManager.api;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.recipeManager.dto.FormSecurityRequest;
import com.api.recipeManager.model.FormSecurity;
import com.api.recipeManager.service.FormSecurityService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/formSecurity")
@AllArgsConstructor
public class FormSecurityController {
	private final FormSecurityService formSecurityService;
	
	@GetMapping(path = "/{formName}")
	public Optional<FormSecurity> getFormSecuritymapping(@PathVariable("formName") String form_name){
		return formSecurityService.getByFormName(form_name);
	}
	
	@GetMapping
	public List<FormSecurity> getAllMappings(){
		return formSecurityService.getAllFormSecurityMappings();
	}
	
	@PostMapping
	public List<FormSecurity> createNewFormSecurityMapping(@RequestBody List<FormSecurityRequest> input){
		return formSecurityService.createFormSecurityMapping(input);
	}
}
