package edu.ntnu.idi.idatt.registers;

import edu.ntnu.idi.idatt.types.Grocery;
import java.util.ArrayList;

/**
 * @version 1.6
 * @since 1.0
 */
public class GroceryRegister {
  public ArrayList<Grocery> groceries = new ArrayList<>();

  public GroceryRegister() {}

  /** Lists all groceries in the register. */
  public void listGroceries() {
    for (int i = 0; i < groceries.size(); i++) {
      System.out.println(groceries.get(i).getFormattedString());
    }
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
   * Returns all expired groceries in the register.
   *
   * @return all expired groceries in the register
   */
  public ArrayList<Grocery> getExpiredGrocieries() {
    ArrayList<Grocery> expiredGroceries = new ArrayList<>();
    for (int i = 0; i < groceries.size(); i++) {
      if (groceries.get(i).isExpired()) {
        expiredGroceries.add(groceries.get(i));
      }
    }
    return expiredGroceries;
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
   * Returns a grocery with the given name
   *
   * @param name
   * @return a grocery with the given name
   */
  public Grocery getGrocery(String name) {
    for (int i = 0; i < groceries.size(); i++) {
      if (groceries.get(i).name.equals(name)) {
        return groceries.get(i);
      }
    }
    return null;
  }

  /**
   * Sorts the groceries in the register by name
   * 
   * @return a sorted list of groceries
   */
  public ArrayList<Grocery> getSortedGroceryList() {
    ArrayList<Grocery> sortedGroceries = new ArrayList<>(groceries);
    sortedGroceries.sort((g1, g2) -> g1.name.compareTo(g2.name));
    return sortedGroceries;
  }
}
