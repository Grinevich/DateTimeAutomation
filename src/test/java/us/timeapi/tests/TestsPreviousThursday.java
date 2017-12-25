package us.timeapi.tests;


import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import utilities.PropertiesLoader;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.concurrent.ExecutionException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class TestsPreviousThursday
{

  private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy", Locale.ENGLISH);
  private PreviousThursday test;

  @Before
  public void setup()
  {
    test = new PreviousThursday();
  }

  @Test
  public void testPreviousThursday() throws Exception {
    String str = PropertiesLoader.getProjectProperty("testPreviousThursday_data1");
    LocalDate date = LocalDate.parse(str, formatter);
    str = PropertiesLoader.getProjectProperty("testPreviousThursday1");
    LocalDate prvdate = LocalDate.parse(str, formatter);
    System.out.format("Test a previous Thursday %s%n", date);
    assertEquals(prvdate,
                 test.previousThursday(date));
    System.out.format("Result: The previous Thursday %s%n", test.previousThursday(date));


    str = PropertiesLoader.getProjectProperty("testPreviousThursday_data2");
    date = LocalDate.parse(str, formatter);
    str = PropertiesLoader.getProjectProperty("testPreviousThursday2");
    prvdate = LocalDate.parse(str, formatter);
    System.out.format("Test a previous Thursday %s%n", date);
    try{
        assertEquals(prvdate,
            test.previousThursday(date));}
    catch (Exception e) {}

    System.out.format("Result: The previous Thursday %s%n", test.previousThursday(date));
  }

}
