package edu.ntnu.idi.idatt.types;

import java.util.ArrayList;

/** A class representing a recipe. */
public class Recipe {
  public ArrayList<Ingredient> ingredients;
  public String name;
  public String description;
  public String instructions;

  /**
   * Create a new recipe.
   *
   * @param name the name of the recipe
   * @param description the description of the recipe
   * @param instructions the instructions for making the recipe
   * @param ingredients the ingredients needed for the recipe
   */
  public Recipe(
      String name, String description, String instructions, ArrayList<Ingredient> ingredients) {
    this.ingredients = ingredients;
    this.name = name;
    this.description = description;
    this.instructions = instructions;
  }

  /**
   * Get a formatted string representation of the recipe.
   *
   * @return the formatted string
   */
  public String getFormattedString() {
    StringBuilder sb = new StringBuilder();
    for (Ingredient ingredient : ingredients) {
      sb.append("\t-  ").append(ingredient.getFormattedString()).append("\n");
    }
    return String.format(
        "\nRecipe: %s\nDescription: %s\nIngredients:\n%sInstructions: %s",
        name, description, sb.toString(), instructions);
  }
}
