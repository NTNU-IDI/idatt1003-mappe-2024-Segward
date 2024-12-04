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
      sb.append("\n" + recipe.getFormattedString() + "\n");
    }
    return "Cookbook: " + name + sb.toString();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < recipes.size(); i++) {
      if (i == recipes.size() - 1) {
        sb.append(recipes.get(i).toString());
      } else {
        sb.append(recipes.get(i).toString()).append(", ");
      }
    }
    return name + ", " + sb.toString();
  }
}
