package edu.ntnu.idi.idatt.types;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;
import org.junit.jupiter.api.Test;

public class GroceryTest {

  @Test
  public void testAddAmountPositive() {
    Grocery grocery = new Grocery("Test", "kg", 1, 1, null);
    grocery.addAmount(1);
    assertEquals(2, grocery.amount, "The amount should be 2 after adding 1.");
  }

  @Test
  public void testRemoveAmountPositive() {
    Grocery grocery = new Grocery("Test", "kg", 2, 1, null);
    grocery.removeAmount(1);
    assertEquals(1, grocery.amount, "The amount should be 1 after removing 1.");
  }

  @Test
  public void testIsExpiredPositive() {
    Date currentDate = new Date();
    Date expirationDate = new Date(currentDate.getTime() - 1000);
    Grocery grocery = new Grocery("Test", "kg", 1, 1, expirationDate);
    assertTrue(grocery.isExpired(), "The grocery should be expired.");
  }

  @Test
  public void testGetPricePositive() {
    Grocery grocery = new Grocery("Test", "kg", 3, 1, null);
    assertEquals(3, grocery.getPrice(), "The price should be 3.");
  }

  @Test
  public void testGetFormattedStringPositive() {
    Grocery grocery = new Grocery("Test", "kg", 1, 1, null);
    assertEquals(
        "Test 1.0 kg",
        grocery.getFormattedString(),
        "The formatted string should be 'Test 1.0 kg'.");
  }

  @Test
  public void testToStringPositive() {
    Date expirationDate = new Date();
    Grocery grocery = new Grocery("Test", "kg", 1, 1, expirationDate);
    assertEquals(
        "Test, kg, 1.0, 1.0, " + expirationDate,
        grocery.toString(),
        "The string should be 'Test, kg, 1.0, 1.0, " + expirationDate + "'.");
  }

  @Test
  public void testAddAmountNegative() {
    Grocery grocery = new Grocery("Test", "kg", 1, 1, null);
    grocery.addAmount(100);
    assertEquals(2, grocery.amount, "The amount should be 2 after adding 1.");
  }

  @Test
  public void testRemoveAmountNegative() {
    Grocery grocery = new Grocery("Test", "kg", 10, 1, null);
    grocery.removeAmount(1);
    assertEquals(1, grocery.amount, "The amount should be 1 after removing 1.");
  }

  @Test
  public void testIsExpiredNegative() {
    Date currentDate = new Date();
    Date expirationDate = new Date(currentDate.getTime() + 1000);
    Grocery grocery = new Grocery("Test", "kg", 1, 1, expirationDate);
    assertTrue(grocery.isExpired(), "The grocery should be expired.");
  }

  @Test
  public void testGetPriceNegative() {
    Grocery grocery = new Grocery("Test", "kg", 2, 1, null);
    assertEquals(3, grocery.getPrice(), "The price should be 3.");
  }

  @Test
  public void testGetFormattedStringNegative() {
    Grocery grocery = new Grocery("Test", "kg", 3, 1, null);
    assertEquals(
        "Test 1.0 kg",
        grocery.getFormattedString(),
        "The formatted string should be 'Test 1.0 kg'.");
  }

  @Test
  public void testToStringNegative() {
    Date expirationDate = new Date();
    Grocery grocery = new Grocery("Test", "kg", 5, 1, expirationDate);
    assertEquals(
        "Test, kg, 1.0, 1.0, " + expirationDate,
        grocery.toString(),
        "The string should be 'Test, kg, 1.0, 1.0, " + expirationDate + "'.");
  }
}