package watch.movie.gn.service;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.transaction.Transactional;
import watch.movie.gn.domain.MovieDomain;
import watch.movie.gn.elastic.document.MovieDocument;
import watch.movie.gn.elastic.repository.MovieDocumentRepository;
import watch.movie.gn.entity.Country;
import watch.movie.gn.entity.Movie;
import watch.movie.gn.entity.Season;
import watch.movie.gn.repository.CountryRepository;
import watch.movie.gn.repository.MovieRepository;
import watch.movie.gn.repository.SeasonRepository;
import watch.movie.gn.util.ConvertUtil;
import watch.movie.gn.util.DateUtil;
import watch.movie.gn.util.ListCountryUtil;
import watch.movie.gn.util.NumberUtil;
import watch.movie.gn.util.SeasonEnum;

@Service
public class TestServiceImpl implements TestService {

	@Autowired
	private MovieRepository movieRepository;

	@Autowired
	private MovieDocumentRepository movieDocumentRepository;

	@Autowired
	private CountryRepository countryRepository;

	@Autowired
	private SeasonRepository seasonRepository;

	@SuppressWarnings({ "deprecation", "unused" })
	@Override
	@Transactional(rollbackOn = Exception.class)
	public List<MovieDomain> fakeDataMovie() throws StreamReadException, DatabindException, IOException {

		List<Country> countries = fakeDataCountries();
		List<Season> seasons = fakeDataSeasons(2020, 2023);
		List<Map<String, Object>> listMovieJson = readValueFromMovieJson("src/main/resources/movies.json");
		List<Movie> movies = new ArrayList<>();
		if (!ObjectUtils.isEmpty(listMovieJson)) {
			listMovieJson.forEach(movieJson -> {
				String title = (String) movieJson.get("title");
				String extract = (String) movieJson.get("extract");
				String thumbnail = (String) movieJson.get("thumbnail");
				if (!ObjectUtils.isEmpty(title) && !ObjectUtils.isEmpty(extract)) {
					Movie movie = new Movie();
					movie.setName(title);
					double randomView = Math.random() * 1000;
					movie.setView((int) randomView);
					LocalDate start = LocalDate.of(2020, Month.JANUARY, 1);
					LocalDate end = LocalDate.now();
					LocalDate randomDate = DateUtil.randomDate(start, end);
					movie.setYearOfBroadcast(new Date(randomDate.getYear(), randomDate.getMonth().getValue(),
							randomDate.getDayOfMonth()));
					movie.setUrlImage(thumbnail);
					movie.setContent(extract);
					double randomTime = Math.random() * 100;
					movie.setTime(90);
					movie.setCountry(countries.get(NumberUtil.randomNumber(0, countries.size() - 1)));
					movie.setSeason(seasons.get((NumberUtil.randomNumber(0, seasons.size() - 1))));
					movies.add(movie);
				}
			});
		}
		Set<Movie> movieSet = movies.stream()
				.collect(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Movie::getName))));
		movieRepository.saveAll(movieSet);
		Set<MovieDocument> movieDocuments = ConvertUtil.convertListMovieDomaiToListMovie(movieSet);
		movieDocumentRepository.saveAll(movieDocuments);
		List<MovieDomain> movieDomains = ConvertUtil.converListMovieDocumentToListMovieDomain(movieDocuments);
		return movieDomains;
	}

	private List<Map<String, Object>> readValueFromMovieJson(String pathFile)
			throws StreamReadException, DatabindException, IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		File file = new File(pathFile);
		if (!file.exists()) {
			return null;
		}
		List<Map<String, Object>> listMovieJson = objectMapper.readValue(file,
				new TypeReference<List<Map<String, Object>>>() {
				});
		return listMovieJson;
	}

	@Override
	public List<Country> fakeDataCountries() {
		List<Country> countries = new ArrayList<>();
		for (Locale locale : ListCountryUtil.getLocales()) {
			Country country = new Country();
			country.setName(locale.getDisplayCountry());
			country.setCode(locale.getCountry());
			countries.add(country);
		}
		return countryRepository.saveAll(countries);
	}

	@Override
	public List<Season> fakeDataSeasons(int yearStart, int yearEnd) {
		List<Season> seasons = new ArrayList<>();
		for (int i = yearStart; i <= yearEnd; i++) {
			for (int j = 0; j < 4; j++) {
				SeasonEnum seasonEnum = getSeason(j);
				Season season = new Season();
				season.setName(seasonEnum);
				season.setYear(i);
				seasons.add(season);
			}
		}
		return seasonRepository.saveAll(seasons);
	}

	private SeasonEnum getSeason(int numberSeason) {
		SeasonEnum seasonEnum = null;
		switch (numberSeason) {
		case 0:
			seasonEnum = SeasonEnum.SPRING;
			break;
		case 1:
			seasonEnum = SeasonEnum.SUMMER;
			break;
		case 2:
			seasonEnum = SeasonEnum.FALL;
			break;
		case 3:
			seasonEnum = SeasonEnum.WINTER;
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + numberSeason);
		}
		return seasonEnum;
	}

}
