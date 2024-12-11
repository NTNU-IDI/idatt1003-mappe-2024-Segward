package edu.ntnu.idi.idatt.types;

import java.text.SimpleDateFormat;
import java.util.Date;

/** A class representing a grocery item. */
public class Grocery {
  public final String name;
  public final Date expirationDate;
  private final String unit;
  private final double pricePerUnit;
  public double amount;
  SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

  /**
   * Create a new grocery item.
   *
   * @param name the name of the grocery item
   * @param unit the unit of the grocery item
   * @param amount the amount of the grocery item
   * @param pricePerUnit the price per unit of the grocery item
   * @param expirationDate the expiration date of the grocery item
   */
  public Grocery(
      String name, String unit, double amount, double pricePerUnit, Date expirationDate) {
    this.name = name;
    this.unit = unit;
    this.amount = amount;
    this.pricePerUnit = pricePerUnit;
    this.expirationDate = expirationDate;
  }

  /**
   * Set the amount of the grocery item.
   *
   * @param amount
   */
  public void setAmount(double amount) {
    this.amount = amount;
  }

  /**
   * Get the price of the grocery item.
   *
   * @return the price of the grocery item, which is the amount multiplied by the price per unit
   */
  public double getPrice() {
    return amount * pricePerUnit;
  }

  /**
   * Get a formatted string representation of the grocery item.
   *
   * @return the formatted string
   */
  public String getFormattedString() {
    return String.format("%-15s %5.1f %-10s expires %s", name, amount, unit, formatter.format(expirationDate));
  }
}
