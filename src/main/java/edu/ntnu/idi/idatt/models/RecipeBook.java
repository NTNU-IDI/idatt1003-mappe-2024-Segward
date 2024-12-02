package edu.ntnu.idi.idatt.models;

import java.lang.reflect.Array;
import java.util.ArrayList;

import edu.ntnu.idi.idatt.registers.RecipeRegister;
import edu.ntnu.idi.idatt.types.Recipe;


public class RecipeBook {
  private RecipeRegister recipeRegister = new RecipeRegister();

  public RecipeBook() {}

  public void addRecipe(Recipe recipe) {
    Recipe existingRecipe = recipeRegister.getRecipe(recipe.name);
    if (existingRecipe != null) {
      return;
    }
    recipeRegister.addRecipe(recipe);
  }

  public void listRecipes() {
    recipeRegister.listRecipes();
  }

  public Recipe getRecipe(String name) {
    return recipeRegister.getRecipe(name);
  }

  public ArrayList<Recipe> getRecipes() {
    return recipeRegister.recipies;
  }
}
