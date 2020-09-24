package com.api.recipeManager.api;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.apache.tomcat.util.file.ConfigurationSource.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.recipeManager.model.Recipe;
import com.api.recipeManager.model.RecipeSheetModel;
import com.api.recipeManager.service.RecipeService;

import ch.qos.logback.core.util.ContentTypeUtil;

@RequestMapping("api/recipe")
@RestController
public class RecipeController {
	
	private final RecipeService recipeService;
	
	@Autowired
	public RecipeController(RecipeService recipeService) {
		// TODO Auto-generated constructor stub
		this.recipeService = recipeService;
	}
	
	@GetMapping
	public List<Recipe> getAllRecipe(){
		return this.recipeService.getAllRecipe();
	}
	
	@PostMapping
	public int insertRecipe(@RequestBody Recipe recipe) {
		return recipeService.insertRecipe(recipe);
	}
	
	@GetMapping(path = "/{objectId}")
	public List<Recipe> getRecipe(@PathVariable("objectId") String objectId){
		return this.recipeService.getRecipe(objectId);
	}
	
	@DeleteMapping(path = "/{objectId}")
	public int deleteRecipe(@PathVariable("objectId") String objectId) {
		return recipeService.deleteRecipe(objectId);
	}
	
	@PostMapping(path="/pdf")
	public ResponseEntity<byte[]> getRecipeSheetPdf(@RequestBody RecipeSheetModel recipeBody) {
		String result = recipeService.process(recipeBody.getSelectedShadeNo(), recipeBody.getCount(), recipeBody.getMass(), recipeBody.getCustomer(), recipeBody.getLiqourValue(), recipeBody.getMachineNo(), recipeBody.getDyeingDate(),recipeBody.getColorDetailsPDF(),recipeBody.getChemicalDetailsPDF());
		if(!result.equals("Creation Success"))return null;
		try {
			byte[] contents = Files.readAllBytes(Paths.get("D:\\Temp.pdf"));

		    HttpHeaders headers = new HttpHeaders();
		    headers.setContentType(MediaType.APPLICATION_PDF);
		    // Here you have to set the actual filename of your pdf
		    String filename = "Temp.pdf";
		    headers.setContentDispositionFormData(filename, filename);
		    headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
		    ResponseEntity<byte[]> response = new ResponseEntity<>(contents, headers, HttpStatus.OK);
		    return response;
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
		
	} 
}
