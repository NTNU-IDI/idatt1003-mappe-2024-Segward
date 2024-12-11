package edu.ntnu.idi.idatt.types;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/** Tests the recipe class */
public class RecipeTest {
  private Recipe recipe;
  private ArrayList<Ingredient> ingredients;

  /** Set up the the ingredients and recipe for the tests */
  @BeforeEach
  public void setup() {
    ArrayList<String> authors = new ArrayList<>();
    authors.add("John Doe");
    authors.add("Jane Doe");

    ingredients =
        new ArrayList<>(
            List.of(
                new Ingredient("Flour", "kg", 1),
                new Ingredient("Sugar", "kg", 0.5),
                new Ingredient("Egg", "pcs", 3)));

    recipe = new Recipe("Cake", "Delicious cake", "Mix ingredients and bake", ingredients, authors);
  }

  /** Test the recipe constructor */
  @Test
  public void testRecipeConstructor() {
    assertNotNull(recipe);
    assertEquals("Cake", recipe.name);
    assertEquals("Delicious cake", recipe.description);
    assertEquals("Mix ingredients and bake", recipe.instructions);
    assertEquals(ingredients, recipe.ingredients);
  }

  /** Test the getFormattedString method */
  @Test
  public void testGetFormattedString() {
    String expected =
        "\nRecipe: Cake\nDescription: Delicious cake\nIngredients:\n"
            + "\t-  Flour 1.0 kg\n"
            + "\t-  Sugar 0.5 kg\n"
            + "\t-  Egg 3.0 pcs\n"
            + "Instructions: Mix ingredients and bake"
            + "\nAuthors: John Doe, Jane Doe";
    assertEquals(expected, recipe.getFormattedString());
  }

  /**
   * Negative test the recipe constructor
   *
   * <p>Test the recipe constructor if the values are not as expected by checking false values
   */
  @Test
  public void negativeTestRecipeConstructor() {
    assertNotNull(recipe);
    assertNotEquals("cake", recipe.name); // changed to lowercase
    assertNotEquals("delicious cake", recipe.description); // changed to lowercase
    assertNotEquals("mix ingredients and bake", recipe.instructions); // changed to lowercase
    assertNotEquals(null, recipe.ingredients);
  }

  /**
   * Negative test the getFormattedString method
   *
   * <p>Test the getFormattedString method by adding an ingredient to the recipe and checking if the
   * expected string is not equal to the actual string
   */
  @Test
  public void negativeTestGetFormattedString() {
    recipe.ingredients.add(new Ingredient("Butter", "g", 200));
    String expected =
        "\nRecipe: Cake\nDescription: Delicious cake\nIngredients:\n"
            + "\t-  Flour 1.0 kg\n"
            + "\t-  Sugar 0.5 kg\n"
            + "\t-  Egg 3.0 pcs\n"
            + "Instructions: Mix ingredients and bake"
            + "\nAuthors: John Doe, Jane Doe";
    assertNotEquals(expected, recipe.getFormattedString());
  }
}