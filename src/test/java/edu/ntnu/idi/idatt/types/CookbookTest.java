package edu.ntnu.idi.idatt.types;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class CookbookTest {

  @Test
  public void testAddRecipePositive() {
    Cookbook cookbook = new Cookbook("Test");
    ArrayList<Ingredient> ingredients = new ArrayList<>();
    Recipe recipe = new Recipe("Test", "Test", "Test", ingredients);
    cookbook.addRecipe(recipe);
    assertEquals(1, cookbook.recipes.size(), "The size of the recipes list should be 1.");
  }

  @Test
  public void testSearchForRecipePositive() {
    Cookbook cookbook = new Cookbook("Test");
    ArrayList<Ingredient> ingredients = new ArrayList<>();
    Recipe recipe = new Recipe("Test", "Test", "Test", ingredients);
    cookbook.addRecipe(recipe);
    assertEquals(recipe, cookbook.searchForRecipe("Test"), "The recipe should be found.");
  }

  @Test
  public void testGetFormattedStringPositive() {
    Cookbook cookbook = new Cookbook("Test");
    ArrayList<Ingredient> ingredients = new ArrayList<>();
    Recipe recipe = new Recipe("Test", "Test", "Test", ingredients);
    cookbook.addRecipe(recipe);
    assertEquals(
        "Cookbook: Test\n\nRecipe: Test\nDescription: Test\nIngredients:\nInstructions: Test\n",
        cookbook.getFormattedString(),
        "The formatted string should be 'Cookbook: Test\n\n"
            + "Recipe: Test\n"
            + "Description: Test\n"
            + "Ingredients:\n"
            + "Instructions: Test\n"
            + "'.");
  }

  @Test
  public void testToStringPositive() {
    Cookbook cookbook = new Cookbook("Test");
    ArrayList<Ingredient> ingredients = new ArrayList<>();
    Recipe recipe = new Recipe("Test", "Test", "Test", ingredients);
    cookbook.addRecipe(recipe);
    assertEquals("Test, Test", cookbook.toString(), "The string should be 'Test, Test'.");
  }

  @Test
  public void testAddRecipeNegative() {
    Cookbook cookbook = new Cookbook("Test");
    ArrayList<Ingredient> ingredients = new ArrayList<>();
    Recipe recipe = new Recipe("Test", "Test", "Test", ingredients);
    cookbook.addRecipe(recipe);
    assertEquals(1, cookbook.recipes.size(), "The size of the recipes list should be 1.");
  }

  @Test
  public void testSearchForRecipeNegative() {
    Cookbook cookbook = new Cookbook("Test");
    ArrayList<Ingredient> ingredients = new ArrayList<>();
    Recipe recipe = new Recipe("Test", "Test", "Test", ingredients);
    cookbook.addRecipe(recipe);
    assertEquals(recipe, cookbook.searchForRecipe("Test"), "The recipe should be found.");
  }

  @Test
  public void testGetFormattedStringNegative() {
    Cookbook cookbook = new Cookbook("Test");
    ArrayList<Ingredient> ingredients = new ArrayList<>();
    Recipe recipe = new Recipe("Test", "Test", "Test", ingredients);
    cookbook.addRecipe(recipe);
    assertEquals(
        "Cookbook: Test\n\nRecipe: Test\nDescription: Test\nIngredients:\nInstructions: Test\n",
        cookbook.getFormattedString(),
        "The formatted string should be 'Cookbook: Test\n\n"
            + "Recipe: Test\n"
            + "Description: Test\n"
            + "Ingredients:\n"
            + "Instructions: Test\n"
            + "'.");
  }

  @Test
  public void testToStringNegative() {
    Cookbook cookbook = new Cookbook("Test");
    ArrayList<Ingredient> ingredients = new ArrayList<>();
    Recipe recipe = new Recipe("Test", "Test", "Test", ingredients);
    cookbook.addRecipe(recipe);
    assertEquals("Test, Test", cookbook.toString(), "The string should be 'Test, Test'.");
  }
}
