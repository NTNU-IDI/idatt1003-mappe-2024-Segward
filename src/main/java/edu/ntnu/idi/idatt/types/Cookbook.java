package edu.ntnu.idi.idatt.types;

import java.util.ArrayList;

public class Cookbook {
  public ArrayList<Recipe> recipes;
  public String name;

  public Cookbook(String name, ArrayList<Recipe> recipes) {
    this.name = name;
    this.recipes = recipes;
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
    return name + "\n" + sb.toString();
  }
}
