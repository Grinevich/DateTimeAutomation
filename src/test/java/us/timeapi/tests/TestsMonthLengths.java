package us.timeapi.tests;

import org.junit.Before;
import org.junit.Test;
import utilities.PropertiesLoader;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import static junit.framework.TestCase.assertEquals;

public class TestsMonthLengths {

	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy", Locale.ENGLISH);
	private MonthLengths test;

	@Before
	public void setup() {
		test = new MonthLengths();
	}

	@Test
	public void testMonthLengths() throws Exception {

		LocalDate testDate = LocalDate.parse(PropertiesLoader.getProjectProperty("MonthLengths_1"), formatter);
        System.out.format("Month Lengths %s%n", testDate.getYear());
		String str = PropertiesLoader.getProjectProperty("Lengths_1");
		List<String> lst = Arrays.asList(str.split(","));
        List<Integer> intList = lst.stream().map(Integer::parseInt).collect(Collectors.toList());
		assertEquals(
				intList,
				test.getMonthLengths(testDate.getYear()));
        System.out.format("Result: Lengths %s%n",test.getMonthLengths(testDate.getYear()));

        testDate = LocalDate.parse(PropertiesLoader.getProjectProperty("MonthLengths_2"), formatter);
        System.out.format("Month Lengths %s%n", testDate.getYear());
        str = PropertiesLoader.getProjectProperty("Lengths_2");
        lst = Arrays.asList(str.split(","));
        intList = lst.stream().map(Integer::parseInt).collect(Collectors.toList());
        try{
            assertEquals(
                    intList,
                    test.getMonthLengths(testDate.getYear()));
        }
        catch (Exception e) {}
        System.out.format("Result: Lengths %s%n",test.getMonthLengths(testDate.getYear()));

	}

}
