package edu.ntnu.idi.idatt.types;

import java.util.ArrayList;
import java.util.stream.Collectors;

/** A class representing a recipe. */
public class Recipe {
  public ArrayList<Ingredient> ingredients;
  public String name;
  public String description;
  public String instructions;
  private int peopleToServe;

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
      int peopleToServe,
      ArrayList<Ingredient> ingredients) {
    this.ingredients = ingredients;
    this.name = name;
    this.description = description;
    this.peopleToServe = peopleToServe;
    this.instructions = instructions;
  }

  /**
   * Get a formatted string representation of the recipe.
   *
   * @return the formatted string
   */
  public String getFormattedString() {
    String ingredientsString =
        ingredients.stream().map(Ingredient::getFormattedString).collect(Collectors.joining(", "));
    return String.format(
        "Recipe: %s | %s | Feeds: %s\n\tIngredients: %s\n\tInstructions: %s",
        name, description, peopleToServe, ingredientsString, instructions);
  }
}
