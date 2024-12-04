package edu.ntnu.idi.idatt.types;

import java.util.ArrayList;

public class Recipe {
  public ArrayList<Ingredient> ingredients;
  public String name;
  public String description;
  public String instructions;

  public Recipe(
      String name, String description, String instructions, ArrayList<Ingredient> ingredients) {
    this.ingredients = ingredients;
    this.name = name;
    this.description = description;
    this.instructions = instructions;
  }

  public String getFormattedString() {
    StringBuilder sb = new StringBuilder();
    for (Ingredient ingredient : ingredients) {
      sb.append("\t-  ").append(ingredient.getFormattedString()).append("\n");
    }
    return String.format(
        "Recipe: %s\nDescription: %s\nIngredients:\n%sInstructions: %s",
        name, description, sb.toString(), instructions);
  }
}
