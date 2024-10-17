package edu.ntnu.idi.idatt;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class MainTest {

  // Test if the expiration date is correct
  @Test
  public void testExpirationDate() {
    Ingredient egg = new Ingredient("Egg", "stk", 12, 2.5, Main.getFutureDate(5));
    assertEquals(false, egg.isExpired());

    Ingredient milk = new Ingredient("Milk", "liter", 3, 20, Main.getPreviousDate(4));
    assertEquals(true, milk.isExpired());
  }

  // Test if the price is correct
  @Test
  public void testPrice() {
    Ingredient egg = new Ingredient("Egg", "stk", 12, 2.5, Main.getFutureDate(5));
    assertEquals(30.0, egg.getPrice());

    Ingredient milk = new Ingredient("Milk", "liter", 3, 20, Main.getPreviousDate(4));
    assertEquals(60.0, milk.getPrice());
  }
}