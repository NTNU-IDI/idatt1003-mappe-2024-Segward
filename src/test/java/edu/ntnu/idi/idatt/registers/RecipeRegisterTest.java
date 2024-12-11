package edu.ntnu.idi.idatt.registers;

import static org.junit.jupiter.api.Assertions.*;

import edu.ntnu.idi.idatt.types.Ingredient;
import edu.ntnu.idi.idatt.types.Recipe;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/** Tests the recipe register class */
public class RecipeRegisterTest {
  private RecipeRegister recipeRegister;
  private Recipe recipe1;
  private Recipe recipe2;

  /** Set up the ingredients for the recipes and create a recipe register */
  @BeforeEach
  public void setup() {
    recipeRegister = new RecipeRegister();

    ArrayList<Ingredient> ingredients1 = new ArrayList<>();
    ingredients1.add(new Ingredient("Flour", "kg", 1));
    ingredients1.add(new Ingredient("Sugar", "kg", 0.5));
    ingredients1.add(new Ingredient("Egg", "pcs", 3));
    recipe1 = new Recipe("Cake", "Delicious cake", "Mix ingredients and bake", ingredients1);

    ArrayList<Ingredient> ingredients2 = new ArrayList<>();
    ingredients2.add(new Ingredient("Milk", "liter", 1));
    ingredients2.add(new Ingredient("Sugar", "kg", 0.5));
    ingredients2.add(new Ingredient("Egg", "pcs", 2));
    recipe2 = new Recipe("Pancake", "Delicious pancake", "Mix ingredients and fry", ingredients2);
  }

  /** Test adding a recipe to the register */
  @Test
  public void testAddRecipe() {
    recipeRegister.add(recipe1);
    assertEquals(1, recipeRegister.recipes.size());
    assertEquals(recipe1, recipeRegister.recipes.get(0));

    recipeRegister.add(recipe2);
    assertEquals(2, recipeRegister.recipes.size());
    assertEquals(recipe2, recipeRegister.recipes.get(1));
  }

  /** Test adding a recipe with the same name as an existing recipe */
  @Test
  public void testAddDuplicateRecipe() {
    recipeRegister.add(recipe1);
    assertThrows(IllegalArgumentException.class, () -> recipeRegister.add(recipe1));

    recipeRegister.add(recipe2);
    assertThrows(IllegalArgumentException.class, () -> recipeRegister.add(recipe2));
  }

  /** Test finding a recipe by name */
  @Test
  public void testFindRecipe() {
    recipeRegister.add(recipe1);
    recipeRegister.add(recipe2);

    Recipe foundRecipe = recipeRegister.find("Cake");
    assertNotNull(foundRecipe);
    assertEquals(recipe1, foundRecipe);

    foundRecipe = recipeRegister.find("Pancake");
    assertNotNull(foundRecipe);
    assertEquals(recipe2, foundRecipe);
  }

  /** Test finding a recipe that does not exist */
  @Test
  public void TestFindRecipe() {
    Recipe foundRecipe = recipeRegister.find("NonExistent");
    assertNull(foundRecipe);
  }

  /**
   * Negative test the add method
   *
   * <p>Test adding a null recipe
   */
  @Test
  public void negativeTestAddRecipe() {
    assertThrows(NullPointerException.class, () -> recipeRegister.add(null));
  }

  /**
   * Negative test the find method
   *
   * <p>Test finding a recipe by name but the recipe register is empty
   */
  @Test
  public void negativeTestFindRecipe2() {
    Recipe foundRecipe = recipeRegister.find("Pancake");
    assertNull(foundRecipe);
  }
}