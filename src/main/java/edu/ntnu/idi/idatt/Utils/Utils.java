package edu.ntnu.idi.idatt.Utils;

import edu.ntnu.idi.idatt.types.Cookbook;
import edu.ntnu.idi.idatt.types.Grocery;
import edu.ntnu.idi.idatt.types.Ingredient;
import edu.ntnu.idi.idatt.types.Recipe;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/** A utility class for handling user input and dates */
public class Utils {
  private static Scanner scanner = new Scanner(System.in);
  private static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
  private Calendar calendar = Calendar.getInstance();

  /**
   * Get a future date from the current date.
   *
   * @param days
   * @return the future date
   */
  public Date getFutureDate(int days) {
    Date date = resetTime(new Date());
    calendar.setTime(date);
    calendar.add(Calendar.DATE, days);
    return calendar.getTime();
  }

  /**
   * Get a past date from the current date.
   *
   * @param days
   * @return the past date
   */
  public Date getPastDate(int days) {
    Date date = resetTime(new Date());
    calendar.setTime(date);
    calendar.add(Calendar.DATE, -days);
    return calendar.getTime();
  }

  /**
   * Reset the time of a date to 00:00:00.000.
   *
   * @param date
   * @return the date with the time reset
   */
  public Date resetTime(Date date) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    calendar.set(Calendar.HOUR_OF_DAY, 0);
    calendar.set(Calendar.MINUTE, 0);
    calendar.set(Calendar.SECOND, 0);
    calendar.set(Calendar.MILLISECOND, 0);
    return calendar.getTime();
  }

  /**
   * Get a string from the user.
   *
   * @param prompt
   * @return the string entered by the user
   */
  public String getString(String prompt) {
    System.out.print(prompt);
    return scanner.nextLine();
  }

  /**
   * Get an integer from the user.
   *
   * @param prompt
   * @return the integer entered by the user
   */
  public int getInt(String prompt) {
    System.out.print(prompt);
    String input = scanner.nextLine();
    while (!verifyIntInput(input)) {
      System.out.println("Invalid input. Please enter a valid number.");
      System.out.print("Enter integer: ");
      input = scanner.nextLine();
    }
    return Integer.parseInt(input);
  }

  /**
   * Verify that the input is an integer.
   *
   * @param input
   * @return true if the input is an integer, false otherwise
   */
  private boolean verifyIntInput(String input) {
    try {
      Integer.parseInt(input);
      return true;
    } catch (NumberFormatException e) {
      return false;
    }
  }

  /**
   * Get a double from the user.
   *
   * @param prompt
   * @return the double entered by the user
   */
  public double getDouble(String prompt) {
    System.out.print(prompt);
    String input = scanner.nextLine();
    while (!verifyDoubleInput(input)) {
      System.out.println("Invalid input. Please enter a valid number.");
      System.out.print("Enter double: ");
      input = scanner.nextLine();
    }
    return Double.parseDouble(input);
  }

  /**
   * Verify that the input is a double.
   *
   * @param input
   * @return true if the input is a double, false otherwise
   */
  private boolean verifyDoubleInput(String input) {
    try {
      Double.parseDouble(input);
      return true;
    } catch (NumberFormatException e) {
      return false;
    }
  }

  /**
   * Get a date from the user.
   *
   * @param prompt
   * @return the date entered by the user
   */
  public Date getDate(String prompt) {
    System.out.print(prompt);
    String input = scanner.nextLine();
    while (!verifyDateInput(input)) {
      System.out.println("Invalid input. Please enter a valid date.");
      System.out.print("Enter date (dd/MM/yyyy): ");
      input = scanner.nextLine();
    }
    try {
      return formatter.parse(input);
    } catch (Exception e) {
      return null;
    }
  }

  /**
   * Verify that the input is a valid date.
   *
   * @param input
   * @return true if the input is a valid date, false otherwise
   */
  private boolean verifyDateInput(String input) {
    try {
      formatter.parse(input);
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  /**
   * Get a grocery from the user.
   *
   * <p>The user is prompted to enter the name, unit, amount, price per unit, and expiration date of
   * the grocery.
   *
   * @return the grocery entered by the user
   */
  public Grocery getGrocery() {
    System.out.println("Enter the grocery details.\n");
    return new Grocery(
        getString("Enter grocery name: "),
        getString("Enter grocery unit: "),
        getDouble("Enter grocery amount: "),
        getDouble("Enter grocery price per unit: "),
        getDate("Enter groecry expiration date (dd/MM/yyyy): "));
  }

  /**
   * Get an ingredient from the user.
   *
   * <p>The user is prompted to enter the name, unit, and amount of the ingredient.
   *
   * @return the ingredient entered by the user
   */
  public Ingredient getIngredient() {
    System.out.println("\nEnter the ingredient details.\n");
    return new Ingredient(
        getString("Enter ingredient name: "),
        getString("Enter ingredient unit: "),
        getInt("Enter ingredient amount: "));
  }

  /**
   * Get a list of ingredients from the user.
   *
   * <p>The user is prompted to enter the name, unit, and amount of each ingredient. The user can
   * choose to add more ingredients until they choose to stop.
   *
   * @return the list of ingredients entered by the user
   */
  public ArrayList<Ingredient> getIngredients() {
    System.out.println("\nNow add the ingredients.");
    ArrayList<Ingredient> ingredients = new ArrayList<>();
    ingredients.add(getIngredient());

    System.out.print("Add another ingredient? (y/n): ");
    while (scanner.nextLine().equalsIgnoreCase("y")) {
      ingredients.add(getIngredient());
      System.out.print("Add another ingredient? (y/n): ");
    }
    return ingredients;
  }

  /**
   * Get a recipe from the user.
   *
   * <p>The user is prompted to enter the name, description, instructions, and ingredients of the
   * recipe.
   *
   * @return the recipe entered by the user
   */
  public Recipe getRecipe() {
    System.out.println("Enter the recipe details.\n");
    return new Recipe(
        getString("Enter recipe name: "),
        getString("Enter recipe description: "),
        getString("Enter recipe instructions: "),
        getInt("Enter amount of servings: "),
        getIngredients());
  }

  /**
   * Get a cookbook from the user.
   *
   * <p>The user is prompted to enter the name of the cookbook.
   *
   * @return the cookbook entered by the user
   */
  public Cookbook getCookbook() {
    String name = getString("Enter cookbook name: ");
    return new Cookbook(name);
  }

  /**
   * Get the user's choice of action.
   *
   * @return the user's choice of action
   */
  public int getUserInputOption() {
    System.out.println();
    System.out.println(
        """
        1.  Register grocery
        2.  Register recipe
        3.  Register cookbook
        4.  Add grocery amount
        5.  Remove grocery amount
        6.  Add recipe to cookbook
        7.  Search for grocery
        8.  List groceries
        9.  List recipes
        10. List cookbooks
        11. List expired groceries
        12. List sorted groceries
        13. List groceries before date
        14. Suggest cookbook recipes
        15. Check recipe ingredients
        16. Exit
        """);
    int choice = getInt("Enter choice: ");
    System.out.println();
    return choice;
  }

  /** Close the scanner. */
  public void closeScanner() {
    scanner.close();
  }
}
