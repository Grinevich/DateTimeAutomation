package us.timeapi.tests;


import org.junit.Before;
import org.junit.Test;
import utilities.PropertiesLoader;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Locale;

import static org.junit.Assert.assertEquals;

public class TestsMondays
{
  private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy", Locale.ENGLISH);
  private Mondays test;

  @Before
  public void setup()
  {
    test = new Mondays();
  }

  @Test
  public void testMondays() throws Exception
  {

    System.out.println("Month not starting on Monday");
      assertEquals(Arrays.asList(LocalDate.of(2014, 2, 3),
              LocalDate.of(2014, 2, 10),
              LocalDate.of(2014, 2, 17),
              LocalDate.of(2014, 2, 24)),
              test.getMondays(2014, Month.FEBRUARY));
    System.out.format("Result: Months %s%n",test.getMondays(2014, Month.FEBRUARY));

    System.out.println("Month starting on Monday");
    assertEquals(Arrays.asList(LocalDate.of(2014, 9, 1),
              LocalDate.of(2014, 9, 8),
              LocalDate.of(2014, 9, 15),
              LocalDate.of(2014, 9, 22),
              LocalDate.of(2014, 9, 29)),
              test.getMondays(2014, Month.SEPTEMBER));
    System.out.format("Result: Months %s%n",test.getMondays(2014, Month.SEPTEMBER));
  }

}
