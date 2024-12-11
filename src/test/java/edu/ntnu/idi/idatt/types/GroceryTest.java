package edu.ntnu.idi.idatt.types;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/** Tests the grocery class */
public class GroceryTest {
  private Grocery grocery;
  private Date expirationDate;

  /**
   * Set up the grocery
   *
   * <p>The date format is used for creating dates used in the grocery class.
   */
  @BeforeEach
  public void setup() throws Exception {
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    expirationDate = dateFormat.parse("31/12/2023");
    grocery = new Grocery("Milk", "liter", 2.0, 1.5, expirationDate);
  }

  /** Test the grocery constructor */
  @Test
  public void testGroceryConstructor() {
    assertNotNull(grocery);
    assertEquals("Milk", grocery.name);
    assertEquals("liter", grocery.unit);
    assertEquals(2.0, grocery.amount);
    assertEquals(1.5, grocery.pricePerUnit);
    assertEquals(expirationDate, grocery.expirationDate);
  }

  /** Test setting the grocery amount */
  @Test
  public void testSetAmount() {
    grocery.setAmount(3.0);
    assertEquals(3.0, grocery.amount);
  }

  /** Test getting the price from the grocery */
  @Test
  public void testGetPrice() {
    assertEquals(3.0, grocery.getPrice());
  }

  /** Test the getFormattedString method */
  @Test
  public void testGetFormattedString() {
    String expected = "\nMilk 2.0 liter expires: Sun Dec 31 00:00:00 CET 2023";
    assertEquals(expected, grocery.getFormattedString());
  }

  /**
   * Negative test the grocery constructor
   *
   * <p>Test the grocery constructor if the values are not as expected by checking false values
   */
  @Test
  public void negativeTestGroceryConstructor() {
    assertNotNull(grocery);
    assertNotEquals("milk", grocery.name); // changed to lowercase
    assertEquals("liter", grocery.unit);
    assertEquals(2.0, grocery.amount);
    assertEquals(1.5, grocery.pricePerUnit);
    assertEquals(expirationDate, grocery.expirationDate);
  }

  /**
   * Negative test for setAmount
   *
   * <p>Test the setAmount method with a negative amount
   */
  @Test
  public void negativeTestSetAmount() {
    grocery.setAmount(-1.0);
    assertNotEquals(2.0, grocery.amount);
  }

  /**
   * Negative test for getPrice
   *
   * <p>Test the getPrice method with a negative price per unit
   */
  @Test
  public void negativeTestGetPrice() {
    grocery.pricePerUnit = -1.5;
    assertNotEquals(3.0, grocery.getPrice());
  }

  /**
   * Negative test for getFormattedString
   *
   * <p>Test the getFormattedString method with a null expiration date
   */
  @Test
  public void negativeTestGetFormattedString() {
    grocery.expirationDate = null;
    String expected = "\nMilk 2.0 liter expires: null";
    assertEquals(expected, grocery.getFormattedString());
  }
}
