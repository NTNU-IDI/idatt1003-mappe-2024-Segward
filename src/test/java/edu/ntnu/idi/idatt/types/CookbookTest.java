package edu.ntnu.idi.idatt.types;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/** Tests the cookbook class */
public class CookbookTest {
  private Cookbook cookbook;
  private Recipe recipe1;
  private Recipe recipe2;

  /** Set up the ingredients for the recipes and create a cookbook */
  @BeforeEach
  public void setup() {
    cookbook = new Cookbook("Desserts");
    ArrayList<String> authors = new ArrayList<>();
    authors.add("John Doe");

    ArrayList<Ingredient> ingredients1 = new ArrayList<>();
    ingredients1.add(new Ingredient("Flour", "kg", 1));
    ingredients1.add(new Ingredient("Sugar", "kg", 0.5));
    ingredients1.add(new Ingredient("Egg", "pcs", 3));
    recipe1 = new Recipe("Cake", "Delicious cake", "Mix ingredients and bake", ingredients1, authors);

    ArrayList<Ingredient> ingredients2 = new ArrayList<>();
    ingredients2.add(new Ingredient("Milk", "liter", 1));
    ingredients2.add(new Ingredient("Sugar", "kg", 0.5));
    ingredients2.add(new Ingredient("Egg", "pcs", 2));
    recipe2 = new Recipe("Pancake", "Delicious pancake", "Mix ingredients and fry", ingredients2, authors);
  }

  /** Test the cookbook constructor */
  @Test
  public void testCookbookConstructor() {
    assertNotNull(cookbook);
    assertEquals("Desserts", cookbook.name);
  }

  /** Test the add method in the cookbook class */
  @Test
  public void testAddRecipe() {
    cookbook.add(recipe1);
    assertEquals(1, cookbook.recipes.size());
    assertEquals(recipe1, cookbook.recipes.get(0));
  }

  /** Test finding a recipe by name */
  @Test
  public void testFindRecipe() {
    cookbook.add(recipe1);
    Recipe foundRecipe = cookbook.find("Cake");
    assertNotNull(foundRecipe);
    assertEquals(recipe1, foundRecipe);
  }

  /** Test the getFormattedString method */
  @Test
  public void testGetFormattedString() {
    cookbook.add(recipe1);
    cookbook.add(recipe2);
    String expected =
        "\nCookbook: Desserts\n"
            + recipe1.getFormattedString()
            + "\n"
            + recipe2.getFormattedString();
    assertEquals(expected, cookbook.getFormattedString());
  }

  /** Test adding a recipe with the same name as an existing recipe */
  @Test
  public void testAddDuplicateRecipe() {
    cookbook.add(recipe1);
    assertThrows(IllegalArgumentException.class, () -> cookbook.add(recipe1));
  }

  /**
   * Negative test the cookbook constructor
   *
   * <p>Test the cookbook constructor if the values are not as expected by checking false values
   */
  @Test
  public void negativeTestCookbookConstructor() {
    assertNotNull(cookbook);
    assertNotEquals("desserts", cookbook.name); // changed to lowercase
  }

  /**
   * Negative test the add method
   *
   * <p>Test the add method if the values are not as expected by checking false values
   */
  @Test
  public void negativeTestAddRecipe() {
    assertEquals(0, cookbook.recipes.size());
    cookbook.add(recipe1);
    assertNotEquals(0, cookbook.recipes.size());
    assertNotEquals(recipe2, cookbook.recipes.get(0));
  }

  /**
   * Negative test the find method
   *
   * <p>Test the find method if the values are not as expected by checking false values
   */
  @Test
  public void negativeTestFindRecipe() {
    cookbook.add(recipe1);
    Recipe foundRecipe = cookbook.find("cake");
    assertNull(foundRecipe);
    assertNotEquals(recipe1, foundRecipe);
  }

  /**
   * Negative test the getFormattedString method
   *
   * <p>Test the getFormattedString method if the cookbook name is null
   */
  @Test
  public void negativeTestGetFormattedString() {
    cookbook.add(recipe1);
    cookbook.add(recipe2);
    cookbook.name = null;
    String expected =
        "\nCookbook: Desserts\n"
            + recipe1.getFormattedString()
            + "\n"
            + recipe2.getFormattedString();
    assertNotEquals(expected, cookbook.getFormattedString());
  }
}