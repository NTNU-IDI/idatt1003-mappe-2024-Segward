package edu.ntnu.idi.idatt.models;

import edu.ntnu.idi.idatt.util.UserInput;

public class UserInterface {
  FoodStorage foodStorage = new FoodStorage();
  RecipeManager recipeManager = new RecipeManager();
  boolean isRunning = false;
  final int REGISTER_GROCERY = 1;
  final int REGISTER_RECIPE = 2;
  final int ADD_GROCERY_AMOUNT = 3;
  final int REMOVE_GROCERY_AMOUNT = 4;
  final int ADD_RECIPE_TO_COOKBOOK = 5;
  final int SEARCH_FOR_GROCERY = 6;
  final int LIST_GROCERIES = 7;
  final int LIST_RECIPES = 8;
  final int LIST_COOKBOOKS = 9;
  final int LIST_EXPIRED_GROCERIES = 10;
  final int LIST_SORTED_GROCERIES = 11;
  final int LIST_AVAILABLE_RECIPIES = 12;
  final int CHECK_RECIPE_GROCERIES = 13;
  final int LIST_EXPIRED_GROCERIES_BEFORE_GIVEN_DATE = 14;
  final int EXIT = 15;
  final String options =
      "1.   Register new grocery\n"
          + "2.   Register new recipe\n"
          + "3.   Add amount to grocery\n"
          + "4.   Remove amount from grocery\n"
          + "5.   Add recipe to cookbook\n"
          + "6.   Search for grocery\n"
          + "7.   List groceries\n"
          + "8.   List recipes\n"
          + "9.   List cookbooks\n"
          + "10.  List expired groceries\n"
          + "11.  List sorted groceries\n"
          + "12.  List available groceries for a given recipe\n"
          + "13.  Check foodstorage for available recipes\n"
          + "14.  List groceries before a given expiration date\n"
          + "15.  Exit\n";

  public UserInterface() {}

  public void init() {
    System.out.println("Initializing...");
    isRunning = true;
  }

  public void start() {
    while (isRunning) {
      int input = UserInput.getInt(options + "Choose an option: ");
      switch (input) {
        case REGISTER_GROCERY:
          break;

        case REGISTER_RECIPE:
          break;

        case ADD_GROCERY_AMOUNT:
          break;

        case REMOVE_GROCERY_AMOUNT:
          break;

        case ADD_RECIPE_TO_COOKBOOK:
          break;

        case SEARCH_FOR_GROCERY:
          break;

        case LIST_GROCERIES:
          break;

        case LIST_RECIPES:
          break;

        case LIST_COOKBOOKS:
          break;

        case LIST_EXPIRED_GROCERIES:
          break;

        case LIST_SORTED_GROCERIES:
          break;

        case LIST_AVAILABLE_RECIPIES:
          break;

        case CHECK_RECIPE_GROCERIES:
          break;

        case LIST_EXPIRED_GROCERIES_BEFORE_GIVEN_DATE:
          break;

        case EXIT:

        default:
          break;
      }
    }
  }
}
