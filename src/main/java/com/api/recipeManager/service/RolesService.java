package com.api.recipeManager.service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.api.recipeManager.dto.RoleRequest;
import com.api.recipeManager.model.Roles;
import com.api.recipeManager.repository.RolesRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RolesService {
	private final RolesRepository rolesRepository;
	
	@Transactional
	public Roles createRole(RoleRequest roleRequest) {
		Roles role = new Roles();
		role.setRolename(roleRequest.getRole_name());
		role.setDescription(roleRequest.getDescription());
		role.setCreatedon(Instant.now());
		return rolesRepository.save(role);
	}
	
	@Transactional
	public Optional<Roles> getRolesById(Long id){
		return rolesRepository.findById(id);
	}
	
	@Transactional
	public Optional<Roles> getRolesByName(String roleName){
		return rolesRepository.findByrolename(roleName);
	}
	
	@Transactional
	public List<Roles> getAllRoles(){
		return rolesRepository.findAll();
	}
}
