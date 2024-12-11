package edu.ntnu.idi.idatt.registers;

import edu.ntnu.idi.idatt.types.Recipe;
import java.util.ArrayList;

/** A class representing a register of recipes. */
public class RecipeRegister {
  public ArrayList<Recipe> recipes = new ArrayList<>();

  /**
   * Add a recipe to the register.
   *
   * @param recipe the recipe to add
   */
  public void add(Recipe recipe) {
    Recipe existingRecipe = find(recipe.name);
    if (existingRecipe != null) {
      throw new IllegalArgumentException("Recipe already exists");
    } else {
      recipes.add(recipe);
    }
  }

  /**
   * Find a recipe by name.
   *
   * @param name the name of the recipe
   * @return the recipe, or null if it does not exist
   */
  public Recipe find(String name) {
    return recipes.stream().filter(r -> r.name.equals(name)).findFirst().orElse(null);
  }
}
