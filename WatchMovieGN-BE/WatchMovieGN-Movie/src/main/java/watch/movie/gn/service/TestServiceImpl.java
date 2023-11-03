package watch.movie.gn.service;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
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
import watch.movie.gn.domain.movie.MovieDomain;
import watch.movie.gn.entity.Country;
import watch.movie.gn.entity.Movie;
import watch.movie.gn.entity.Producer;
import watch.movie.gn.entity.Season;
import watch.movie.gn.entity.Type;
import watch.movie.gn.rabbitmq.domain.movie.CreateMovieRabbitMqSender;
import watch.movie.gn.rabbitmq.sender.WatchMovieGnSenderSearch;
import watch.movie.gn.repository.CountryRepository;
import watch.movie.gn.repository.MovieRepository;
import watch.movie.gn.repository.ProducerRepository;
import watch.movie.gn.repository.SeasonRepository;
import watch.movie.gn.repository.TypeRepository;
import watch.movie.gn.util.ConvertUtil;
import watch.movie.gn.util.DateUtil;
import watch.movie.gn.util.NumberUtil;

@Service
public class TestServiceImpl implements TestService {

	@Autowired
	private MovieRepository movieRepository;

	@Autowired
	private CountryRepository countryRepository;

	@Autowired
	private ProducerRepository producerRepository;

	@Autowired
	private SeasonRepository seasonRepository;

	@Autowired
	private TypeRepository typeRepository;

	@Autowired
	private WatchMovieGnSenderSearch watchMovieGnSenderSearch;

	@SuppressWarnings({ "deprecation", "unused" })
	@Override
	@Transactional(rollbackOn = Exception.class)
	public List<MovieDomain> fakeDataMovie() throws StreamReadException, DatabindException, IOException {

		List<Country> countries = countryRepository.findAll();
		List<Season> seasons = seasonRepository.findAll();
		List<Producer> producers = fakeDataProducers();
		List<Type> types = fakeDataTypes();
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
					movie.setSeason(seasons.get(NumberUtil.randomNumber(0, seasons.size() - 1)));
					movie.setProducer(producers.get(NumberUtil.randomNumber(0, producers.size() - 1)));
					movie.setType(types.get(NumberUtil.randomNumber(0, types.size() - 1)));
					movies.add(movie);
				}
			});
		}
		Set<Movie> movieSet = movies.stream()
				.collect(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Movie::getName))));
		movieRepository.saveAll(movieSet);
		List<MovieDomain> movieDomains = ConvertUtil.convertMovieToListDomain(movieSet);
		CreateMovieRabbitMqSender createMovieRabbitMqSender = new CreateMovieRabbitMqSender();
		createMovieRabbitMqSender.setMovies(movieDomains);
		watchMovieGnSenderSearch.createMovies(createMovieRabbitMqSender);
		return movieDomains;
	}

	@Override
	public List<Producer> fakeDataProducers() {
		List<Producer> producers = new ArrayList<>();
		producers.add(new Producer(null, "Kevin Feige", null));
		producers.add(new Producer(null, "Kathleen Kennedy", null));
		producers.add(new Producer(null, "Jerry Bruckheimer", null));
		producers.add(new Producer(null, "David Heyman", null));
		producers.add(new Producer(null, "Neal H. Moritz", null));
		producers.add(new Producer(null, "Frank Marshall", null));
		producers.add(new Producer(null, "Chris Meledandri", null));
		producers.add(new Producer(null, "James Cameron", null));
		producers.add(new Producer(null, "Charles Roven", null));
		producers.add(new Producer(null, "Avi Arad", null));
		producerRepository.saveAll(producers);
		return producers;
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
	public List<Type> fakeDataTypes() {
		List<Type> types = new ArrayList<>();
		types.add(new Type(null, "TV Series", null));
		types.add(new Type(null, "Movies", null));
		types.add(new Type(null, "OVA", null));
		types.add(new Type(null, "ONA", null));
		types.add(new Type(null, "Bluray", null));
		types.add(new Type(null, "Anime", null));
		types.add(new Type(null, "Cartoon", null));
		types.add(new Type(null, "Live Action", null));
		return typeRepository.saveAll(types);
	}

}
