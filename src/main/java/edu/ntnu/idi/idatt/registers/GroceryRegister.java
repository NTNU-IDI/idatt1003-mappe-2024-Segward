package edu.ntnu.idi.idatt.registers;

import edu.ntnu.idi.idatt.types.Grocery;
import java.util.ArrayList;

public class GroceryRegister {
  public ArrayList<Grocery> groceries = new ArrayList<>();

  public GroceryRegister() {}

  public void listGroceries() {
    for (int i = 0; i < groceries.size(); i++) {
      System.out.println(groceries.get(i).getFormattedString());
    }
  }

  public void addGrocery(Grocery grocery) {
    groceries.add(grocery);
  }

  public ArrayList<Grocery> getExpiredGrocieries() {
    ArrayList<Grocery> expiredGroceries = new ArrayList<>();
    for (int i = 0; i < groceries.size(); i++) {
      if (groceries.get(i).isExpired()) {
        expiredGroceries.add(groceries.get(i));
      }
    }
    return expiredGroceries;
  }

  public void removeGrocery(Grocery grocery) {
    groceries.remove(grocery);
  }

  public Grocery getGrocery(String name) {
    for (int i = 0; i < groceries.size(); i++) {
      if (groceries.get(i).name.equals(name)) {
        return groceries.get(i);
      }
    }
    return null;
  }

  public ArrayList<Grocery> getSortedGroceryList() {
    ArrayList<Grocery> sortedGroceries = new ArrayList<>(groceries);
    sortedGroceries.sort((g1, g2) -> g1.name.compareTo(g2.name));
    return sortedGroceries;
  }
}
