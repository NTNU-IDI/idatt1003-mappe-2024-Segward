package edu.ntnu.idi.idatt.registers;

import edu.ntnu.idi.idatt.types.Recipe;
import java.util.ArrayList;

public class RecipeRegister {
  public ArrayList<Recipe> recipies = new ArrayList<>();

  public void add(Recipe recipe) {
    Recipe existingRecipe = searchForRecipe(recipe.name);
    if (existingRecipe != null) {
      throw new IllegalArgumentException("Recipe already exists");
    }
    recipies.add(recipe);
  }

  public void remove(Recipe recipe) {
    Recipe existingRecipe = searchForRecipe(recipe.name);
    if (existingRecipe == null) {
      throw new IllegalArgumentException("Recipe doesnt exist");
    }
    recipies.remove(recipe);
  }

  public Recipe searchForRecipe(String name) {
    for (int i = 0; i < recipies.size(); i++) {
      if (recipies.get(i).name.equals(name)) {
        return recipies.get(i);
      }
    }
    return null;
  }
}
