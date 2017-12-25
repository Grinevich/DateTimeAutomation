package us.timeapi.tests;

import org.junit.Before;
import org.junit.Test;
import utilities.PropertiesLoader;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class TestsConvertZoneToInstant
{
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy, HH:mm");

    private Zone test;
    private ZoneId systemZoneId;
    private ZoneId otherZoneId;

    private static LocalDateTime testDateTime;

  @Before
  public void setup()
  {
    test = new Zone();

    systemZoneId = ZoneId.systemDefault();
    otherZoneId = ZoneId.of(PropertiesLoader.getProjectProperty("TestsConvertZoneToInstant.otherZoneId"));
  }

  @Test
  public void testToInstant() throws Exception
  {
      String str = PropertiesLoader.getProjectProperty("TestsConvertZoneToInstant.testDateTime");
      testDateTime = LocalDateTime.parse(str, formatter);
      System.out.format("Test an instant %s in the system default timezone%n", testDateTime);
      final Instant testInstant1 = testDateTime
              .toInstant(getZoneOffset(systemZoneId));
      assertEquals(testInstant1,
              test.toInstant(testDateTime.atZone(systemZoneId)));
      System.out.format("Result: %s%n",test.toInstant(testDateTime.atZone(systemZoneId)));

      System.out.format("Test an instant %s in some other timezone: %s%n", testDateTime, otherZoneId);
      final Instant testInstant2 = testDateTime
              .toInstant(getZoneOffset(otherZoneId));
      assertEquals(testInstant2,
              test.toInstant(testDateTime.atZone(otherZoneId)));
      System.out.format("Result: %s%n", test.toInstant(testDateTime.atZone(systemZoneId)));

  }

  private ZoneOffset getZoneOffset(final ZoneId zoneId)
  {
    return zoneId.getRules().getOffset(testDateTime);
  }

}
