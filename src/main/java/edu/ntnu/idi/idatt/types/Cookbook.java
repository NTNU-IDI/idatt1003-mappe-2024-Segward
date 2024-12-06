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
    for (int i = 0; i < recipes.size(); i++) {
      if (i != 0) {
        sb.append("\n");
      }
      sb.append(recipes.get(i).getFormattedString());
    }
    return "\nCookbook: " + name + "\n" + sb.toString();
  }
}
