package edu.ntnu.idi.idatt;

import edu.ntnu.idi.idatt.models.FoodStorage;
import edu.ntnu.idi.idatt.registers.GroceryRegister;
import edu.ntnu.idi.idatt.registers.RecipeRegister;

/**
 * @author Gustav Skyberg
 * @version 1.0
 * @since 1.0
 */
public class Main {
  public static void main(String[] args) {
    RecipeRegister recipeRegister = new RecipeRegister();
    GroceryRegister groceryRegister = new GroceryRegister();
    FoodStorage groceryStorage = new FoodStorage(groceryRegister);
  }
}
