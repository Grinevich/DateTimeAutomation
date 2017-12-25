package us.timeapi.tests;

import java.time.*;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

/**
 * Retrieve the first Wednesday after a specific date'
 */
public class NextWed {

	public LocalDate getnextWed(LocalDate date) {

		TemporalAdjuster adj = TemporalAdjusters.next(DayOfWeek.WEDNESDAY);
		LocalDate nextWed = date.with(adj);

		return nextWed;
	}

}
