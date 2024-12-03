package edu.ntnu.idi.idatt.util;

import edu.ntnu.idi.idatt.types.Cookbook;
import edu.ntnu.idi.idatt.types.Grocery;
import edu.ntnu.idi.idatt.types.Recipe;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class UserInput {

  private static Scanner scanner = new Scanner(System.in);
  private static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

  public static String getString(String prompt) {
    System.out.print(prompt);
    return scanner.nextLine();
  }

  public static int getInt(String prompt) {
    System.out.print(prompt);
    while (!scanner.hasNextInt()) {
      System.out.println("Invalid input. Please enter a valid number.");
      scanner.next();
      System.out.print("Enter choice: ");
    }
    int choice = scanner.nextInt();
    scanner.nextLine();
    return choice;
  }

  public static double getDouble(String prompt) {
    System.out.print(prompt);
    while (true) {
      try {
        return Double.parseDouble(scanner.nextLine());
      } catch (NumberFormatException e) {
        System.out.println("Invalid input. Please enter a valid number.");
        System.out.print("Enter choice: ");
      }
    }
  }

  public static Date getDate(String prompt) {
    while (true) {
      System.out.print(prompt);
      try {
        return formatter.parse(scanner.nextLine());
      } catch (Exception e) {
        System.out.println("Invalid date format.");
      }
    }
  }

  public static Grocery getGrocery() {
    String name = getString("Enter name: ");
    String unit = getString("Enter unit: ");
    int amount = getInt("Enter amount: ");
    double pricePerUnit = getDouble("Enter price per unit: ");
    Date expirationDate = getDate("Enter expiration date (dd/MM/yyyy): ");
    return new Grocery(name, unit, amount, pricePerUnit, expirationDate);
  }

  public static Recipe getRecipe() {
    String name = getString("Enter name: ");
    String description = getString("Enter description: ");
    String instructions = getString("Enter instructions: ");
    ArrayList<Grocery> groceries = new ArrayList<>();
    while (getInt("Add another grocery? (1: Yes, 2: No) ") == 1) {
      groceries.add(getGrocery());
    }
    if (groceries.isEmpty()) {
      System.out.println("A recipe must contain at least one grocery.");
      return null;
    }
    return new Recipe(name, description, instructions, groceries);
  }

  public static Cookbook getCookbook() {
    String name = getString("Enter name: ");
    ArrayList<Recipe> recipes = new ArrayList<>();
    while (getInt("Add another recipe? (1: Yes, 2: No) ") == 1) {
      recipes.add(getRecipe());
    }
    if (recipes.isEmpty()) {
      System.out.println("A cookbook must contain at least one recipe.");
      return null;
    }
    return new Cookbook(name, recipes);
  }

  public static void closeScanner() {
    scanner.close();
  }
}
