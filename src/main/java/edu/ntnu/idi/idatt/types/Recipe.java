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
      sb.append(ingredient.getFormattedString() + "\n");
    }
    return name + "\n" + description + "\n" + sb.toString() + instructions;
  }
}
