package edu.ntnu.idi.idatt.types;

import java.util.ArrayList;

public class Recipe {
  public ArrayList<Grocery> ingredients;
  public String name;
  public String description;
  public String instructions;

  public Recipe(
      String name, String description, ArrayList<Grocery> ingredients, String instructions) {
    this.ingredients = ingredients;
    this.name = name;
    this.description = description;
    this.instructions = instructions;
  }

  public String getFormattedString() {
    StringBuilder sb = new StringBuilder();
    for (Grocery ingredient : ingredients) {
      sb.append(ingredient.getFormattedString());
    }
    return name + ": " + description + "\n" + sb.toString() + "\n" + instructions;
  }

  public ArrayList<Grocery> getIngredients() {
    return ingredients;
  }
}
