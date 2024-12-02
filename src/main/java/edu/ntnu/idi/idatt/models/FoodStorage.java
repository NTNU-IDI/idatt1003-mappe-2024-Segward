package edu.ntnu.idi.idatt.models;

import edu.ntnu.idi.idatt.registers.GroceryRegister;
import edu.ntnu.idi.idatt.types.Grocery;

/**
 * @version 1.5
 * @since 1.0
 */
public class FoodStorage {
  GroceryRegister groceryRegister = new GroceryRegister();

  /** Constructor for the FoodStorage class. */
  public FoodStorage() {}

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
}
