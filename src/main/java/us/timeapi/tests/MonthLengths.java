package us.timeapi.tests;

import java.time.Month;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * A given year, reports the length of each month
 */
public class MonthLengths {

	public List<Integer> getMonthLengths(final int year) {
		return new ArrayList<>(getMonthLengthsMap(year).values());
	}

	public SortedMap<YearMonth, Integer> getMonthLengthsMap(final int year) {
		final SortedMap<YearMonth, Integer> monthLengths = new TreeMap<>();
		for (final Month month : Month.values()) {
			final YearMonth yearMonth = YearMonth.of(year, month);
			monthLengths.put(yearMonth, yearMonth.lengthOfMonth());
		}
		return monthLengths;
	}

}
