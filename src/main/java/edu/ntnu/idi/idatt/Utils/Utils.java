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

public class Utils {

  private static Scanner scanner = new Scanner(System.in);
  private static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
  private Calendar calendar = Calendar.getInstance();

  public String getString(String prompt) {
    System.out.print(prompt);
    return scanner.nextLine();
  }

  public Date getDateDaysFromToday(int days) {
    calendar.setTime(new Date());
    calendar.add(Calendar.DATE, days);
    return calendar.getTime();
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
    return new Grocery(
        getString("Enter name: "),
        getString("Enter unit: "),
        getDouble("Enter amount: "),
        getDouble("Enter price per unit: "),
        getDate("Enter expiration date (dd/MM/yyyy): "));
  }

  public Ingredient getIngredient() {
    return new Ingredient(
        getString("Enter name: "), getString("Enter unit: "), getInt("Enter amount: "));
  }

  public ArrayList<Ingredient> getIngredients() {
    ArrayList<Ingredient> ingredients = new ArrayList<>();
    ingredients.add(getIngredient());
    while (scanner.nextLine().equalsIgnoreCase("y")) {
      ingredients.add(getIngredient());
      System.out.print("Add another ingredient? (y/n): ");
    }
    return ingredients;
  }

  public Recipe getRecipe() {
    return new Recipe(
        getString("Enter name: "),
        getString("Enter description: "),
        getString("Enter instructions: "),
        getIngredients());
  }

  public Cookbook getCookbook() {
    String name = getString("Enter name: ");
    return new Cookbook(name);
  }

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
    return getInt("Enter choice: ");
  }

  public void closeScanner() {
    scanner.close();
  }
}
