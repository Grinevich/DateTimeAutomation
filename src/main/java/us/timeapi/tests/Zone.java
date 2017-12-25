package us.timeapi.tests;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * Convert an Instant to a ZonedDateTime
 * Convert a ZonedDateTime to an Instant
 */
public class Zone {

	public ZonedDateTime atZone(final Instant instant, final ZoneId zoneId) {
		final ZonedDateTime zonedDateTime;
		if (instant == null) {
			zonedDateTime = null;
		} else {
			if (zoneId == null) {
				zonedDateTime = instant.atZone(ZoneId.systemDefault());
			} else {
				zonedDateTime = instant.atZone(zoneId);
			}
		}
		return zonedDateTime;
	}

	public Instant toInstant(final ZonedDateTime zonedDateTime) {
		Instant instant;
		if (zonedDateTime == null) {
			instant = null;
		} else {
			instant = zonedDateTime.toInstant();
		}
		return instant;
	}

}
