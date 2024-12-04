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
    cookbook.add(recipe);
    assertEquals(1, cookbook.recipes.size(), "The size of the recipes list should be 1.");
  }

  @Test
  public void testSearchForRecipePositive() {
    Cookbook cookbook = new Cookbook("Test");
    ArrayList<Ingredient> ingredients = new ArrayList<>();
    Recipe recipe = new Recipe("Test", "Test", "Test", ingredients);
    cookbook.add(recipe);
    assertEquals(recipe, cookbook.find("Test"), "The recipe should be found.");
  }

  @Test
  public void testGetFormattedStringPositive() {
    Cookbook cookbook = new Cookbook("Test");
    ArrayList<Ingredient> ingredients = new ArrayList<>();
    Recipe recipe = new Recipe("Test", "Test", "Test", ingredients);
    cookbook.add(recipe);
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
  public void testAddRecipeNegative() {
    Cookbook cookbook = new Cookbook("Test");
    ArrayList<Ingredient> ingredients = new ArrayList<>();
    Recipe recipe = new Recipe("Test", "Test", "Test", ingredients);
    cookbook.add(recipe);
    assertEquals(1, cookbook.recipes.size(), "The size of the recipes list should be 1.");
  }

  @Test
  public void testSearchForRecipeNegative() {
    Cookbook cookbook = new Cookbook("Test");
    ArrayList<Ingredient> ingredients = new ArrayList<>();
    Recipe recipe = new Recipe("Test", "Test", "Test", ingredients);
    cookbook.add(recipe);
    assertEquals(recipe, cookbook.find("Test"), "The recipe should be found.");
  }

  @Test
  public void testGetFormattedStringNegative() {
    Cookbook cookbook = new Cookbook("Test");
    ArrayList<Ingredient> ingredients = new ArrayList<>();
    Recipe recipe = new Recipe("Test", "Test", "Test", ingredients);
    cookbook.add(recipe);
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
}
