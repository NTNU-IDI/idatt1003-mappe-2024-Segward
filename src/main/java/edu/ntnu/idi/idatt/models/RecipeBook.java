package edu.ntnu.idi.idatt.models;

import edu.ntnu.idi.idatt.registers.RecipeRegister;
import edu.ntnu.idi.idatt.types.Recipe;

/**
 * @version 1.1
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
}
