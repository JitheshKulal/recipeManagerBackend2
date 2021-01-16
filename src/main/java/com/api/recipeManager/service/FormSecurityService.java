package com.api.recipeManager.service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.api.recipeManager.dto.FormSecurityRequest;
import com.api.recipeManager.model.FormSecurity;
import com.api.recipeManager.repository.FormSecurityModel;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class FormSecurityService {
	private final FormSecurityModel formSecurityModel;
	
	@Transactional
	public List<FormSecurity> getAllFormSecurityMappings(){
		return formSecurityModel.findAll();
	}
	
	@Transactional
	public Optional<FormSecurity> getByFormName(String formName){
		return formSecurityModel.findByFormname(formName);
	}
	
	@Transactional
	public List<FormSecurity> createFormSecurityMapping(List<FormSecurityRequest> input) {
		List<FormSecurity> responseData = new ArrayList<>();
		for(FormSecurityRequest request : input) {
			FormSecurity formSecurity = new FormSecurity();
			formSecurity.setFormname(request.getForm_name());
			formSecurity.setAccesstype(request.getAccess_type());
			formSecurity.setRole_id(request.getRole_id());
			formSecurity.setRole_name(request.getRole_name());
			formSecurity.setUpdatedon(Instant.now());
			responseData.add(formSecurityModel.save(formSecurity));
		}
		return responseData;
	}
	
	@Transactional
	public void deleteFormAccessMapping(String form_name,String access_type) {
		formSecurityModel.deleteByAccesstypeAndFormname(access_type, form_name);
	}
	
	@Transactional
	public Optional<FormSecurity> getFormSecurityFlagByUsername(String formname, String username) {
		return formSecurityModel.findByUsername(formname, username);
	}
}
