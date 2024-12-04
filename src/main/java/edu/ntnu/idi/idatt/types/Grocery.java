package edu.ntnu.idi.idatt.types;

import java.util.Date;

public class Grocery {
  public String name;
  public double amount;
  public Date expirationDate;
  private String unit;
  private double pricePerUnit;

  public Grocery(
      String name, String unit, double amount, double pricePerUnit, Date expirationDate) {
    this.name = name;
    this.unit = unit;
    this.amount = amount;
    this.pricePerUnit = pricePerUnit;
    this.expirationDate = expirationDate;
  }

  public void addAmount(double amount) {
    this.amount += amount;
  }

  public void removeAmount(double amount) {
    this.amount -= amount;
  }

  public boolean isExpired() {
    Date currentDate = new Date();
    return expirationDate.before(currentDate);
  }

  public double getPrice() {
    return amount * pricePerUnit;
  }

  public String getFormattedString() {
    return name + " " + amount + " " + unit;
  }

  @Override
  public String toString() {
    return name + ", " + unit + ", " + amount + ", " + pricePerUnit + ", " + expirationDate;
  }
}
