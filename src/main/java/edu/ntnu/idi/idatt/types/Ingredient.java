package edu.ntnu.idi.idatt.types;

public class Ingredient {
  public String name;
  private String unit;
  public double amount;

  public Ingredient(String name, String unit, double amount) {
    this.name = name;
    this.unit = unit;
    this.amount = amount;
  }

  public String getFormattedString() {
    return amount + " " + unit + " " + name;
  }

  @Override
  public String toString() {
    return name + ", " + unit + ", " + amount;
  }
}
