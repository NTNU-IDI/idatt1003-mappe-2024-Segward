package edu.ntnu.idi.idatt;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class MainTest {

  @Test
  public void testAdd() {
    Main main = new Main();
    int expected = 5;
    int actual = main.add(2, 3);
    assertEquals(expected, actual);
  }

  @Test
  public void testSubtract() {
    Main main = new Main();
    int expected = 5;
    int actual = main.subtract(10, 5);
    assertEquals(expected, actual);
  }

  @Test
  public void testMain() {
    Main.main(new String[] {});
  }

}