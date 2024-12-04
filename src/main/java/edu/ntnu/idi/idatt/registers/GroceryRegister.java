package edu.ntnu.idi.idatt.registers;

import edu.ntnu.idi.idatt.types.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;
import java.util.stream.Collectors;

public class GroceryRegister {
  public ArrayList<Grocery> groceries = new ArrayList<>();

  public Grocery find(String name) {
    Optional<Grocery> grocery = groceries.stream().filter(g -> g.name.equals(name)).findFirst();
    return grocery.orElse(null);
  }

  public void add(Grocery grocery) {
    Grocery existingGrocery = find(grocery.name);
    if (existingGrocery != null) {
      existingGrocery.amount += grocery.amount;
    } else {
      groceries.add(grocery);
    }
  }

  public void remove(Grocery grocery) {
    Grocery existingGrocery = find(grocery.name);
    if (existingGrocery == null) {
      throw new IllegalArgumentException("Grocery doesnt exist");
    }
    groceries.remove(existingGrocery);
  }

  public ArrayList<Grocery> getExpired() {
    return groceries.stream()
        .filter(g -> g.expirationDate.before(new Date()))
        .collect(Collectors.toCollection(ArrayList::new));
  }

  public ArrayList<Grocery> getGroceriesBeforeDate(Date date) {
    return groceries.stream()
        .filter(g -> g.expirationDate.before(date))
        .collect(Collectors.toCollection(ArrayList::new));
  }

  public ArrayList<Grocery> getSorted() {
    ArrayList<Grocery> sortedGroceries = new ArrayList<>(groceries);
    sortedGroceries.sort((g1, g2) -> g1.name.compareTo(g2.name));
    return sortedGroceries;
  }

  public boolean hasSufficientIngredients(ArrayList<Ingredient> ingredients) {
    return ingredients.stream().allMatch(this::hasSufficientIngredient);
  }

  private boolean hasSufficientIngredient(Ingredient ingredient) {
    Grocery grocery = find(ingredient.name);
    return grocery != null && grocery.amount >= ingredient.amount;
  }
}
