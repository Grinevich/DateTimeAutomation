package us.timeapi.tests;

import java.time.DayOfWeek;
import java.time.LocalDate;

/**
 * Tests whether a given date occurs on Friday the 13th.
 */
public class IsFriday13 {

	public boolean isFriday13(final LocalDate date) {
		if (date == null) {
			return false;
		} else {
			return date.getDayOfWeek() == DayOfWeek.FRIDAY && date.getDayOfMonth() == 13;
		}
	}

}
