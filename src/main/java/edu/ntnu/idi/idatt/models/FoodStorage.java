package edu.ntnu.idi.idatt.models;

import edu.ntnu.idi.idatt.registers.GroceryRegister;

/**
 * @version 1.0
 * @since 1.0
 */
public class FoodStorage {
  GroceryRegister groceryRegister;

  /** Constructor for the FoodStorage class. */
  public FoodStorage() {
    groceryRegister = new GroceryRegister();
  }
}
