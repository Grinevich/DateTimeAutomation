package us.timeapi.tests;

import org.junit.Before;
import org.junit.Test;
import utilities.PropertiesLoader;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import static junit.framework.TestCase.assertEquals;

public class TestsNextWed {

	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy", Locale.ENGLISH);
	private NextWed test;

	@Before
	public void setup() {
		test = new NextWed();
	}

	@Test
	public void testNextWed() throws Exception{

		String str = PropertiesLoader.getProjectProperty("testNextWed_data");
		LocalDate date = LocalDate.parse(str, formatter);
		str = PropertiesLoader.getProjectProperty("testNextWed");
		LocalDate nxdate = LocalDate.parse(str, formatter);
		System.out.format("Test Local Date %s%n", date);
		assertEquals(nxdate, 	test.getnextWed(date));

		System.out.printf("Result: For the date of %s, the next Wednesday is %s.%n",
				date, test.getnextWed(date));

	}

}
