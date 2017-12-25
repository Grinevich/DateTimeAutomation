package us.timeapi.tests;


import org.junit.Before;
import org.junit.Test;
import utilities.PropertiesLoader;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class TestsIsFriday13
{
  private IsFriday13 test;
  private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy", Locale.ENGLISH);

  @Before
  public void setup()
  {
    test = new IsFriday13();
  }

  @Test
  public void testIsFriday13() throws Exception
  {

    String str = PropertiesLoader.getProjectProperty("TestIsFriday13_1");
    System.out.format("Test Is Friday 13: %s%n", str);
    LocalDate date = LocalDate.parse(str, formatter);
    assertEquals(true,
                 test.isFriday13(date));
      System.out.println("Result: true");

    str = PropertiesLoader.getProjectProperty("TestIsFriday13_2");
    System.out.format("Test some other Friday: %s%n", str);
    date = LocalDate.parse(str, formatter);
    assertEquals(false,
                 test.isFriday13(date));
    System.out.println("Result: false");

    str = PropertiesLoader.getProjectProperty("TestIsFriday13_3");
    System.out.format("Test some other 13: %s%n", str);
    date = LocalDate.parse(str, formatter);
    assertEquals(false,
                 test.isFriday13(date));
    System.out.println("Result: false");;

    str = PropertiesLoader.getProjectProperty("TestIsFriday13_4");
    System.out.format("Test some other date: %s%n", str);
    date = LocalDate.parse(str, formatter);
    assertEquals(false,
                 test.isFriday13(date));
      System.out.println("Result: false");

  }

}
