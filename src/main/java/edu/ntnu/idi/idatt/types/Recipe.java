package edu.ntnu.idi.idatt.types;

import java.util.ArrayList;

/** A class representing a recipe. */
public class Recipe {
  public ArrayList<Ingredient> ingredients;
  public String name;
  public String description;
  public String instructions;
  public ArrayList<String> authors;

  /**
   * Create a new recipe.
   *
   * @param name the name of the recipe
   * @param description the description of the recipe
   * @param instructions the instructions for making the recipe
   * @param ingredients the ingredients needed for the recipe
   */
  public Recipe(
      String name,
      String description,
      String instructions,
      ArrayList<Ingredient> ingredients,
      ArrayList<String> authors) {
    this.ingredients = ingredients;
    this.name = name;
    this.description = description;
    this.instructions = instructions;
    this.authors = authors;
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
    StringBuilder authorsString = new StringBuilder();
    for (int i = 0; i < authors.size(); i++) {
      authorsString.append(authors.get(i));
      if (i < authors.size() - 1) {
        authorsString.append(", ");
      }
    }
    return String.format(
        "\nRecipe: %s\nDescription: %s\nIngredients:\n%sInstructions: %s\nAuthors: %s",
        name, description, sb.toString(), instructions, authorsString.toString());
  }
}
