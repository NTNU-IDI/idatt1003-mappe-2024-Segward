package edu.ntnu.idi.idatt.types;

import java.util.Date;

/**
 * Represents a grocery with a name, unit, amount, price per unit and expiration date.
 *
 * @version 1.1
 * @since 1.0
 */
public class Grocery {
  private String name;
  private String unit;
  private int amount;
  private double pricePerUnit;
  private Date expirationDate;

  /**
   * Creates a new recipe with the specified name, unit, amount, price per unit and expiration date.
   *
   * @param name the name of the recipe
   * @param unit the unit of the recipe
   * @param amount the amount of the recipe
   * @param pricePerUnit the price per unit of the recipe
   * @param expirationDate the expiration date of the recipe
   */
  public Grocery(String name, String unit, int amount, double pricePerUnit, Date expirationDate) {
    this.name = name;
    this.unit = unit;
    this.amount = amount;
    this.pricePerUnit = pricePerUnit;
    this.expirationDate = expirationDate;
  }

  /**
   * Adds an amount to the grocery.
   *
   * @param amount the amount to add
   */
  public void addAmount(int amount) {
    this.amount += amount;
  }

  /**
   * Returns the name of the grocery.
   *
   * @return the name of the grocery
   */
  public String getName() {
    return name;
  }

  /**
   * Returns the amount of the grocery.
   *
   * @return the amount of the grocery
   */
  public int getAmount() {
    return amount;
  }

  /**
   * Checks if current date is before the expiration date.
   *
   * @return true if the grocery is expired, false otherwise
   */
  public boolean isExpired() {
    Date currentDate = new Date();
    return expirationDate.before(currentDate);
  }

  /**
   * Calculates the total price of the grocery.
   *
   * @return the total price of the grocery
   */
  public double getPrice() {
    return amount * pricePerUnit;
  }

  /**
   * Used for printing to the end user.
   *
   * @return a string with amount, unit and name
   */
  public String getFormattedString() {
    return amount + " " + unit + " " + name;
  }

  /**
   * Used for debugging and data representation.
   *
   * @return a string with all fields of the grocery item
   */
  @Override
  public String toString() {
    return name + ", " + unit + ", " + amount + ", " + pricePerUnit + ", " + expirationDate;
  }
}
