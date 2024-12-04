package edu.ntnu.idi.idatt.types;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class IngredientTest {

  @Test
  public void testGetFormattedStringPositive() {
    Ingredient ingredient = new Ingredient("Test", "kg", 1);
    assertEquals(
        "Test 1.0 kg",
        ingredient.getFormattedString(),
        "The formatted string should be 'Test 1.0 kg'.");
  }

  @Test
  public void testGetFormattedStringNegative() {
    Ingredient ingredient = new Ingredient("Test", "kg", 5);
    assertEquals(
        "Test 1.0 kg",
        ingredient.getFormattedString(),
        "The formatted string should be 'Test 1.0 kg'.");
  }
}
