package edu.ntnu.idi.idatt.models;

import edu.ntnu.idi.idatt.registers.GroceryRegister;
import edu.ntnu.idi.idatt.types.Grocery;
import edu.ntnu.idi.idatt.types.Recipe;
import java.util.ArrayList;

public class FoodStorage {
  GroceryRegister groceryRegister = new GroceryRegister();

  public FoodStorage() {}

  public Grocery getGrocery(String name) {
    return groceryRegister.getGrocery(name);
  }

  public void listGroceries() {
    groceryRegister.listGroceries();
  }

  public void listExpiredGroceries() {
    ArrayList<Grocery> expiredGroceries = groceryRegister.getExpiredGrocieries();
    double totalCost = 0;
    for (Grocery grocery : expiredGroceries) {
      System.out.println(grocery.getFormattedString());
      totalCost += grocery.getPrice();
    }
    System.out.println("Total cost of expired groceries: " + totalCost);
  }

  public void addGrocery(Grocery grocery) {
    Grocery existingGrocery = groceryRegister.getGrocery(grocery.name);
    if (existingGrocery != null) {
      existingGrocery.addAmount(grocery.amount);
    } else {
      groceryRegister.addGrocery(grocery);
    }
  }

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

  public void listSortedGroceries() {
    ArrayList<Grocery> sortedGroceries = groceryRegister.getSortedGroceryList();
    for (Grocery grocery : sortedGroceries) {
      System.out.println(grocery.getFormattedString());
    }
  }

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
