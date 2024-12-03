package edu.ntnu.idi.idatt.models;

import edu.ntnu.idi.idatt.util.UserInput;

public class UserInterface {
  final int REGISTER_GROCERY = 1;
  final int REGISTER_RECIPE = 2;
  final int REGISTER_COOKBOOK = 3;
  final int ADD_GROCERY_AMOUNT = 4;
  final int REMOVE_GROCERY_AMOUNT = 5;
  final int ADD_RECIPE_TO_COOKBOOK = 6;
  final int SEARCH_FOR_GROCERY = 7;
  final int LIST_GROCERIES = 8;
  final int LIST_RECIPES = 9;
  final int LIST_COOKBOOKS = 10;
  final int LIST_EXPIRED_GROCERIES = 11;
  final int LIST_SORTED_GROCERIES = 12;
  final int LIST_AVAILABLE_RECIPIES = 13;
  final int CHECK_RECIPE_GROCERIES = 14;
  final int LIST_EXPIRED_GROCERIES_BEFORE_GIVEN_DATE = 15;
  final int EXIT = 16;
  final String options =
      "1.   Register new grocery\n"
          + "2.   Register new recipe\n"
          + "3.   Register new cookbook\n"
          + "4.   Add amount to grocery\n"
          + "5.   Remove amount from grocery\n"
          + "6.   Add recipe to cookbook\n"
          + "7.   Search for grocery\n"
          + "8.   List groceries\n"
          + "9.   List recipes\n"
          + "10.  List cookbooks\n"
          + "11.  List expired groceries\n"
          + "12.  List sorted groceries\n"
          + "13.  List available groceries for a given recipe\n"
          + "14.  List groceries before a given expiration date\n"
          + "15.  Check foodstorage for available recipes\n"
          + "16.  Exit\n";
  FoodStorage foodStorage;
  RecipeManager recipeManager;
  boolean isRunning = false;

  public UserInterface() {}

  public void init() {
    isRunning = true;
    foodStorage = new FoodStorage();
    recipeManager = new RecipeManager();
  }

  public void start() {
    while (isRunning) {
      int input = UserInput.getInt(options + "Choose an option: ");
      switch (input) {
        case REGISTER_GROCERY:
          foodStorage.registerGrocery(UserInput.getGrocery());
          break;

        case REGISTER_RECIPE:
          recipeManager.registerRecipe(UserInput.getRecipe());
          break;

        case REGISTER_COOKBOOK:
          recipeManager.registerCookbook(UserInput.getCookbook());
          break;

        case ADD_GROCERY_AMOUNT:
          foodStorage.addGroceryAmount(
              UserInput.getString("Enter grocery name: "),
              UserInput.getInt("Enter amount to add: "));
          break;

        case REMOVE_GROCERY_AMOUNT:
          foodStorage.removeGroceryAmount(
              UserInput.getString("Enter grocery name: "),
              UserInput.getInt("Enter amount to remove: "));
          break;

        case ADD_RECIPE_TO_COOKBOOK:
          recipeManager.addRecipeToCookbook(
              UserInput.getString("Enter recipe name: "),
              UserInput.getString("Enter cookbook name: "));
          break;

        case SEARCH_FOR_GROCERY:
          foodStorage.searchForGrocery(UserInput.getString("Enter grocery name: "));
          break;

        case LIST_GROCERIES:
          foodStorage.listGroceries();
          break;

        case LIST_RECIPES:
          recipeManager.listRecipies();
          break;

        case LIST_COOKBOOKS:
          recipeManager.listCookbooks();
          break;

        case LIST_EXPIRED_GROCERIES:
          foodStorage.listExpiredGroceries();
          break;

        case LIST_SORTED_GROCERIES:
          foodStorage.listSortedGroceries();
          break;

        case LIST_AVAILABLE_RECIPIES:
          foodStorage.listAvailableRecipies(
              recipeManager.cookbookRegister.searchForCookbook(
                  UserInput.getString("Enter cookbook name: ")));
          break;

        case CHECK_RECIPE_GROCERIES:
          foodStorage.hasGroceries(
              recipeManager.recipeRegister.searchForRecipe(
                  UserInput.getString("Enter recipe name: ")));
          break;

        case LIST_EXPIRED_GROCERIES_BEFORE_GIVEN_DATE:
          foodStorage.listExpiredGroceriesBeforeGivenDate(
              UserInput.getDate("Enter expiration date (dd/MM/yyyy): "));
          break;

        case EXIT:

        default:
          break;
      }
    }
  }
}
