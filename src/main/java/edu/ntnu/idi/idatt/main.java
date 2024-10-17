package edu.ntnu.idi.idatt;

public class Main {

  static final Ingredient[] ingredientsInFridge = {
    new Ingredient("egg", "stk", 3, 100),
    new Ingredient("milk", "dl", 9, 50),
    new Ingredient("sugar", "g", 0, 0),
    new Ingredient("flour", "g", 0, 0),
    new Ingredient("yeast", "g", 0, 0),
    new Ingredient("salt", "g", 0, 0)
  };

  static final Ingredient[] ingredientsOnCounter = {
    new Ingredient("egg", "stk", 0, 5),
    new Ingredient("milk", "liter", 0, 20),
    new Ingredient("sugar", "kg", 250, 50),
    new Ingredient("flour", "kg", 200, 50),
    new Ingredient("yeast", "kg", 100, 100),
    new Ingredient("salt", "kg", 20, 100),
  };

  static final Ingredient[] pancakeIngredients = {
    new Ingredient("egg", "stk", 1, 5),
    new Ingredient("milk", "dl", 2, 20),
    new Ingredient("sugar", "kg", 50, 50),
    new Ingredient("flour", "kg", 150, 50),
  };

  static final Ingredient[] breadIngredients = {
    new Ingredient("flour", "kg", 500, 50),
    new Ingredient("yeast", "kg", 25, 100),
    new Ingredient("sugar", "kg", 10, 50),
    new Ingredient("salt", "kg", 10, 100),
    new Ingredient("milk", "liter", 5, 20),
  };

  public static class Ingredient {
    private String name;
    private String unit;
    private int amount;
    private int valuePerUnit;

    public Ingredient(String name, String unit, int amount, int valuePerUnit) {
      this.name = name;
      this.unit = unit;
      this.amount = amount;
      this.valuePerUnit = valuePerUnit;
    }

    @Override
    public String toString() {
      return amount + " " + unit + " " + name;
    }
  }

  public static class Recipe {
    private String name;
    private Ingredient[] ingredients;

    public Recipe(String name, Ingredient[] ingredients) {
      this.name = name;
      this.ingredients = ingredients;
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("\n").append(name).append("\n");
      for (Ingredient ingredient : ingredients) {
        sb.append(ingredient).append("\n");
      }
      return sb.toString();
    }
  }

  public static class Fridge {
    private Ingredient[] ingredients;

    public Fridge(Ingredient[] ingredients) {
      this.ingredients = ingredients;
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("\nThe fridge contains:\n");
      for (Ingredient ingredient : ingredients) {
        if (ingredient.amount == 0) {
          continue;
        }
        sb.append(ingredient).append("\n");
      }
      return sb.toString();
    }
  }

  public static class Counter {
    private Ingredient[] ingredients;

    public Counter(Ingredient[] ingredients) {
      this.ingredients = ingredients;
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("\nThe counter contains:\n");
      for (Ingredient ingredient : ingredients) {
        if (ingredient.amount == 0) {
          continue;
        }
        sb.append(ingredient).append("\n");
      }
      return sb.toString();
    }
  }

  public static class Kitchen {
    private Fridge fridge;
    private Counter counter;
    private Recipe[] recipes;

    public Kitchen(Fridge fridge, Counter counter, Recipe[] recipes) {
      this.fridge = fridge;
      this.counter = counter;
      this.recipes = recipes;
    }

    public void CheckFridge() {
      System.out.println(fridge);
    }

    public void CheckCounter() {
      System.out.println(counter);
    }

    public void CheckRecipes() {
      for (Recipe recipe : recipes) {
        System.out.println(recipe);
      }
    }

    public void takeIngredientFromFridge(String name, int amount) {
      for (Ingredient i : fridge.ingredients) {
        if (!i.name.equals(name)) {
          continue;
        }
        if (!(i.amount >= amount)) {
          System.out.println("Not enough " + name + " in the fridge");
          return;
        }
        i.amount -= amount;
        for (Ingredient j : counter.ingredients) {
          if (j.name.equals(name)) {
            j.amount += amount;
            return;
          }
        }
      }
    }

    public void takeIngredientFromCounter(String name, int amount) {
      for (Ingredient i : counter.ingredients) {
        if (!i.name.equals(name)) {
          continue;
        }
        if (!(i.amount >= amount)) {
          System.out.println("Not enough " + name + " on the counter");
          return;
        }
        i.amount -= amount;
        for (Ingredient j : fridge.ingredients) {
          if (j.name.equals(name)) {
            j.amount += amount;
            return;
          }
        }
      }
    }

    public void CheckKitchen() {
      CheckFridge();
      CheckCounter();
      //CheckRecipes();
    }
  }

  public static void main(String[] args) {
    Fridge fridge = new Fridge(ingredientsInFridge);
    Counter counter = new Counter(ingredientsOnCounter);
    Recipe pancakes = new Recipe("Pancakes", pancakeIngredients);
    Recipe bread = new Recipe("Bread", breadIngredients);
    Recipe[] recipes = {pancakes, bread};
    Kitchen kitchen = new Kitchen(fridge, counter, recipes);

  }
}