package edu.ntnu.idi.idatt.types;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/** Tests the recipe class */
public class RecipeTest {
  private Recipe recipe;
  private ArrayList<Ingredient> ingredients = new ArrayList<>();

  /** Set up the the ingredients and recipe for the tests */
  @BeforeEach
  public void setup() {
    ingredients.add(new Ingredient("Flour", "kg", 1));
    ingredients.add(new Ingredient("Sugar", "kg", 0.5));
    ingredients.add(new Ingredient("Egg", "pcs", 3));
    recipe = new Recipe("Cake", "Delicious cake", "Mix ingredients and bake", 4, ingredients);
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
        "Recipe: Cake | Delicious cake | Feeds: 4\n"
            + "\tIngredients: Flour 1,0 kg, Sugar 0,5 kg, Egg 3,0 pcs\n"
            + "\tInstructions: Mix ingredients and bake";
    assertEquals(expected, recipe.getFormattedString());
  }
}