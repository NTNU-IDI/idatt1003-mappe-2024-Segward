package edu.ntnu.idi.idatt;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MainTest {
  @Test
  public void testAdd() {
    Main main = new Main();
    assertEquals(5, main.add(5, 0));
  }

  @Test
  public void testSubtract() {
    Main main = new Main();
    assertEquals(5, main.subtract(10, 5));
  }
}