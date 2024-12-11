package edu.ntnu.idi.idatt.types;

/** A class representing an ingredient. */
public class Ingredient {
  public String name;
  public String unit;
  public double amount;

  /**
   * Create a new ingredient.
   *
   * @param name the name of the ingredient
   * @param unit the unit of the ingredient
   * @param amount the amount of the ingredient
   */
  public Ingredient(String name, String unit, double amount) {
    this.name = name;
    this.unit = unit;
    this.amount = amount;
  }

  /**
   * Get a formatted string representation of the ingredient.
   *
   * @return the formatted string
   */
  public String getFormattedString() {
    return String.format("%s %.1f %s", name, amount, unit);
  }
}
