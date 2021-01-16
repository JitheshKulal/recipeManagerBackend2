package com.api.recipeManager.service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

import com.api.recipeManager.dto.InfocenterRoleRequest;
import com.api.recipeManager.model.InfocenterRolesMapping;
import com.api.recipeManager.repository.InfocenterRoleRepository;

@Service
@AllArgsConstructor
public class InfocenterRoleService {
	private final InfocenterRoleRepository infocenterRoleRepository;

	public List<InfocenterRolesMapping> getAllInfocenterRoleMap() {
		return this.infocenterRoleRepository.findAll();
	}
	
	@Transactional
	public InfocenterRolesMapping insertInfocenterRoleMap(InfocenterRoleRequest infocenterRoleRequest) {
		InfocenterRolesMapping infocenterRolesMap = new InfocenterRolesMapping();
		infocenterRolesMap.setLink_title(infocenterRoleRequest.getLink_title());
		infocenterRolesMap.setLink_to(infocenterRoleRequest.getLink_to());
		infocenterRolesMap.setRole_id(infocenterRoleRequest.getRole_id());
		infocenterRolesMap.setRole_name(infocenterRoleRequest.getRole_name());
		infocenterRolesMap.setCreatedon(Instant.now());
		return this.infocenterRoleRepository.save(infocenterRolesMap);
	}
	
	public Optional<InfocenterRolesMapping> getInfocenterRoleMapping(Long objectId) {
		return this.infocenterRoleRepository.findById(objectId);
	} 
	
	public void deleteInfocenterRoleMapping(Long objectId) {
		this.infocenterRoleRepository.deleteById(objectId);
		return;
	}
	
	
}
