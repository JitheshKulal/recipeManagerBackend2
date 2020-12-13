package com.api.recipeManager.api;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.recipeManager.dto.RoleRequest;
import com.api.recipeManager.model.Roles;
import com.api.recipeManager.service.RolesService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/roles")
@AllArgsConstructor
public class RolesController {

	private RolesService rolesService;
	
	@PostMapping
	public Roles createRole(@RequestBody RoleRequest roleRequest) {
		return rolesService.createRole(roleRequest);
	}
	
	@GetMapping(path = "/{objectId}")
	public Optional<Roles> getRolesById(@PathVariable("objectId") Long objectId){
		return rolesService.getRolesById(objectId);
	}
	
	@GetMapping(path = "/name/{objectName}")
	public Optional<Roles> getRolesById(@PathVariable("objectName") String objectName){
		return rolesService.getRolesByName(objectName);
	}
	
	@GetMapping
	public List<Roles> getAllRoles(){
		return rolesService.getAllRoles();
	}
	
}
