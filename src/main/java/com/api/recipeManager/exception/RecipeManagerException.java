package com.api.recipeManager.exception;

public class RecipeManagerException extends RuntimeException{
	public RecipeManagerException(String exMessage, Exception exception) {
        super(exMessage, exception);
    }

    public RecipeManagerException(String exMessage) {
        super(exMessage);
    }
}
