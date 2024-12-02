package edu.ntnu.idi.idatt.types;

import java.util.ArrayList;

/**
 * @version 1.3
 * @since 1.0
 */
public class Recipe {
  public ArrayList<Grocery> ingredients;
  public String name;
  public String description;
  public String instructions;

  /**
   * Creates a new recipe with the specified name, description and ingredients.
   *
   * @param name the name of the recipe
   * @param description the description of the recipe
   * @param ingredients the ingredients of the recipe
   */
  public Recipe(
      String name, String description, ArrayList<Grocery> ingredients, String instructions) {
    this.ingredients = ingredients;
    this.name = name;
    this.description = description;
    this.instructions = instructions;
  }

  /**
   * Getter for a formatted string of the recipe.
   *
   * @return a formatted string of the recipe
   */
  public String getFormattedString() {
    StringBuilder sb = new StringBuilder();
    for (Grocery ingredient : ingredients) {
      sb.append(ingredient.getFormattedString());
    }
    return name + ": " + description + "\n" + sb.toString() + "\n" + instructions;
  }

  /**
   * Returns the ingredients of the recipe.
   *
   * @return the ingredients of the recipe
   */
  public ArrayList<Grocery> getIngredients() {
    return ingredients;
  }
}
