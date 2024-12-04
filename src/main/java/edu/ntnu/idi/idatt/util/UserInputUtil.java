package edu.ntnu.idi.idatt.util;

import edu.ntnu.idi.idatt.types.Cookbook;
import edu.ntnu.idi.idatt.types.Grocery;
import edu.ntnu.idi.idatt.types.Ingredient;
import edu.ntnu.idi.idatt.types.Recipe;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class UserInputUtil {

  private static Scanner scanner = new Scanner(System.in);
  private static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

  public String getString(String prompt) {
    System.out.print(prompt);
    return scanner.nextLine();
  }

  public int getInt(String prompt) {
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

  public double getDouble(String prompt) {
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

  public Date getDate(String prompt) {
    while (true) {
      System.out.print(prompt);
      try {
        return formatter.parse(scanner.nextLine());
      } catch (Exception e) {
        System.out.println("Invalid date format.");
      }
    }
  }

  public Grocery getGrocery() {
    String name = getString("Enter name: ");
    String unit = getString("Enter unit: ");
    int amount = getInt("Enter amount: ");
    double pricePerUnit = getDouble("Enter price per unit: ");
    Date expirationDate = getDate("Enter expiration date (dd/MM/yyyy): ");
    return new Grocery(name, unit, amount, pricePerUnit, expirationDate);
  }

  public Ingredient getIngredient() {
    String name = getString("Enter name: ");
    String unit = getString("Enter unit: ");
    int amount = getInt("Enter amount: ");
    return new Ingredient(name, unit, amount);
  }

  public Recipe getRecipe() {
    String name = getString("Enter name: ");
    String description = getString("Enter description: ");
    String instructions = getString("Enter instructions: ");
    ArrayList<Ingredient> ingredients = new ArrayList<>();
    while (true) {
      ingredients.add(getIngredient());
      System.out.print("Add another ingredient? (y/n): ");
      if (!scanner.nextLine().equalsIgnoreCase("y")) {
        break;
      }
    }
    return new Recipe(name, description, instructions, ingredients);
  }

  public Cookbook getCookbook() {
    String name = getString("Enter name: ");
    return new Cookbook(name);
  }

  public ArrayList<String> getSeperatedString(String prompt) {
    System.out.print(prompt);
    String input = scanner.nextLine();
    return new ArrayList<>(List.of(input.replace(" ", "").split(",")));
  }

  public int getUserInputOption() {
    System.out.print(
        """
        \n
        1.  Register Grocery
        2.  Register Recipe
        3.  Register Cookbook
        4.  Add Grocery Amount
        5.  Remove Grocery Amount
        6.  Add Recipe to Cookbook
        7.  Search for Grocery
        8.  List Groceries
        9.  List Recipes
        10. List Cookbooks
        11. List Expired Groceries
        12. List Sorted Groceries
        13. List Available Recipes
        14. Check Recipe Groceries
        15. List Expired Groceries Before Given Date
        16. Exit
        """);
    return getInt("Enter choice: ");
  }

  public void closeScanner() {
    scanner.close();
  }
}
