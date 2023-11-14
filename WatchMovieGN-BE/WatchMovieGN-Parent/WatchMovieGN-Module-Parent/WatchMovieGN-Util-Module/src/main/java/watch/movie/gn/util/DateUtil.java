package watch.movie.gn.util;

import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.stereotype.Service;

@Service
public class DateUtil {

	private DateUtil() {

	}

	public static LocalDate randomDate(LocalDate startInclusive, LocalDate endExclusive) {
		long startEpochDay = startInclusive.toEpochDay();
		long endEpochDay = endExclusive.toEpochDay();
		long randomDay = ThreadLocalRandom.current().nextLong(startEpochDay, endEpochDay);
		return LocalDate.ofEpochDay(randomDay);
	}
}
