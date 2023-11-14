package watch.movie.gn.util;

import org.springframework.stereotype.Service;

@Service
public class NumberUtil {

	private NumberUtil() {

	}

	public static int randomNumber(int min, int max) {
		return (int) Math.floor(Math.random() * (max - min + 1) + min);
	}
}
