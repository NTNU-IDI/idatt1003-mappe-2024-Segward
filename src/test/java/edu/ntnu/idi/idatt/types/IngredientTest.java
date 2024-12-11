package edu.ntnu.idi.idatt.types;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/** Tests the ingredient class */
public class IngredientTest {
  private Ingredient ingredient;

  /** Set up the ingredient for the tests */
  @BeforeEach
  public void setup() {
    ingredient = new Ingredient("Flour", "kg", 1.0);
  }

  /** Test the ingredient constructor */
  @Test
  public void testIngredientConstructor() {
    assertNotNull(ingredient);
    assertEquals("Flour", ingredient.name);
    assertEquals("kg", ingredient.unit);
    assertEquals(1.0, ingredient.amount);
  }

  /** Test the getFormattedString method */
  @Test
  public void testGetFormattedString() {
    String expected = "Flour 1.0 kg";
    assertEquals(expected, ingredient.getFormattedString());
  }

  /**
   * Negative test the ingredient constructor
   *
   * <p>Test the ingredient constructor if the values are not as expected by checking false values
   */
  @Test
  public void negativeTestIngredientConstructor() {
    assertNotNull(ingredient);
    assertNotEquals("flour", ingredient.name); // changed to lowercase
    assertEquals("kg", ingredient.unit);
    assertEquals(1.0, ingredient.amount);
  }

  /**
   * Negative test the getFormattedString method
   *
   * <p>Test the getFormattedString method if the name is null
   */
  @Test
  public void negativeTestGetFormattedString() {
    ingredient.name = null;
    String expected = "Flour 1.0 kg";
    assertNotEquals(expected, ingredient.getFormattedString());
  }
}