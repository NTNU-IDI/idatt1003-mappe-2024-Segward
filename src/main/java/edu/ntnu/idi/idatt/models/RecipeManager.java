package edu.ntnu.idi.idatt.models;

import edu.ntnu.idi.idatt.registers.CookbookRegister;
import edu.ntnu.idi.idatt.registers.RecipeRegister;
import edu.ntnu.idi.idatt.types.Cookbook;
import edu.ntnu.idi.idatt.types.Recipe;

public class RecipeManager {
  RecipeRegister recipeRegister = new RecipeRegister();
  CookbookRegister cookbookRegister = new CookbookRegister();

  public RecipeManager() {}

  public void registerRecipe(Recipe recipe) {
    recipeRegister.registerRecipe(recipe);
  }

  public void registerCookbook(Cookbook cookbook) {
    cookbookRegister.registerCookbook(cookbook);
  }

  public void addRecipeToCookbook(String cookbookName, String recipeName) {
    Cookbook cookbook = cookbookRegister.searchForCookbook(cookbookName);
    Recipe recipe = recipeRegister.searchForRecipe(recipeName);
    if (cookbook != null && recipe != null) {
      cookbook.addRecipe(recipe);
    } else {
      System.out.println("Cookbook or recipe not found");
    }
  }

  public void listRecipies() {
    for (Recipe recipe : recipeRegister.recipies) {
      System.out.println(recipe.getFormattedString());
    }
  }

  public void listCookbooks() {
    for (Cookbook cookbook : cookbookRegister.cookbooks) {
      System.out.println(cookbook.getFormattedString());
    }
  }
}
