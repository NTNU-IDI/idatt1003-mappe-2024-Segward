package edu.ntnu.idi.idatt.types;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;

public class RecipeTest {

  @Test
  public void testGetFormattedStringPositive() {
    Ingredient ingredient = new Ingredient("Test", "kg", 1);
    ArrayList<Ingredient> ingredients = new ArrayList<>();
    ingredients.add(ingredient);
    Recipe recipe = new Recipe("Test", "Test", "Test", ingredients);
    assertEquals(
        "Recipe: Test\nDescription: Test\nIngredients:\n\t-  Test 1.0 kg\nInstructions: Test",
        recipe.getFormattedString(),
        "The formatted string should be 'Recipe: Test\n"
            + "Description: Test\n"
            + "Ingredients:\n"
            + "\t-  Test 1.0 kg\n"
            + "Instructions: Test'.");
  }

  @Test
  public void testGetFormattedStringNegative() {
    Ingredient ingredient = new Ingredient("Test", "kg", 5);
    ArrayList<Ingredient> ingredients = new ArrayList<>();
    ingredients.add(ingredient);
    Recipe recipe = new Recipe("Test", "Test", "Test", ingredients);
    assertEquals(
        "Recipe: Test\nDescription: Test\nIngredients:\n\t-  Test 1.0 kg\nInstructions: Test",
        recipe.getFormattedString(),
        "The formatted string should be 'Recipe: Test\n"
            + "Description: Test\n"
            + "Ingredients:\n"
            + "\t-  Test 1.0 kg\n"
            + "Instructions: Test'.");
  }
}
