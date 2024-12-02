package edu.ntnu.idi.idatt.models;

import edu.ntnu.idi.idatt.registers.GroceryRegister;
import edu.ntnu.idi.idatt.types.Grocery;
import edu.ntnu.idi.idatt.types.Recipe;
import java.util.ArrayList;

/**
 * @version 1.7
 * @since 1.0
 */
public class FoodStorage {
  GroceryRegister groceryRegister = new GroceryRegister();

  /** Constructor for the FoodStorage class. */
  public FoodStorage() {}

  /**
   * Returns a grocery in the register.
   *
   * @return a grocery in the register
   */
  public Grocery getGrocery(String name) {
    return groceryRegister.getGrocery(name);
  }

  /** Lists all groceries in the register. */
  public void listGroceries() {
    groceryRegister.listGroceries();
  }

  /**
   * Lists all expired groceries in the register.
   *
   * @return all expired groceries in the register
   */
  public void listExpiredGroceries() {
    ArrayList<Grocery> expiredGroceries = groceryRegister.getExpiredGrocieries();
    double totalCost = 0;
    for (Grocery grocery : expiredGroceries) {
      System.out.println(grocery.getFormattedString());
      totalCost += grocery.getPrice();
    }
    System.out.println("Total cost of expired groceries: " + totalCost);
  }

  /**
   * Adds a grocery to the register. If the grocery already exists, the amount is increased.
   *
   * @param grocery the grocery to add
   */
  public void addGrocery(Grocery grocery) {
    Grocery existingGrocery = groceryRegister.getGrocery(grocery.name);
    if (existingGrocery != null) {
      existingGrocery.addAmount(grocery.amount);
    } else {
      groceryRegister.addGrocery(grocery);
    }
  }

  /**
   * Adds an amount to a grocery in the register.
   *
   * @param name the name of the grocery to add amount to
   * @param amount the amount to add
   */
  public void addAmountToGrocery(String name, int amount) {
    Grocery grocery = groceryRegister.getGrocery(name);
    if (grocery != null) {
      grocery.addAmount(amount);
    } else {
      System.out.println("Grocery not found");
    }
    if (grocery.amount <= 0) {
      groceryRegister.removeGrocery(grocery);
    }
  }

  /**
   * Removes am amount from a grocery in the register.
   *
   * @param name the name of the grocery to remove an amount from
   * @param amount the amount to remove
   */
  public void removeAmountFromGrocery(String name, int amount) {
    Grocery grocery = groceryRegister.getGrocery(name);
    if (grocery != null) {
      grocery.removeAmount(amount);
    } else {
      System.out.println("Grocery not found");
    }
    if (grocery.amount <= 0) {
      groceryRegister.removeGrocery(grocery);
    }
  }

  /** Prints a sorted list of groceries in the register. */
  public void listSortedGroceries() {
    ArrayList<Grocery> sortedGroceries = groceryRegister.getSortedGroceryList();
    for (Grocery grocery : sortedGroceries) {
      System.out.println(grocery.getFormattedString());
    }
  }

  /**
   * Checks if the food storage has all the groceries needed for a recipe.
   *
   * @param recipe the recipe to check
   * @return true if the food storage has all the groceries needed for the recipe, false otherwise
   */
  public boolean hasGroceriesForRecipe(Recipe recipe) {
    for (Grocery ingredient : recipe.ingredients) {
      Grocery grocery = groceryRegister.getGrocery(ingredient.name);
      if (grocery == null || grocery.amount < ingredient.amount) {
        return false;
      }
    }
    return true;
  }
}
