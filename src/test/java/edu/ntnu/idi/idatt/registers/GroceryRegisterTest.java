package edu.ntnu.idi.idatt.registers;

import static org.junit.jupiter.api.Assertions.*;

import edu.ntnu.idi.idatt.types.Grocery;
import edu.ntnu.idi.idatt.types.Ingredient;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/** Tests the grocery register class */
public class GroceryRegisterTest {
  private GroceryRegister groceryRegister;
  private Grocery grocery1;
  private Grocery grocery2;
  private Grocery grocery3;
  private Date pastDate;
  private Date futureDate;

  /** Set up the groceries and grocery register for the tests */
  @BeforeEach
  public void setup() throws Exception {
    groceryRegister = new GroceryRegister();
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    pastDate = dateFormat.parse("01/01/2000");
    futureDate = dateFormat.parse("01/01/9999");

    grocery1 = new Grocery("Milk", "liter", 2.0, 1.5, futureDate);
    grocery2 = new Grocery("Egg", "pcs", 12.0, 0.2, pastDate);
    grocery3 = new Grocery("Butter", "kg", 1.0, 5.0, futureDate);
  }

  /** Test adding a grocery to the register */
  @Test
  public void testAddGrocery() {
    groceryRegister.add(grocery1);

    assertEquals(1, groceryRegister.groceries.size());
    assertEquals(grocery1, groceryRegister.groceries.get(0));
  }

  /** Test adding a grocery with the same name as an existing grocery */
  @Test
  public void testRemoveGrocery() {
    groceryRegister.add(grocery1);
    groceryRegister.remove(grocery1);

    assertEquals(0, groceryRegister.groceries.size());
  }

  /** Test getting the expired groceries */
  @Test
  public void testGetExpired() {
    groceryRegister.add(grocery1);
    groceryRegister.add(grocery2);

    List<Grocery> expiredGroceries = groceryRegister.getExpired();

    assertEquals(1, expiredGroceries.size());
    assertEquals(grocery2, expiredGroceries.get(0));
  }

  /** Test getting the groceries before a specific date */
  @Test
  public void testGetGroceriesBeforeDate() {
    groceryRegister.add(grocery1);
    groceryRegister.add(grocery2);

    List<Grocery> groceriesBeforeDate = groceryRegister.getGroceriesBeforeDate(futureDate);

    assertEquals(1, groceriesBeforeDate.size());
    assertEquals(grocery2, groceriesBeforeDate.get(0));
  }

  /** Test getting the groceries sorted by name */
  @Test
  public void testGetSorted() {
    groceryRegister.add(grocery1);
    groceryRegister.add(grocery2);
    groceryRegister.add(grocery3);

    List<Grocery> sortedGroceries = groceryRegister.getSorted();

    assertEquals(3, sortedGroceries.size());
    assertEquals(grocery3, sortedGroceries.get(0)); // Butter
    assertEquals(grocery2, sortedGroceries.get(1)); // Egg
    assertEquals(grocery1, sortedGroceries.get(2)); // Milk
  }

  /** Test checking if the register has sufficient ingredients */
  @Test
  public void testHasSufficientIngredients() {
    groceryRegister.add(grocery1);
    groceryRegister.add(grocery2);
    groceryRegister.add(grocery3);

    ArrayList<Ingredient> ingredients = new ArrayList<>();
    ingredients.add(new Ingredient("Milk", "liter", 1.0));
    ingredients.add(new Ingredient("Egg", "pcs", 6.0));

    assertTrue(groceryRegister.hasSufficientIngredients(ingredients));
  }

  /** Test checking if the register doesnt have sufficient ingredients */
  @Test
  public void testHasInsufficientIngredients() {
    groceryRegister.add(grocery1);
    groceryRegister.add(grocery2);
    groceryRegister.add(grocery3);

    ArrayList<Ingredient> ingredients = new ArrayList<>();
    ingredients.add(new Ingredient("Milk", "liter", 1.0));
    ingredients.add(new Ingredient("Egg", "pcs", 20.0));

    assertFalse(groceryRegister.hasSufficientIngredients(ingredients));
  }

  /**
   * Negative test the add grocery method
   *
   * <p>Test adding a null grocery
   */
  @Test
  public void negativeTestAddGrocery() {
    assertThrows(NullPointerException.class, () -> groceryRegister.add(null));
  }

  /**
   * Negative test the remove grocery method
   *
   * <p>Test removing a null grocery
   */
  @Test
  public void negativeTestRemoveGrocery() {
    assertThrows(NullPointerException.class, () -> groceryRegister.remove(null));
  }

  /**
   * Negative test the find method
   *
   * <p>Test finding a grocery by name but the grocery register is empty
   */
  @Test
  public void negativeTestFindGrocery() {
    Grocery foundGrocery = groceryRegister.find("milk");
    assertNull(foundGrocery);
  }
}