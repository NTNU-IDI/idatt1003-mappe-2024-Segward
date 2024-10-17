package edu.ntnu.idi.idatt;

public class Ingredient {
  String name;
  String unit;
  int amount;

  public Ingredient(String name, String unit, int amount) {
    this.name = name;
    this.unit = unit;
    this.amount = amount;
  }

  @Override
  public String toString() {
    return amount + " " + unit + " " + name;
  }
}
