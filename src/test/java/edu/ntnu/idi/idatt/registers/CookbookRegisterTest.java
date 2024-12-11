package edu.ntnu.idi.idatt.registers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import edu.ntnu.idi.idatt.types.Cookbook;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/** Tests the cookbook register class */
public class CookbookRegisterTest {
  private CookbookRegister cookbookRegister;
  private Cookbook cookbook1;
  private Cookbook cookbook2;

  /** Set up the cookbooks for the tests */
  @BeforeEach
  public void setup() {
    cookbookRegister = new CookbookRegister();
    cookbook1 = new Cookbook("Desserts");
    cookbook2 = new Cookbook("Breakfast");
  }

  /** Test the cookbook register constructor */
  @Test
  public void testAddCookbook() {
    cookbookRegister.add(cookbook1);
    assertEquals(1, cookbookRegister.cookbooks.size());
    assertEquals(cookbook1, cookbookRegister.cookbooks.get(0));

    cookbookRegister.add(cookbook2);
    assertEquals(2, cookbookRegister.cookbooks.size());
    assertEquals(cookbook2, cookbookRegister.cookbooks.get(1));
  }

  /** Test adding a cookbook with the same name as an existing cookbook */
  @Test
  public void testAddDuplicateCookbook() {
    cookbookRegister.add(cookbook1);
    assertThrows(IllegalArgumentException.class, () -> cookbookRegister.add(cookbook1));

    cookbookRegister.add(cookbook2);
    assertThrows(IllegalArgumentException.class, () -> cookbookRegister.add(cookbook2));
  }

  /** Test finding a cookbook by name */
  @Test
  public void testFindCookbook() {
    cookbookRegister.add(cookbook1);
    Cookbook foundCookbook = cookbookRegister.find("Desserts");
    assertNotNull(foundCookbook);
    assertEquals(cookbook1, foundCookbook);

    cookbookRegister.add(cookbook2);
    foundCookbook = cookbookRegister.find("Breakfast");
    assertNotNull(foundCookbook);
    assertEquals(cookbook2, foundCookbook);
  }

  /**
   * Negative test the add method
   *
   * <p>Test adding a null cookbook
   */
  @Test
  public void negativeTestAddCookbook() {
    assertThrows(NullPointerException.class, () -> cookbookRegister.add(null));
  }

  /**
   * Negative test the find method
   *
   * <p>Test finding a cookbook with no cookbooks in the register
   */
  @Test
  public void negativeTestFindCookbook() {
    Cookbook foundCookbook = cookbookRegister.find("Breakfast");
    assertEquals(null, foundCookbook);
  }
}