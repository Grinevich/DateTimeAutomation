package us.timeapi.tests;

import org.junit.Before;
import org.junit.Test;
import utilities.PropertiesLoader;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class TestsConvertInstantToZone
{
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy, HH:mm");
    private static LocalDateTime testDateTime;

    private Zone test;
    private ZoneId systemZoneId;
    private ZoneId otherZoneId1;
    private ZoneId otherZoneId2;

  @Before
  public void setup()
  {
      test = new Zone();

      systemZoneId = ZoneId.systemDefault();
      otherZoneId1 = ZoneId.of(PropertiesLoader.getProjectProperty("TestsConvertInstantToZone.otherZoneId1"));
      otherZoneId2 = ZoneId.of(PropertiesLoader.getProjectProperty("TestsConvertInstantToZone.otherZoneId2"));
  }

    @Test
    public void testAtZone() throws Exception
    {
        String str = PropertiesLoader.getProjectProperty("TestsConvertInstantToZone.testDateTime");
        testDateTime = LocalDateTime.parse(str, formatter);
        System.out.format("Test an instant %s in the system default timezone%n", testDateTime);
        final Instant testInstant1 = testDateTime.
                toInstant(getZoneOffset(systemZoneId));
        assertEquals(ZonedDateTime.of(testDateTime, systemZoneId),
                test.atZone(testInstant1, null));
        System.out.format("Result: %s%n", test.atZone(testInstant1, null));

        System.out.format("Test an instant %s in some other timezone %s%n", testDateTime, otherZoneId1);
        final Instant testInstant2 = testDateTime
                .toInstant(getZoneOffset(otherZoneId1));
        assertEquals(ZonedDateTime.of(testDateTime, otherZoneId1),
                test.atZone(testInstant2, otherZoneId1));
        System.out.format("Result: %s%n", test.atZone(testInstant2, otherZoneId1));

        System.out.format("Test an instant %s in some other timezone %s%n", testDateTime, otherZoneId2);
        final Instant testInstant3 = testDateTime
                .toInstant(getZoneOffset(otherZoneId2));
        assertEquals(ZonedDateTime.of(testDateTime, otherZoneId2),
                test.atZone(testInstant3, otherZoneId2));
        System.out.format("Result: %s%n", test.atZone(testInstant3, otherZoneId2));
    }

  private ZoneOffset getZoneOffset(final ZoneId zoneId)
  {
    return zoneId.getRules().getOffset(testDateTime);
  }

}
