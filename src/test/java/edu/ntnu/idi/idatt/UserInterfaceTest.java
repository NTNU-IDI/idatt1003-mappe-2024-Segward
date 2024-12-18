package edu.ntnu.idi.idatt;

import static org.junit.jupiter.api.Assertions.*;

import edu.ntnu.idi.idatt.registers.CookbookRegister;
import edu.ntnu.idi.idatt.registers.GroceryRegister;
import edu.ntnu.idi.idatt.registers.RecipeRegister;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test class for the UserInterface class.
 *
 * <p>This class tests the methods that don't need user input from the utils class.
 */
public class UserInterfaceTest {
  private UserInterface userInterface;

  /** Set up the user interface before each test. */
  @BeforeEach
  public void setup() {
    userInterface = new UserInterface();
  }

  /** Test the init method of user interface */
  @Test
  public void testInit() {
    userInterface.init();
    assertNotNull(userInterface.groceryRegister);
    assertNotNull(userInterface.cookbookRegister);
    assertNotNull(userInterface.recipeRegister);
  }

  /** Test the addSampleGroceries method of user interface */
  @Test
  public void testAddSampleGroceries() {
    userInterface.groceryRegister = new GroceryRegister();
    userInterface.addSampleGroceries();
    assertFalse(userInterface.groceryRegister.groceries.isEmpty());
  }

  /** Test the addSampleRecipes method of user interface */
  @Test
  public void testAddSampleRecipes() {
    userInterface.recipeRegister = new RecipeRegister();
    userInterface.addSampleRecipes();
    assertFalse(userInterface.recipeRegister.recipes.isEmpty());
  }

  /** Test the addSampleCookbooks method of user interface */
  @Test
  public void testAddSampleCookbooks() {
    userInterface.cookbookRegister = new CookbookRegister();
    userInterface.recipeRegister = new RecipeRegister();
    userInterface.addSampleRecipes();
    userInterface.addSampleCookbooks();
    assertFalse(userInterface.cookbookRegister.cookbooks.isEmpty());
  }

  /**
   * Negative test
   *
   * <p>Test adding samples when the registers are null. This should throw a NullPointerException.
   */
  @Test
  public void testAddSamplesWithNullRegisters() {
    userInterface.groceryRegister = null;
    userInterface.recipeRegister = null;
    userInterface.cookbookRegister = null;
    assertThrows(NullPointerException.class, () -> userInterface.addSampleRecipes());
    assertThrows(NullPointerException.class, () -> userInterface.addSampleGroceries());
    assertThrows(NullPointerException.class, () -> userInterface.addSampleCookbooks());
  }
}