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
  public void addGroceryAmount(String name, int amount) {
    ArrayList<Grocery> groceries = groceryRegister.getGrocery(name);
    if (groceries.size() == 0) {
      throw new IllegalArgumentException("No groceries with the name " + name + " found.");
    }

    for (int i = 0; i < groceries.size(); i++) {
      System.out.println(i + ": " + groceries.get(i).getFormattedString());
    }

    System.out.println("Enter the index of the grocery you want to add to: ");
    int index = Integer.parseInt(System.console().readLine());
    if (index < 0 || index >= groceries.size()) {
      throw new IllegalArgumentException("Invalid index.");
    }

    groceryRegister.addAmount(name, index, amount);
  }

  /** Enumerates all groceries in the register. */
  public void enumerateGroceries() {
    ArrayList<Grocery> groceries = groceryRegister.getGroceries();
    for (int i = 0; i < groceries.size(); i++) {
      System.out.println(groceries.get(i).getFormattedString());
    }
  }
}
