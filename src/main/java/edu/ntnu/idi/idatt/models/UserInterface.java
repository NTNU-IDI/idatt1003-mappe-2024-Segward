package edu.ntnu.idi.idatt.models;

import edu.ntnu.idi.idatt.types.Grocery;
import edu.ntnu.idi.idatt.types.Recipe;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 * @version 1.6
 * @since 1.0
 */
public class UserInterface {
  FoodStorage foodStorage = new FoodStorage();
  RecipeBook recipeBook = new RecipeBook();
  Scanner scanner = new Scanner(System.in);
  boolean isRunning = false;
  SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

  String options =
      "\n1.   Register new grocery\n"
          + "2.   Register new recipe\n"
          + "3.   Add amount to grocery\n"
          + "4.   Add recipe to recipebook\n"
          + "5.   Remove amount from grocery\n"
          + "6.   Search for grocery\n"
          + "7.   List groceries\n"
          + "8.   List recipes\n"
          + "9.   Get expired groceries\n"
          + "10.  Get sorted grocery list\n"
          + "11.  Check foodstorage for available recipies\n"
          + "12.  Get groceries before a given expiration date\n"
          + "13.  Exit\n";

  final int REGISTER_NEW_GROCERY = 1;
  final int REGISTER_NEW_RECIPE = 2;
  final int ADD_AMOUNT_TO_GROCERY = 3;
  final int ADD_RECIPE_TO_RECIPEBOOK = 4;
  final int REMOVE_AMOUNT_FROM_GROCERY = 5;
  final int SEARCH_FOR_GROCERY = 6;
  final int LIST_GROCERIES = 7;
  final int LIST_RECIPES = 8;
  final int GET_EXPIRED_GROCERIES = 9;
  final int GET_SORTED_GROCERY_LIST = 10;
  final int CHECK_FOODSTORAGE_FOR_AVAILABLE_RECIPIES = 11;
  final int GET_GROCERIES_BEFORE_A_GIVEN_EXPIRATION_DATE = 12;
  final int EXIT = 13;

  /** Constructor for the UserInterface class. */
  public UserInterface() {}

  /**
   * Get a string input from the user.
   *
   * @param message the message to display to the user
   * @return user input as string
   */
  private String getStringInput(String message) {
    System.out.print(message);
    return scanner.nextLine();
  }

  /**
   * Get a integer input from the user.
   *
   * @param message the message to display to the user
   * @return user input as integer
   */
  private int getIntInput(String message) {
    System.out.print(message);
    while (!scanner.hasNextInt()) {
      System.out.println("Invalid input. Please enter a valid number.");
      scanner.next();
      System.out.print("Enter choice: ");
    }
    int choice = scanner.nextInt();
    scanner.nextLine();
    return choice;
  }

  /**
   * Get a double input from the user.
   *
   * @param message the message to display to the user
   * @return user input as double
   */
  private double getDoubleInput(String message) {
    System.out.print(message);
    while (true) {
      try {
        return Double.parseDouble(scanner.nextLine());
      } catch (NumberFormatException e) {
        System.out.println("Invalid input. Please enter a valid number.");
        System.out.print("Enter choice: ");
      }
    }
  }

  /**
   * Get a date input from the user.
   *
   * @param message the message to display to the user
   * @return the date input from the user
   */
  public Date getDateInput(String message) {
    while (true) {
      System.out.print(message);
      try {
        return formatter.parse(scanner.nextLine());
      } catch (Exception e) {
        System.out.println("Invalid date format.");
      }
    }
  }

  /**
   * Get a grocery input from the user.
   *
   * @return the grocery input from the user
   */
  public Grocery getGroceryInput() {
    String name = getStringInput("Enter the name of the grocery: ");
    String unit = getStringInput("Enter the unit of the grocery: ");
    int amount = getIntInput("Enter the amount of the grocery: ");
    double pricePerUnit = getDoubleInput("Enter the price per unit of the grocery: ");
    Date expirationDate = getDateInput("Enter the expiration date of the grocery (dd/MM/yyyy): ");
    return new Grocery(name, unit, amount, pricePerUnit, expirationDate);
  }

  /**
   * Get a recipe input from the user.
   *
   * @return the recipe input from the user
   */
  public Recipe getRecipeInput() {
    String name = getStringInput("Enter the name of the recipe: ");
    String description = getStringInput("Enter the description of the recipe: ");
    String instructions = getStringInput("Enter the instructions of the recipe: ");
    ArrayList<Grocery> ingredients = new ArrayList<>();
    while (true) {
      Grocery grocery = getGroceryInput();
      ingredients.add(grocery);
      System.out.print("Do you want to add more groceries to the recipe? (y/n): ");
      String choice = scanner.nextLine();
      if (choice.equals("n")) {
        break;
      }
    }
    return new Recipe(name, description, ingredients, instructions);
  }

  /** Initializes resources and load data */
  public void init() {
    System.out.println("Initializing...");
    isRunning = true;
  }

  /**
   * Returns the user's input based on the options given
   *
   * @return the user's input choice
   */
  public int getUserInput() {
    System.out.println(options);
    return getIntInput("Enter your choice: ");
  }

  /**
   * Handles the user's input
   *
   * @param input the user's input
   */
  public void inputHandler(int input) {
    switch (input) {
      case REGISTER_NEW_GROCERY:
        Grocery grocery = getGroceryInput();
        foodStorage.addGrocery(grocery);
        break;

      case REGISTER_NEW_RECIPE:
        Recipe recipe = getRecipeInput();
        recipeBook.addRecipe(recipe);
        break;

      case ADD_AMOUNT_TO_GROCERY:
        int amountToAdd = getIntInput("Enter the amount to add: ");
        String groceryNameForAdding = getStringInput("Enter the name of the grocery: ");
        foodStorage.addAmountToGrocery(groceryNameForAdding, amountToAdd);
        break;

      case ADD_RECIPE_TO_RECIPEBOOK:
        // huh?
        break;

      case REMOVE_AMOUNT_FROM_GROCERY:
        int amountToRemove = getIntInput("Enter the amount to remove: ");
        String groceryNameForRemoving = getStringInput("Enter the name of the grocery: ");
        foodStorage.removeAmountFromGrocery(groceryNameForRemoving, amountToRemove);
        break;

      case SEARCH_FOR_GROCERY:
        String groceryName = getStringInput("Enter the name of the grocery: ");
        Grocery foundGrocery = foodStorage.getGrocery(groceryName);
        if (foundGrocery != null) {
          System.out.println("Grocery found: " + foundGrocery.getFormattedString());
        } else {
          System.out.println("Grocery not found.");
        }
        break;

      case LIST_GROCERIES:
        foodStorage.listGroceries();
        break;

      case LIST_RECIPES:
        recipeBook.listRecipes();
        break;

      case GET_EXPIRED_GROCERIES:
        foodStorage.listExpiredGroceries();
        break;

      case GET_SORTED_GROCERY_LIST:
      
        break;

      case CHECK_FOODSTORAGE_FOR_AVAILABLE_RECIPIES:
        break;

      case GET_GROCERIES_BEFORE_A_GIVEN_EXPIRATION_DATE:
        break;

      case EXIT:
        isRunning = false;
        break;

      default:
        System.out.println("Invalid choice.");
    }
  }

  /** Starts the user interface */
  public void start() {
    while (isRunning) {
      int input = getUserInput();
      inputHandler(input);
    }
  }
}
