package edu.ntnu.idi.idatt;

import java.util.Calendar;
import java.util.Date;

public class Main {

  // This method is used to get the current date.
  static Date getCurrentDate() {
    Date currentDate = new Date();
    return currentDate;
  }

  // This method is used to get the future date from the current date
  // It is used to set the expiration date of the ingredients.
  static Date getFutureDate(int daysToAdd) {
    Calendar calendar = Calendar.getInstance();
    calendar.add(Calendar.DAY_OF_MONTH, daysToAdd);
    Date futureDate = calendar.getTime();
    return futureDate;
  }

  // This method is used to get the previous date from the current date.
  // It is used to set the expiration date of the ingredients.
  static Date getPreviousDate(int daysToSubtract) {
    Calendar calendar = Calendar.getInstance();
    calendar.add(Calendar.DAY_OF_MONTH, -daysToSubtract);
    Date previousDate = calendar.getTime();
    return previousDate;
  }

  // Ingredients to be added to the fridge
  static Ingredient[] ingredients = {
    new Ingredient("Egg", "stk", 12, 2.5, getFutureDate(5)),
    new Ingredient("Milk", "liter", 3, 20, getPreviousDate(4)),
    new Ingredient("Butter", "gram", 125, 1.5, getPreviousDate(5)),
    new Ingredient("Flour", "gram", 500, 0.5, getFutureDate(590)),
    new Ingredient("Bacon", "gram", 200, 3.5, getPreviousDate(1)),
    new Ingredient("Cheese", "gram", 300, 2.5, getFutureDate(5)),
  };

  // Main method
  public static void main(String[] args) {
    Fridge fridge = new Fridge(ingredients);
  }
}