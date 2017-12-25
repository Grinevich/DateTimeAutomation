package us.timeapi.tests;

import org.junit.Before;
import org.junit.Test;
import utilities.PropertiesLoader;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import static junit.framework.TestCase.assertEquals;

public class TestsLastThursday {

	private LastThursday test;
	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

	@Before
	public void setup() {
		test = new LastThursday();
	}

	@Test
	public void test_lastThursday() throws Exception{
		String str = PropertiesLoader.getProjectProperty("TestsLastThursday_data");
		LocalDateTime localDate = LocalDateTime.parse(str, formatter);
		ZoneOffset offset = ZoneOffset.of(PropertiesLoader.getProjectProperty("TestsLastThursday_zoneOffset"));
		str = PropertiesLoader.getProjectProperty("TestsLastThursday");
		LocalDateTime lstdate = LocalDateTime.parse(str, formatter);

		System.out.format("Last Thursday %s %s %n", localDate.getMonth(), localDate.getYear());
		assertEquals(lstdate.getDayOfMonth(),
				test.getlastThursday(localDate, offset).getDayOfMonth());
		System.out.format("Result: %s%n", test.getlastThursday(localDate, offset).getDayOfMonth());

	}

}
