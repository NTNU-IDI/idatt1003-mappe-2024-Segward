package edu.ntnu.idi.idatt.models;

import java.util.Scanner;

/**
 * @version 1.2
 * @since 1.0
 */
public class UserInterface {
  DataStorage dataStorage;
  FoodStorage foodStorage;
  Scanner scanner;
  boolean isRunning;
  final String[] menuOptions = {
    "1. Add grocery",
    "2. Add amount to grocery",
    "3. Enumerate groceries",
    "4. Exit"
  };

  /** Constructor for the UserInterface class. */
  public UserInterface() {
    dataStorage = new DataStorage();
    foodStorage = new FoodStorage();
    scanner = new Scanner(System.in);
    isRunning = true;
  }

  /**
   * Returns a double input from the user.
   *
   * @param message the message to display to the user
   * @return
   */
  public double getDoubleInput(String message) {
    System.out.print(message);
    return scanner.nextDouble();
  }

  /**
   * Returns an integer input from the user.
   *
   * @param message the message to display to the user
   * @return
   */
  public int getIntInput(String message) {
    System.out.print(message);
    return scanner.nextInt();
  }

  /**
   * Returns a string input from the user.
   *
   * @param message the message to display to the user
   * @return
   */
  public String getStringInput(String message) {
    System.out.print(message);
    return scanner.nextLine();
  }

  /** Initializes resources and load data */
  public void init() {
    System.out.println("Initializing...");
  }

  public int getMenuChoice() {
    for (String option : menuOptions) {
      System.out.println(option);
    }
    return getIntInput("Enter your choice: ");
  }

  /** Starts the user interface */
  public void start() {
    while (isRunning) {
      int choice = getMenuChoice();
    }
  }
}
