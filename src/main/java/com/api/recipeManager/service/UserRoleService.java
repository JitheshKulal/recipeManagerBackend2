package com.api.recipeManager.service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.api.recipeManager.dto.UserRoleRequest;
import com.api.recipeManager.model.UserRole;
import com.api.recipeManager.repository.UserRoleRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserRoleService {
	private final UserRoleRepository userRoleRepository;
	
	public List<UserRole> getAllUserRole() {
		return this.userRoleRepository.findAll();
	}
	
	public UserRole insertUserRole(UserRoleRequest userRoleRequest) {
		UserRole userRole = new UserRole();
		userRole.setUsername(userRoleRequest.getUsername());
		userRole.setRole_id(userRoleRequest.getRole_id());
		userRole.setRole_name(userRoleRequest.getRole_name());
		userRole.setCreatedon(Instant.now());
		return this.userRoleRepository.save(userRole);
	}
	
	public Optional<UserRole> getUserRole(Long objectId) {
		return this.userRoleRepository.findById(objectId);
	} 
	
	public void deleteUserRole(Long objectId) {
		this.userRoleRepository.deleteById(objectId);
		return;
	} 
}
