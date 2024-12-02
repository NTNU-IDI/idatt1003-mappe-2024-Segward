package edu.ntnu.idi.idatt.registers;

import edu.ntnu.idi.idatt.types.Recipe;
import java.util.ArrayList;

/**
 * @version 1.2
 * @since 1.0
 */
public class RecipeRegister {
  private ArrayList<Recipe> recipies = new ArrayList<>();

  public RecipeRegister() {}

  /** Lists all recipes in the register. */
  public void listRecipes() {
    for (int i = 0; i < recipies.size(); i++) {
      System.out.println(recipies.get(i).getFormattedString());
    }
  }

  /**
   * Adds a recipe to the register.
   *
   * @param grocery
   */
  public void addRecipe(Recipe recipe) {
    recipies.add(recipe);
  }

  /**
   * Removes a recipe from the register.
   *
   * @param grocery
   */
  public void removeRecipe(Recipe recipe) {
    recipies.remove(recipe);
  }

  /**
   * Returns a recipe with the given name
   *
   * @param name
   * @return a recipe with the given name
   */
  public Recipe getRecipe(String name) {
    for (int i = 0; i < recipies.size(); i++) {
      Recipe recipe = recipies.get(i);
      if (recipe.name.equals(name)) {
        return recipe;
      }
    }
    return null;
  }
}
