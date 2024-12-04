package edu.ntnu.idi.idatt.types;

import java.util.ArrayList;

public class Cookbook {
  public ArrayList<Recipe> recipes = new ArrayList<>();
  public String name;

  public Cookbook(String name) {
    this.name = name;
  }

  public void addRecipe(Recipe recipe) {
    Recipe existingRecipe = searchForRecipe(recipe.name);
    if (existingRecipe != null) {
      throw new IllegalArgumentException("Recipe already exists");
    }
    recipes.add(recipe);
  }

  public Recipe searchForRecipe(String name) {
    for (int i = 0; i < recipes.size(); i++) {
      if (recipes.get(i).name.equals(name)) {
        return recipes.get(i);
      }
    }
    return null;
  }

  public String getFormattedString() {
    StringBuilder sb = new StringBuilder();
    for (Recipe recipe : recipes) {
      sb.append(recipe.getFormattedString());
    }
    return "Cookbook: " + name + "\n" + sb.toString();
  }
}
