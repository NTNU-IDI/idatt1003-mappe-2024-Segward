package edu.ntnu.idi.idatt.registers;

import edu.ntnu.idi.idatt.types.Recipe;
import java.util.ArrayList;

/**
 * @version 1.0
 * @since 1.0
 */
public class RecipeRegister {
  ArrayList<Recipe> recipies = new ArrayList<>();

  public RecipeRegister() {}

  /**
   * Adds a recipe to the register.
   *
   * @param grocery
   */
  public void addGrocery(Recipe recipe) {
    recipies.add(recipe);
  }

  /**
   * Removes a recipe from the register.
   *
   * @param grocery
   */
  public void removeGrocery(Recipe recipe) {
    recipies.remove(recipe);
  }
}
