package edu.ntnu.idi.idatt.registers;

import edu.ntnu.idi.idatt.types.Grocery;
import java.util.ArrayList;

/**
 * @version 1.4
 * @since 1.0
 */
public class GroceryRegister {
  private ArrayList<Grocery> groceries = new ArrayList<>();

  public GroceryRegister() {}

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
}
