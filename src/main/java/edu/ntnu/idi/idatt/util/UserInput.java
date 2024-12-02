package edu.ntnu.idi.idatt.util;

import java.util.Date;
import java.util.Scanner;
import java.text.SimpleDateFormat;

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
}
