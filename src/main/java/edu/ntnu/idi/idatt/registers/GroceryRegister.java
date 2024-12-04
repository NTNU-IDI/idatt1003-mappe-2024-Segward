package edu.ntnu.idi.idatt.registers;

import edu.ntnu.idi.idatt.types.Cookbook;
import edu.ntnu.idi.idatt.types.Grocery;
import edu.ntnu.idi.idatt.types.Recipe;
import edu.ntnu.idi.idatt.types.Ingredient;
import java.util.ArrayList;
import java.util.Date;

public class GroceryRegister {
  public ArrayList<Grocery> groceries = new ArrayList<>();

  public GroceryRegister() {}

  public Grocery searchForGrocery(String name) {
    for (int i = 0; i < groceries.size(); i++) {
      if (groceries.get(i).name.equals(name)) {
        return groceries.get(i);
      }
    }
    return null;
  }

  public void add(Grocery grocery) {
    Grocery existingGrocery = searchForGrocery(grocery.name);
    if (existingGrocery != null) {
      existingGrocery.addAmount(grocery.amount);
    } else {
      groceries.add(grocery);
    }
  }

  public void remove(Grocery grocery) {
    groceries.remove(grocery);
  }

  public void addAmount(String name, int amount) {
    Grocery grocery = searchForGrocery(name);
    if (grocery != null) {
      grocery.addAmount(amount);
    } else {
      System.out.println("Grocery not found");
    }
    if (grocery.amount <= 0) {
      remove(grocery);
    }
  }

  public void removeAmount(String name, int amount) {
    Grocery grocery = searchForGrocery(name);
    if (grocery != null) {
      grocery.removeAmount(amount);
    } else {
      System.out.println("Grocery not found");
    }
    if (grocery.amount <= 0) {
      remove(grocery);
    }
  }

  public void list() {
    for (Grocery grocery : groceries) {
      System.out.println(grocery.getFormattedString());
    }
  }

  public ArrayList<Grocery> getExpired() {
    ArrayList<Grocery> expiredGroceries = new ArrayList<>();
    for (int i = 0; i < groceries.size(); i++) {
      if (groceries.get(i).isExpired()) {
        expiredGroceries.add(groceries.get(i));
      }
    }
    return expiredGroceries;
  }

  public void listExpired() {
    ArrayList<Grocery> expiredGroceries = getExpired();
    double totalCost = 0;
    for (Grocery grocery : expiredGroceries) {
      System.out.println(grocery.getFormattedString());
      totalCost += grocery.getPrice();
    }
    System.out.println("Total cost of expired groceries: " + totalCost);
  }

  public void listExpiredBeforeDate(Date date) {
    ArrayList<Grocery> expiredGroceries = getExpired();
    double totalCost = 0;
    for (Grocery grocery : expiredGroceries) {
      if (grocery.expirationDate.before(date)) {
        System.out.println(grocery.getFormattedString());
        totalCost += grocery.getPrice();
      }
    }
    System.out.println("Total cost of expired groceries: " + totalCost);
  }

  public void listSorted() {
    ArrayList<Grocery> sortedGroceries = new ArrayList<>(groceries);
    sortedGroceries.sort((g1, g2) -> g1.name.compareTo(g2.name));
    for (Grocery grocery : sortedGroceries) {
      System.out.println(grocery.getFormattedString());
    }
  }

  public void containsRecipe(Recipe recipe) {
    for (Ingredient ingredient : recipe.ingredients) {
      Grocery contains = searchForGrocery(ingredient.name);
      if (contains == null || contains.amount < ingredient.amount) {
        System.out.println("Missing grocery: " + ingredient.getFormattedString());
        return;
      }
    }
    System.out.println("All groceries available");
  }

  public void suggestRecipies(Cookbook cookbook) {
    if (cookbook == null) {
      System.out.println("Cookbook not found");
      return;
    }
    for (Recipe recipe : cookbook.recipes) {
      containsRecipe(recipe);
    }
  }
}
