package edu.ntnu.idi.idatt.models;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * @version 1.4
 * @since 1.0
 */
public class UserInterface {
  FoodStorage foodStorage = new FoodStorage();
  Scanner scanner = new Scanner(System.in);
  boolean isRunning = false;
  SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

  String options =
      "\n1. Register new grocery\n"
          + "2. Register new recipe\n"
          + "3. Add grocery to foodstorage\n"
          + "4. Add recipe to recipebook\n"
          + "5. Remove grocery from foodstorage\n"
          + "6. Remove recipe from recipebook\n"
          + "7. Search for grocery\n"
          + "8. List groceries\n"
          + "9. List recipes\n"
          + "10. Get expired groceries\n"
          + "11. Get sorted grocery list\n"
          + "12. Check foodstorage for available recipies\n"
          + "13. Get groceries before a given expiration date\n"
          + "14. Exit\n";

  final int REGISTER_NEW_GROCERY = 1;
  final int REGISTER_NEW_RECIPE = 2;
  final int ADD_GROCERY_TO_FOODSTORAGE = 3;
  final int ADD_RECIPE_TO_RECIPEBOOK = 4;
  final int REMOVE_GROCERY_FROM_FOODSTORAGE = 5;
  final int REMOVE_RECIPE_FROM_RECIPEBOOK = 6;
  final int SEARCH_FOR_GROCERY = 7;
  final int LIST_GROCERIES = 8;
  final int LIST_RECIPES = 9;
  final int GET_EXPIRED_GROCERIES = 10;
  final int GET_SORTED_GROCERY_LIST = 11;
  final int CHECK_FOODSTORAGE_FOR_AVAILABLE_RECIPIES = 12;
  final int GET_GROCERIES_BEFORE_A_GIVEN_EXPIRATION_DATE = 13;
  final int EXIT = 14;

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
        break;

      case REGISTER_NEW_RECIPE:
        break;

      case ADD_GROCERY_TO_FOODSTORAGE:
        break;

      case ADD_RECIPE_TO_RECIPEBOOK:
        break;

      case REMOVE_GROCERY_FROM_FOODSTORAGE:
        break;

      case REMOVE_RECIPE_FROM_RECIPEBOOK:
        break;

      case SEARCH_FOR_GROCERY:
        break;

      case LIST_GROCERIES:
        break;

      case LIST_RECIPES:
        break;

      case GET_EXPIRED_GROCERIES:
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
