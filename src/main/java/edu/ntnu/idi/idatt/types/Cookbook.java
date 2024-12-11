package edu.ntnu.idi.idatt.types;

import java.util.ArrayList;
import java.util.stream.Collectors;

/** A class representing a cookbook. */
public class Cookbook {
  public ArrayList<Recipe> recipes = new ArrayList<>();
  public String name;

  /**
   * Create a new cookbook.
   *
   * @param name the name of the cookbook
   */
  public Cookbook(String name) {
    this.name = name;
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

  /**
   * Add a recipe to the cookbook.
   *
   * @param recipe the recipe to add
   */
  public void add(Recipe recipe) {
    Recipe existingRecipe = find(recipe.name);
    if (existingRecipe != null) {
      throw new IllegalArgumentException("Recipe already exists");
    }
    recipes.add(recipe);
  }

  /**
   * Get a formatted string representation of the cookbook.
   *
   * @return the formatted string
   */
  public String getFormattedString() {
    String recipesString =
        recipes.stream().map(Recipe::getFormattedString).collect(Collectors.joining("\n"));
    return String.format("Cookbook: %s\n%s", name, recipesString);
  }
}
