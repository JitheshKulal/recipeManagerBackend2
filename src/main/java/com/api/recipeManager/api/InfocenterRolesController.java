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

import com.api.recipeManager.dto.InfocenterRoleRequest;
import com.api.recipeManager.model.InfocenterRolesMapping;
import com.api.recipeManager.service.InfocenterRoleService;

@RequestMapping("api/infocenterrolemap")
@RestController
public class InfocenterRolesController {
	
	private final InfocenterRoleService infocenterRoleService;
	
	@Autowired
	public InfocenterRolesController(InfocenterRoleService infocenterRoleService) {
		this.infocenterRoleService = infocenterRoleService;
	}
	
	@GetMapping
	public List<InfocenterRolesMapping> getAllInfocenterRoleMap(){
		return this.infocenterRoleService.getAllInfocenterRoleMap();
	}
	
	@PostMapping
	public InfocenterRolesMapping insertInfocenterRoleMap(@RequestBody InfocenterRoleRequest infocenterRoleRequest) {
		return this.infocenterRoleService.insertInfocenterRoleMap(infocenterRoleRequest);
	}
	
	@GetMapping(path = "/{objectId}")
	public Optional<InfocenterRolesMapping> getInfocenterRoleMapping(@PathVariable("objectId") Long objectId){
		return this.infocenterRoleService.getInfocenterRoleMapping(objectId);
	}
	
	@DeleteMapping(path = "/{objectId}")
	public void deleteInfocenterRoleMapping(@PathVariable("objectId") Long objectId) {
		infocenterRoleService.deleteInfocenterRoleMapping(objectId);
		return;
	}
	
}
