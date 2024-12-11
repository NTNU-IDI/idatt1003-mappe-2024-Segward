package edu.ntnu.idi.idatt.types;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
    assertEquals("Flour 1,0 kg", ingredient.getFormattedString());
  }
}