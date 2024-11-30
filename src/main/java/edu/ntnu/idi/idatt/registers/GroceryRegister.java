package edu.ntnu.idi.idatt.registers;

import edu.ntnu.idi.idatt.types.Grocery;
import java.util.ArrayList;

/**
 * @version 1.2
 * @since 1.0
 */
public class GroceryRegister {
  ArrayList<Grocery> groceries = new ArrayList<>();

  public GroceryRegister() {}

  /**
   * Returns a list of all groceries.
   *
   * @return a list of all groceries
   */
  public ArrayList<Grocery> getGroceries() {
    return groceries;
  }

  /**
   * Adds a grocery to the register.
   *
   * @param grocery
   */
  public void addGrocery(Grocery grocery) {
    groceries.add(grocery);
  }

  /**
   * Removes a grocery from the register.
   *
   * @param grocery
   */
  public void removeGrocery(Grocery grocery) {
    groceries.remove(grocery);
  }

  /**
   * Returns a list of all groceries with the given name.
   *
   * @param name
   * @return a list of all groceries with the given name
   */
  public ArrayList<Grocery> getGrocery(String name) {
    ArrayList<Grocery> groceryList = new ArrayList<>();
    for (int i = 0; i < groceries.size(); i++) {
      if (groceries.get(i).getName().equals(name)) {
        groceryList.add(groceries.get(i));
      }
    }
    return groceryList;
  }

  /**
   * Adds an amount to a grocery with the given name and index.
   *
   * @param name
   * @param index
   * @param amount
   */
  public void addAmount(String name, int index, int amount) {
    ArrayList<Grocery> groceryList = getGrocery(name);
    groceryList.get(index).addAmount(amount);
  }

  /**
   * Returns a list of all expired groceries.
   *
   * @return a list of all expired groceries
   */
  public ArrayList<Grocery> getExpired() {
    ArrayList<Grocery> expired = new ArrayList<>();
    for (int i = 0; i < groceries.size(); i++) {
      if (groceries.get(i).isExpired()) {
        expired.add(groceries.get(i));
      }
    }
    return expired;
  }
}
