package edu.ntnu.idi.idatt.registers;

import edu.ntnu.idi.idatt.types.Recipe;
import java.util.ArrayList;

public class RecipeRegister {
  public ArrayList<Recipe> recipes = new ArrayList<>();

  public void add(Recipe recipe) {
    Recipe existingRecipe = find(recipe.name);
    if (existingRecipe != null) {
      throw new IllegalArgumentException("Recipe already exists");
    } else {
      recipes.add(recipe);
    }
  }

  public void remove(Recipe recipe) {
    Recipe existingRecipe = find(recipe.name);
    if (existingRecipe == null) {
      throw new IllegalArgumentException("Recipe doesnt exist");
    } else {
      recipes.remove(recipe);
    }
  }

  public Recipe find(String name) {
    return recipes.stream().filter(r -> r.name.equals(name)).findFirst().orElse(null);
  }
}
