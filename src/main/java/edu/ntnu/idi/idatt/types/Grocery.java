package edu.ntnu.idi.idatt.types;

import java.util.Date;

public class Grocery {
  public String name;
  private String unit;
  public int amount;
  private double pricePerUnit;
  public Date expirationDate;

  public Grocery(String name, String unit, int amount, double pricePerUnit, Date expirationDate) {
    this.name = name;
    this.unit = unit;
    this.amount = amount;
    this.pricePerUnit = pricePerUnit;
    this.expirationDate = expirationDate;
  }

  public void addAmount(int amount) {
    this.amount += amount;
  }

  public void removeAmount(int amount) {
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
    return amount + " " + unit + " " + name;
  }

  @Override
  public String toString() {
    return name + ", " + unit + ", " + amount + ", " + pricePerUnit + ", " + expirationDate;
  }
}
