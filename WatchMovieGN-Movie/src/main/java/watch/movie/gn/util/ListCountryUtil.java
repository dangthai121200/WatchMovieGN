package watch.movie.gn.util;

import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ListCountryUtil {

	private static Map<String, String> languagesMap = new TreeMap<String, String>();
	private static @Getter Set<Locale> locales = new HashSet<>();

	@PostConstruct
	public void init() {
		initLanguageMap();
		getListOfCountries();
	}

	private void getListOfCountries() {

		String[] countries = Locale.getISOCountries();

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
		log.info("nonSupportedLocale : " + nonSupportedLocale);
		log.info("supportedLocale : " + supportedLocale);
	}

	// create Map with country code and languages
	private void initLanguageMap() {

		Locale[] locales = Locale.getAvailableLocales();

		for (Locale obj : locales) {

			if ((obj.getDisplayCountry() != null) && (!"".equals(obj.getDisplayCountry()))) {
				languagesMap.put(obj.getCountry(), obj.getLanguage());
			}

		}

	}
}
