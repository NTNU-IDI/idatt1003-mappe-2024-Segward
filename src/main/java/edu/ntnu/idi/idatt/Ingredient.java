package edu.ntnu.idi.idatt;

import java.util.Date;

public class Ingredient {
  String name;
  String unit;
  int amount;
  double pricePerUnit;
  Date expirationDate;

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
  @Override
  public String toString() {
    return amount + " " + unit + " " + name;
  }
}
