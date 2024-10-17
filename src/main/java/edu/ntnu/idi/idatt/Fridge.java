package edu.ntnu.idi.idatt;

public class Fridge {
  Ingredient[] ingredients;

  public Fridge(Ingredient[] ingredients) {
    this.ingredients = ingredients;
  }

  public boolean search(String ingredientName) {
    for (Ingredient i : ingredients) {
      if (i.name.equals(ingredientName)) {
        return true;
      }
    }
    return false;
  }

  public Ingredient getIngredient(String ingredientName) {
    for (Ingredient i : ingredients) {
      if (i.name.equals(ingredientName)) {
        return i;
      }
    }
    return null;
  }

  public void addAmountToIngredient(String ingredientName, int amount) {
    for (Ingredient i : ingredients) {
      if (i.name.equals(ingredientName)) {
        i.amount += amount;
      }
    }
  }

  public void removeAmountFromIngredient(String ingredientName, int amount) {
    for (Ingredient i : ingredients) {
      if (i.name.equals(ingredientName)) {
        i.amount -= amount;
      }
    }
  }

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
