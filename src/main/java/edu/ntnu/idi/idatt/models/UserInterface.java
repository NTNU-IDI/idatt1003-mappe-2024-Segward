package edu.ntnu.idi.idatt.models;

import java.util.Scanner;

/**
 * @version 1.1
 * @since 1.0
 */
public class UserInterface {
  DataStorage dataStorage;
  FoodStorage foodStorage;
  Scanner scanner;
  boolean isRunning;

  /** Constructor for the UserInterface class. */
  public UserInterface() {
    dataStorage = new DataStorage();
    foodStorage = new FoodStorage();
    scanner = new Scanner(System.in);
    isRunning = true;
  }

  /** Initializes resources and load data */
  public void init() {
    System.out.println("Initializing...");
  }

  /** Starts the user interface */
  public void start() {
    while (isRunning) {
      System.out.println("Running...");
      scanner.nextLine();
    }
  }
}
