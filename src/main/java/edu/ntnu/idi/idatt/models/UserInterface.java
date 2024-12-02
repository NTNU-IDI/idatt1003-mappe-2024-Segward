package edu.ntnu.idi.idatt.models;

import edu.ntnu.idi.idatt.types.Grocery;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * @version 1.3
 * @since 1.0
 */
public class UserInterface {
  FoodStorage foodStorage;
  Scanner scanner;
  boolean isRunning;
  SimpleDateFormat formatter;
  final int ADD_GROCERY = 1;
  final int ADD_AMOUNT = 2;
  final int ENUMERATE_GROCERIES = 3;
  final int EXIT = 4;
  String options =
      "\n1. Add grocery\n"
          + "2. Add amount to grocery\n"
          + "3. Enumerate groceries\n"
          + "4. Exit\n";

  /** Constructor for the UserInterface class. */
  public UserInterface() {
    foodStorage = new FoodStorage();
    scanner = new Scanner(System.in);
    isRunning = true;
    formatter = new SimpleDateFormat("dd/MM/yyyy");
  }

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

  /** Adds a grocery to the food storage */
  public void addGrocery() {
    String name = getStringInput("Enter the name of the grocery: ");
    String unit = getStringInput("Enter the unit of the grocery: ");
    int amount = getIntInput("Enter the amount of the grocery: ");
    double pricePerUnit = getDoubleInput("Enter the price per unit of the grocery: ");
    Date expirationDate = getDateInput("Enter the expiration date of the grocery (dd/MM/yyyy): ");
    Grocery grocery = new Grocery(name, unit, amount, pricePerUnit, expirationDate);
    foodStorage.addGrocery(grocery);
  }

  /** Adds an amount to a grocery in the food storage */
  public void addAmount() {
    enumerateGroceries();
    int index = getIntInput("Enter the index of the grocery: ");
    int amount = getIntInput("Enter the amount to add: ");
    foodStorage.addGroceryAmount(index, amount);
  }

  /** Enumerates groceries in the food storage */
  public void enumerateGroceries() {
    foodStorage.enumerateGroceries();
  }

  /** Initializes resources and load data */
  public void init() {
    System.out.println("Initializing...");
    isRunning = true;
  }

  /**
   * Returns the user's choice from the menu.
   *
   * @return the user's choice from the menu
   */
  public int getMenuChoice() {
    System.out.println(options);
    return getIntInput("Enter your choice: ");
  }

  /**
   * Handles the user's choice from the menu.
   *
   * @param choice the user's choice from the menu
   */
  public void choiceHandler(int choice) {
    switch (choice) {
      case ADD_GROCERY:
        addGrocery();
        break;
      case ADD_AMOUNT:
        addAmount();
        break;
      case ENUMERATE_GROCERIES:
        enumerateGroceries();
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
      int choice = getMenuChoice();
      choiceHandler(choice);
    }
  }
}
