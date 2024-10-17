package edu.ntnu.idi.idatt;

// This class is responsible for the "Fridge" object.
// The fridge object contains an array of ingredients and methods to interact with the ingredients.
public class Fridge {

  Ingredient[] ingredients;

  // The constructor for the fridge object and it takes an array of ingredients as a parameter.
  public Fridge(Ingredient[] ingredients) {
    this.ingredients = ingredients;
  }

  // This method is used to search for an ingredient in the fridge.
  // It returns true if the ingredient is found, and false if it is not found.
  public boolean search(String ingredientName) {
    for (Ingredient i : ingredients) {
      if (i.name.equals(ingredientName)) {
        return true;
      }
    }
    return false;
  }

  // This method is used to get an ingredient from the fridge.
  // It returns the ingredient if it is found, and null if it is not found.
  public Ingredient getIngredient(String ingredientName) {
    for (Ingredient i : ingredients) {
      if (i.name.equals(ingredientName)) {
        return i;
      }
    }
    return null;
  }

  // This method is used to add an ingredient to the fridge.
  public void addAmountToIngredient(String ingredientName, int amount) {
    for (Ingredient i : ingredients) {
      if (i.name.equals(ingredientName)) {
        i.amount += amount;
      }
    }
  }

  // This method is used to remove an ingredient from the fridge.
  public void removeAmountFromIngredient(String ingredientName, int amount) {
    for (Ingredient i : ingredients) {
      if (i.name.equals(ingredientName)) {
        i.amount -= amount;
      }
    }
  }

  // This method is used to get the total price of the ingredients in the fridge.
  public double getTotalPrice() {
    double totalPrice = 0;
    for (Ingredient i : ingredients) {
      totalPrice += i.getPrice();
    }
    return totalPrice;
  }

  // This method is used to get the expired ingredients in the fridge.
  public String getExpiredIngredients() {
    StringBuilder sb = new StringBuilder();
    sb.append("\n");
    for (Ingredient i : ingredients) {
      if (i.isExpired()) {
        sb.append(i.toString()).append("\n");
      }
    }
    return sb.toString();
  }

  // This method is used for printing the entire fridge.
  // It uses StringBuilder to build the string.
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("\n");
    for (Ingredient i : ingredients) {
      sb.append(i.toString()).append("\n");
    }
    return sb.toString();
  }
}
