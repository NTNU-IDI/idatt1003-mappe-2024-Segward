package edu.ntnu.idi.idatt.types;

import java.util.ArrayList;

public class Recipe {
  public ArrayList<Grocery> groceries;
  public String name;
  public String description;
  public String instructions;

  public Recipe(
      String name, String description, String instructions, ArrayList<Grocery> groceries) {
    this.groceries = groceries;
    this.name = name;
    this.description = description;
    this.instructions = instructions;
  }

  public String getFormattedString() {
    StringBuilder sb = new StringBuilder();
    for (Grocery ingredient : groceries) {
      sb.append(ingredient.getFormattedString());
    }
    return name + ": " + description + "\n" + sb.toString() + "\n" + instructions;
  }

  public ArrayList<Grocery> getIngredients() {
    return groceries;
  }
}
