package edu.ntnu.idi.idatt.utils;

import static org.junit.jupiter.api.Assertions.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests the utils class
 *
 * <p>The utils test contains several user input methods which are ignored in this test. Instead, we
 * focus on the methods that don't require user input.
 */
public class UtilsTest {
  private Utils utils;
  private SimpleDateFormat dateFormat;

  /**
   * Set up the utils before each test.
   *
   * <p>The date format is used for creating test dates that are used in the tests to compare with
   * the results.
   */
  @BeforeEach
  public void setup() {
    utils = new Utils();
    dateFormat = new SimpleDateFormat("dd/MM/yyyy");
  }

  /**
   * Test the getFutureDate method of the utils class.
   *
   * <p>This test checks that the future date is after the current date.
   */
  @Test
  public void testGetFutureDate() throws Exception {
    Date currentDate = new Date();
    Date futureDate = utils.getFutureDate(10);
    assertNotNull(futureDate);
    assertTrue(futureDate.after(currentDate), "Future date should be after the current date");
  }

  /**
   * Test the getPastDate method of the utils class.
   *
   * <p>This test checks that the past date is before the current date.
   */
  @Test
  public void testGetPastDate() throws Exception {
    Date currentDate = new Date();
    Date pastDate = utils.getPastDate(10);
    assertNotNull(pastDate);
    assertTrue(pastDate.before(currentDate), "Past date should be before the current date");
  }

  /**
   * Test the resetTime method of the utils class.
   *
   * <p>This test checks that the time of the date is reset to 00:00:00.000.
   */
  @Test
  public void testResetTime() throws Exception {
    SimpleDateFormat dateTimeFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    Date currentDate = dateTimeFormat.parse("01/01/2022 15:30:45");
    Date expectedDate = dateTimeFormat.parse("01/01/2022 00:00:00");
    Date resetDate = utils.resetTime(currentDate);
    assertNotNull(resetDate);
    assertEquals(dateFormat.format(expectedDate), dateFormat.format(resetDate));
  }
}