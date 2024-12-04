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

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < ingredients.size(); i++) {
      if (i == ingredients.size() - 1) {
        sb.append(ingredients.get(i).toString());
      } else {
        sb.append(ingredients.get(i).toString()).append(", ");
      }
    }
    return name + ", " + description + ", " + instructions + ", " + sb.toString();
  }
}
