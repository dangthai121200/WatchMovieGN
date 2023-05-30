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
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.transaction.Transactional;
import watch.movie.gn.elastic.document.MovieDocument;
import watch.movie.gn.elastic.repository.MovieDocumentRepository;
import watch.movie.gn.entity.Country;
import watch.movie.gn.entity.Movie;
import watch.movie.gn.repository.CountryRepository;
import watch.movie.gn.repository.MovieRepository;
import watch.movie.gn.util.ConvertUtil;
import watch.movie.gn.util.DateUtil;
import watch.movie.gn.util.ListCountryUtil;
import watch.movie.gn.util.NumberUtil;

@Service
public class TestServiceImpl implements TestService {

	@Autowired
	private MovieRepository movieRepository;

	@Autowired
	private MovieDocumentRepository movieDocumentRepository;

	@Autowired
	private CountryRepository countryRepository;

	@Override
	@Transactional(rollbackOn = Exception.class)
	public void fakeDataMovie() throws StreamReadException, DatabindException, IOException {
		List<Country> countries = new ArrayList<>();
		for (Locale locale : ListCountryUtil.getLocales()) {
			Country country = new Country();
			country.setName(locale.getDisplayCountry());
			country.setCode(locale.getCountry());
			countries.add(country);
		}
		countryRepository.saveAll(countries);

		ObjectMapper objectMapper = new ObjectMapper();
		File file = new File("src/main/resources/movies.json");
		List<Map<String, Object>> listMovieJson = objectMapper.readValue(file,
				new TypeReference<List<Map<String, Object>>>() {
				});
		List<Movie> movies = new ArrayList<>();
		listMovieJson.forEach(movieJson -> {
			String title = (String) movieJson.get("title");
			String extract = (String) movieJson.get("extract");
			String thumbnail = (String) movieJson.get("thumbnail");
			if (!StringUtils.isEmpty(title) && !StringUtils.isEmpty(extract)) {
				Movie movie = new Movie();
				movie.setName(title);
				double randomView = Math.random() * 1000;
				movie.setView((int) randomView);
				LocalDate start = LocalDate.of(2020, Month.JANUARY, 1);
				LocalDate end = LocalDate.now();
				LocalDate randomDate = DateUtil.randomDate(start, end);
				movie.setYearOfBroadcast(
						new Date(randomDate.getYear(), randomDate.getMonth().getValue(), randomDate.getDayOfMonth()));
				movie.setUrlImage(thumbnail);
				movie.setContent(extract);
				double randomTime = Math.random() * 100;
				movie.setTime(90);
				movie.setCountry(countries.get(NumberUtil.randomNumber(0, countries.size() - 1)));
				movies.add(movie);
			}
		});

		Set<Movie> movieSet = movies.stream()
				.collect(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Movie::getName))));
		movieRepository.saveAll(movieSet);
		Set<MovieDocument> movieDocuments = ConvertUtil.convertListMovieDomaiToListMovie(movieSet);
		movieDocumentRepository.saveAll(movieDocuments);
	}

}
