package edu.ntnu.idi.idatt.types;

import java.util.ArrayList;

public class Cookbook {
  public ArrayList<Recipe> recipes = new ArrayList<>();
  public String name;

  public Cookbook(String name) {
    this.name = name;
  }

  public void addRecipe(Recipe recipe) {
    recipes.add(recipe);
  }

  public void removeRecipe(Recipe recipe) {
    recipes.remove(recipe);
  }

  public ArrayList<Recipe> getRecipes() {
    return recipes;
  }

  public String getFormattedString() {
    StringBuilder sb = new StringBuilder();
    for (Recipe recipe : recipes) {
      sb.append(recipe.getFormattedString());
    }
    return "Cookbook: " + name + "\n" + sb.toString();
  }
}
