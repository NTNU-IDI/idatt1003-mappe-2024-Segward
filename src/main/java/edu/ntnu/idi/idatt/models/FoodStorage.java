package edu.ntnu.idi.idatt.models;

import edu.ntnu.idi.idatt.registers.GroceryRegister;
import edu.ntnu.idi.idatt.types.Grocery;

/**
 * @version 1.4
 * @since 1.0
 */
public class FoodStorage {
  GroceryRegister groceryRegister = new GroceryRegister();

  /** Constructor for the FoodStorage class. */
  public FoodStorage() {}

  /**
   * Adds a grocery to the register. If the grocery already exists, the amount is increased.
   *
   * @param grocery
   */
  public void addGrocery(Grocery grocery) {
    Grocery existingGrocery = groceryRegister.getGrocery(grocery.name);
    if (existingGrocery != null) {
      existingGrocery.addAmount(grocery.amount);
    } else {
      groceryRegister.addGrocery(grocery);
    }
  }
}
