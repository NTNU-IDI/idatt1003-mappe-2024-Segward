package edu.ntnu.idi.idatt.models;

import java.lang.reflect.Array;
import java.util.ArrayList;

import edu.ntnu.idi.idatt.registers.RecipeRegister;
import edu.ntnu.idi.idatt.types.Recipe;

/**
 * @version 1.2
 * @since 1.0
 */
public class RecipeBook {
  private RecipeRegister recipeRegister = new RecipeRegister();

  public RecipeBook() {}

  /**
   * Adds a recipe to the register.
   *
   * @param recipe
   */
  public void addRecipe(Recipe recipe) {
    Recipe existingRecipe = recipeRegister.getRecipe(recipe.name);
    if (existingRecipe != null) {
      return;
    }
    recipeRegister.addRecipe(recipe);
  }

  /**
   * Removes a recipe from the register.
   *
   * @param recipe
   */
  public void listRecipes() {
    recipeRegister.listRecipes();
  }

  /**
   * Returns a recipe with the given name
   *
   * @param name
   * @return a recipe with the given name
   */
  public Recipe getRecipe(String name) {
    return recipeRegister.getRecipe(name);
  }

  /**
   * Returns all recipes in the register.
   *
   * @return all recipes in the register
   */
  public ArrayList<Recipe> getRecipes() {
    return recipeRegister.recipies;
  }
}
