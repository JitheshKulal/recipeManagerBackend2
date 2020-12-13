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

import com.api.recipeManager.dto.UserRoleRequest;
import com.api.recipeManager.model.UserRole;
import com.api.recipeManager.service.UserRoleService;

@RequestMapping("api/userrole")
@RestController
public class UserRoleController {

	private final UserRoleService userRoleService;
	
	@Autowired
	public UserRoleController(UserRoleService userRoleService) {
		this.userRoleService = userRoleService;
	}
	
	@GetMapping
	public List<UserRole> getAllUserRole(){
		return this.userRoleService.getAllUserRole();
	}
	
	@PostMapping
	public UserRole insertUserRole(@RequestBody UserRoleRequest userRoleRequest) {
		return this.userRoleService.insertUserRole(userRoleRequest);
	};
	
	@GetMapping(path = "/{objectId}")
	public Optional<UserRole> getUserRole(@PathVariable("objectId") Long objectId){
		return this.userRoleService.getUserRole(objectId);
	}
	
	@DeleteMapping(path = "/{objectId}")
	public void deleteUserRole(@PathVariable("objectId") Long objectId) {
		userRoleService.deleteUserRole(objectId);
		return;
	}
	
}
