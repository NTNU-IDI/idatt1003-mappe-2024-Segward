package edu.ntnu.idi.idatt;

public class Main {

  static Ingredient[] ingredients = {
    new Ingredient("Egg", "pieces", 12),
    new Ingredient("Milk", "liters", 3),
    new Ingredient("Butter", "grams", 125),
    new Ingredient("Flour", "grams", 500),
  };

  public static void main(String[] args) {
    Fridge fridge = new Fridge(ingredients);
    System.out.println(fridge);
    fridge.addAmountToIngredient("Egg", 6);
    System.out.println(fridge);
    fridge.removeAmountFromIngredient("Milk", 1);
    System.out.println(fridge);
  }
}