package edu.ntnu.idi.idatt.types;

import java.util.ArrayList;

public class Cookbook {
  public ArrayList<Recipe> recipes = new ArrayList<>();
  public String name;

  public Cookbook(String name) {
    this.name = name;
  }

  public Recipe find(String name) {
    return recipes.stream().filter(r -> r.name.equals(name)).findFirst().orElse(null);
  }

  public void add(Recipe recipe) {
    Recipe existingRecipe = find(recipe.name);
    if (existingRecipe != null) {
      throw new IllegalArgumentException("Recipe already exists");
    }
    recipes.add(recipe);
  }

  public String getFormattedString() {
    StringBuilder sb = new StringBuilder();
    for (Recipe recipe : recipes) {
      sb.append(recipe.getFormattedString());
    }
    return "Cookbook: " + name + "\n" + sb.toString();
  }
}
