package edu.ntnu.idi.idatt.registers;

import edu.ntnu.idi.idatt.types.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.stream.Collectors;

/** A class representing a register of groceries. */
public class GroceryRegister {
  public ArrayList<Grocery> groceries = new ArrayList<>();

  /**
   * Find a grocery by name.
   *
   * @param name the name of the grocery
   * @return the grocery, or null if it does not exist
   */
  public Grocery find(String name) {
    return groceries.stream().filter(g -> g.name.equals(name)).findFirst().orElse(null);
  }

  /**
   * Add a grocery to the register.
   *
   * @param grocery the grocery to add
   */
  public void add(Grocery grocery) {
    Grocery existingGrocery = find(grocery.name);
    if (existingGrocery != null) {
      existingGrocery.amount += grocery.amount;
    } else {
      groceries.add(grocery);
    }
  }

  /**
   * Remove a grocery from the register.
   *
   * @param grocery the grocery to remove
   */
  public void remove(Grocery grocery) {
    Grocery existingGrocery = find(grocery.name);
    if (existingGrocery == null) {
      throw new IllegalArgumentException("Grocery doesnt exist");
    }
    groceries.remove(existingGrocery);
  }

  /**
   * Get the groceries that are expired.
   *
   * @return the expired groceries
   */
  public ArrayList<Grocery> getExpired() {
    Date currentDate = new Date();
    return groceries.stream()
        .filter(g -> g.expirationDate.before(currentDate))
        .collect(Collectors.toCollection(ArrayList::new));
  }

  /**
   * Get the groceries that expire before a given date.
   *
   * @param date the date
   * @return the groceries that expire before the date
   */
  public ArrayList<Grocery> getGroceriesBeforeDate(Date date) {
    return groceries.stream()
        .filter(g -> g.expirationDate.before(date))
        .collect(Collectors.toCollection(ArrayList::new));
  }

  /**
   * Get a sorted list of groceries.
   *
   * <p>The groceries are sorted by name.
   *
   * @return the sorted groceries
   */
  public ArrayList<Grocery> getSorted() {
    ArrayList<Grocery> sortedGroceries = new ArrayList<>(groceries);
    sortedGroceries.sort((g1, g2) -> g1.name.compareTo(g2.name));
    return sortedGroceries;
  }

  /**
   * Check if the grocery register has sufficient ingredients.
   *
   * @param ArrayList<Ingredient> ingredients
   * @return true if the register has sufficient ingredients, false otherwise
   */
  public boolean hasSufficientIngredients(ArrayList<Ingredient> ingredients) {
    return ingredients.stream().allMatch(this::hasSufficientIngredient);
  }

  /**
   * Check if the register has enough of a given ingredient.
   *
   * @param ingredient
   * @return true if the register has enough of the ingredient, false otherwise
   */
  private boolean hasSufficientIngredient(Ingredient ingredient) {
    Grocery grocery = find(ingredient.name);
    return grocery != null && grocery.amount >= ingredient.amount;
  }
}
