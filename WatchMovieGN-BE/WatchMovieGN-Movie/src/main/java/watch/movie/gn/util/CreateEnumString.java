package watch.movie.gn.util;

import watch.movie.gn.entity.Country;

import java.util.*;

public class CreateEnumString {
	public static String reaplaceSpace(String text) {
		return text.replace(" ", "_").replace(".", "").replace("&", "").replace("-", "");
	}
	
	private static String getSeason(int numberSeason) {
		String season = null;
		switch (numberSeason) {
		case 0:
			season = "SPRING";
			break;
		case 1:
			season = "SUMMER";
			break;
		case 2:
			season = "FALL";
			break;
		case 3:
			season = "WINTER";
			break;
		}
		return season;
	}
	
	public static void printEnumCountry() {
		Map<String, String> languagesMap = new TreeMap<String, String>();

		// print enum list country

		String[] countries = Locale.getISOCountries();
		Set<Locale> locales = new HashSet<>();

		int supportedLocale = 0, nonSupportedLocale = 0;

		for (String countryCode : countries) {
			Locale obj = null;
			if (languagesMap.get(countryCode) == null) {
				obj = new Locale("", countryCode);
				nonSupportedLocale++;
			} else {
				// create a Locale with own country's languages
				obj = new Locale(languagesMap.get(countryCode), countryCode);
				supportedLocale++;
			}
			locales.add(obj);
		}

		int i = 1;
		for (Locale locale : locales) {
			Country country = new Country();
			country.setName(locale.getDisplayCountry());
			country.setCode(locale.getCountry());
			System.out.println(reaplaceSpace(locale.getDisplayCountry().toUpperCase()) + "(" + i + ",  " + "\""
					+ locale.getCountry() + "\"" + ", " + "\"" + locale.getDisplayCountry() + "\"" + ")" + ",");
			i++;
		}
		
	}
	
	public static void printEnumSeason() {
		int yearStart = 2000;
		int yearEnd = 2023;
		int count = 1;
		for (int i = yearStart; i <= yearEnd; i++) {
			for (int j = 0; j < 4; j++) {
				String seasonString = getSeason(j);
				System.out.println(seasonString + "_" + i + "(" + count + ", " + "\"" + seasonString + " " + i +"\"" + ", " + i + ")" + ",");
				count++;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		//printEnumCountry();
		printEnumSeason();
		
	}

}
