package com.api.recipeManager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.api.recipeManager.config.SwaggerConfig;

@SpringBootApplication
@Import(SwaggerConfig.class)
public class RecipeManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecipeManagerApplication.class, args);
	}

}
