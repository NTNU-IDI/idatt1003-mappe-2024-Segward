package edu.ntnu.idi.idatt.models;

import edu.ntnu.idi.idatt.registers.GroceryRegister;
import edu.ntnu.idi.idatt.types.Grocery;
import java.util.ArrayList;

/**
 * @version 1.3
 * @since 1.0
 */
public class FoodStorage {
  GroceryRegister groceryRegister;

  /** Constructor for the FoodStorage class. */
  public FoodStorage() {
    groceryRegister = new GroceryRegister();
  }

  /**
   * Returns a list of all groceries.
   *
   * @return a list of all groceries
   */
  public ArrayList<Grocery> getGroceries() {
    return groceryRegister.getGroceries();
  }

  /**
   * Adds a grocery to the register.
   *
   * @param grocery
   */
  public void addGrocery(Grocery grocery) {
    groceryRegister.addGrocery(grocery);
  }

  /**
   * Gets groceries with the given name and adds an amount to one of them.
   *
   * @param name
   * @param amount
   */
  public void addGroceryAmount(int index, int amount) {
    groceryRegister.addAmount(index, amount);
  }

  /** Enumerates all groceries in the register. */
  public void enumerateGroceries() {
    ArrayList<Grocery> groceries = groceryRegister.getGroceries();
    for (int i = 0; i < groceries.size(); i++) {
      System.out.println(i + ": " + groceries.get(i).getFormattedString());
    }
  }
}
