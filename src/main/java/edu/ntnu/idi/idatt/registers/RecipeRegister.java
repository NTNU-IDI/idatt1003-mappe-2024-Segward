package edu.ntnu.idi.idatt.registers;

import edu.ntnu.idi.idatt.types.Recipe;
import java.util.ArrayList;
import java.util.Optional;

public class RecipeRegister {
  public ArrayList<Recipe> recipies = new ArrayList<>();

  public void add(Recipe recipe) {
    Recipe existingRecipe = find(recipe.name);
    if (existingRecipe != null) {
      throw new IllegalArgumentException("Recipe already exists");
    } else {
      recipies.add(recipe);
    }
  }

  public void remove(Recipe recipe) {
    Recipe existingRecipe = find(recipe.name);
    if (existingRecipe == null) {
      throw new IllegalArgumentException("Recipe doesnt exist");
    } else {
      recipies.remove(recipe);
    }
  }

  public Recipe find(String name) {
    Optional<Recipe> recipie = recipies.stream().filter(r -> r.name.equals(name)).findFirst();
    return recipie.orElse(null);
  }
}
