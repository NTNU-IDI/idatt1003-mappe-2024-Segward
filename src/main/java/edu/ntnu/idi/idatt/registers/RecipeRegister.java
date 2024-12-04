package edu.ntnu.idi.idatt.registers;

import edu.ntnu.idi.idatt.types.Recipe;
import java.util.ArrayList;

public class RecipeRegister {
  public ArrayList<Recipe> recipies = new ArrayList<>();

  public RecipeRegister() {}

  public void add(Recipe recipe) {
    recipies.add(recipe);
  }

  public void remove(Recipe recipe) {
    recipies.remove(recipe);
  }

  public void list() {
    for (int i = 0; i < recipies.size(); i++) {
      System.out.println(recipies.get(i).getFormattedString());
    }
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
