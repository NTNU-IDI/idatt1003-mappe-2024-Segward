package edu.ntnu.idi.idatt.registers;

import edu.ntnu.idi.idatt.types.Recipe;
import java.util.ArrayList;

public class RecipeRegister {
  public ArrayList<Recipe> recipies = new ArrayList<>();

  public RecipeRegister() {}

  public void listRecipes() {
    for (int i = 0; i < recipies.size(); i++) {
      System.out.println(recipies.get(i).getFormattedString());
    }
  }

  public void addRecipe(Recipe recipe) {
    recipies.add(recipe);
  }

  public void removeRecipe(Recipe recipe) {
    recipies.remove(recipe);
  }

  public Recipe getRecipe(String name) {
    for (int i = 0; i < recipies.size(); i++) {
      Recipe recipe = recipies.get(i);
      if (recipe.name.equals(name)) {
        return recipe;
      }
    }
    return null;
  }


}


