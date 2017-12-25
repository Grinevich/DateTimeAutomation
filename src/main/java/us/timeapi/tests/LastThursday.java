package us.timeapi.tests;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.temporal.TemporalAdjusters;

/**
 * Find the last Thursday in .onthsInYear.java">MonthsInYear.java</a>
 */
public class LastThursday {

	public OffsetDateTime getlastThursday(LocalDateTime localDate, ZoneOffset offset) {

		OffsetDateTime offsetDate = OffsetDateTime.of(localDate, offset);
		OffsetDateTime lastThursday =
				offsetDate.with(TemporalAdjusters.lastInMonth(DayOfWeek.THURSDAY));

		return lastThursday;
	}

}
