package edu.ntnu.idi.idatt.models;

import edu.ntnu.idi.idatt.registers.GroceryRegister;
import edu.ntnu.idi.idatt.types.Cookbook;
import edu.ntnu.idi.idatt.types.Grocery;
import edu.ntnu.idi.idatt.types.Recipe;
import java.util.ArrayList;
import java.util.Date;

public class FoodStorage {
  GroceryRegister groceryRegister = new GroceryRegister();

  public FoodStorage() {}

  public void registerGrocery(Grocery grocery) {
    Grocery existingGrocery = groceryRegister.searchForGrocery(grocery.name);
    if (existingGrocery != null) {
      existingGrocery.addAmount(grocery.amount);
    } else {
      groceryRegister.registerGrocery(grocery);
    }
  }

  public void addGroceryAmount(String name, int amount) {
    Grocery grocery = groceryRegister.searchForGrocery(name);
    if (grocery != null) {
      grocery.addAmount(amount);
    } else {
      System.out.println("Grocery not found");
    }
    if (grocery.amount <= 0) {
      groceryRegister.removeGrocery(grocery);
    }
  }

  public void removeGroceryAmount(String name, int amount) {
    Grocery grocery = groceryRegister.searchForGrocery(name);
    if (grocery != null) {
      grocery.removeAmount(amount);
    } else {
      System.out.println("Grocery not found");
    }
    if (grocery.amount <= 0) {
      groceryRegister.removeGrocery(grocery);
    }
  }

  public void searchForGrocery(String name) {
    Grocery grocery = groceryRegister.searchForGrocery(name);
    if (grocery != null) {
      System.out.println(grocery.getFormattedString());
    } else {
      System.out.println("Grocery not found");
    }
  }

  public void listGroceries() {
    for (Grocery grocery : groceryRegister.groceries) {
      System.out.println(grocery.getFormattedString());
    }
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

  public void listExpiredGroceriesBeforeGivenDate(Date date) {
    ArrayList<Grocery> expiredGroceries = groceryRegister.getExpiredGrocieries();
    double totalCost = 0;
    for (Grocery grocery : expiredGroceries) {
      if (grocery.expirationDate.before(date)) {
        System.out.println(grocery.getFormattedString());
        totalCost += grocery.getPrice();
      }
    }
    System.out.println("Total cost of expired groceries: " + totalCost);
  }

  public void listSortedGroceries() {
    ArrayList<Grocery> sortedGroceries = groceryRegister.getSortedGroceryList();
    for (Grocery grocery : sortedGroceries) {
      System.out.println(grocery.getFormattedString());
    }
  }

  public void hasGroceries(Recipe recipe) {
    for (Grocery grocery : recipe.groceries) {
      Grocery existingGrocery = groceryRegister.searchForGrocery(grocery.name);
      if (existingGrocery == null || existingGrocery.amount < grocery.amount) {
        System.out.println("Missing groceries");
        return;
      }
    }
    System.out.println("All groceries available");
  }

  public void listAvailableRecipies(Cookbook cookbook) {
    for (Recipe recipe : cookbook.recipes) {
      hasGroceries(recipe);
    }
  }
}
