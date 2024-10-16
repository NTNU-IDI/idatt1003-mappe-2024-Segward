package edu.ntnu.idi.idatt;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MainTest {
  public static final String ANSI_RESET = "\u001B[0m";
  public static final String ANSI_GREEN = "\u001B[32m";
  public static final String ANSI_YELLOW = "\u001B[33m";
  public static final String ANSI_RED = "\u001B[31m";

  public static String start() {
    return ANSI_YELLOW + "[TEST] " + ANSI_RESET;
  }

  public static String success() {
    return ANSI_GREEN + " [SUCCESS] " + ANSI_RESET;
  }

  public static String fail() {
    return ANSI_RED + " [FAIL] " + ANSI_RESET;
  }

  public static String compare(boolean condition) {
    return condition ? success() : fail();
  }

  @Test
  public void testAdd() {
    Main main = new Main();
    int expected = 5;
    int actual = main.add(2, 3);
    // System.out.println(start() + "add(5, 0) " + "actual: " + actual + " expected: " + expected +
    // compare(expected == actual));
    assertEquals(expected, actual);
  }

  @Test
  public void testSubtract() {
    Main main = new Main();
    int expected = 5;
    int actual = main.subtract(10, 5);
    // System.out.println(start() + "subtract(10, 5) " + "actual: " + actual + " expected: " +
    // expected + compare(expected == actual));
    assertEquals(expected, actual);
  }
}