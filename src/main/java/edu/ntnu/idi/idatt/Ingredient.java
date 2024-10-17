package edu.ntnu.idi.idatt;

import java.util.Date;

// This class is responsible for the "Ingredient" object.
// It contains methods to get the price of the ingredient, check if it is expired, and a simple
// string representation of the ingredient.
public class Ingredient {

  String name; // Here I use String to represent the name of the ingredient.
  String unit; // Here I use String to represent the unit of the ingredient.
  int amount; // Here I use integer to represent the amount of the ingredient for simplicity.
  double pricePerUnit; // Here I use double to allow decimals.
  Date expirationDate; // Here I use date to make easy comparisons between dates.

  // For some reason google checkstyle does not like the constructor to be on the top :(
  public Ingredient(
      String name, String unit, int amount, double pricePerUnit, Date expirationDate) {
    this.name = name;
    this.unit = unit;
    this.amount = amount;
    this.pricePerUnit = pricePerUnit;
    this.expirationDate = expirationDate;
  }

  // Since the price is per unit we need to multiply it with the amount.
  public double getPrice() {
    return amount * pricePerUnit;
  }

  // This method is used to check if the ingredient is expired by comparing the expiration date with
  // the current date.
  public boolean isExpired() {
    Date currentDate = Main.getCurrentDate();
    return expirationDate.before(currentDate);
  }

  // This method is used for a simple string representation of the ingredient.
  // It uses StringBuilder to build the string.
  @Override
  public String toString() {
    return amount + " " + unit + " " + name;
  }
}
