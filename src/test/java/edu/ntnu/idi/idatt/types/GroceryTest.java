package edu.ntnu.idi.idatt.types;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

  // return String.format("%-15s %5.1f %-10s expires %s", name, amount, unit, formatter.format(expirationDate));
  /** Test the getFormattedString method */
  @Test
  public void testGetFormattedString() {
    String expected = String.format("%-15s %5.1f %-10s expires %s", "Milk", 2.0, "liter", "31/12/2023");
    assertEquals(expected, grocery.getFormattedString());
  }
}
