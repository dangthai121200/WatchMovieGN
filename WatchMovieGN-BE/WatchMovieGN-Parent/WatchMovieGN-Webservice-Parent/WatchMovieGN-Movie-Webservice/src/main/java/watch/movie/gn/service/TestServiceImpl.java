package watch.movie.gn.service;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.transaction.Transactional;
import org.springframework.util.ResourceUtils;
import watch.movie.gn.domain.movie.CreateMovieListRequest;
import watch.movie.gn.domain.movie.CreateMovieRequest;
import watch.movie.gn.entity.Country;
import watch.movie.gn.entity.Movie;
import watch.movie.gn.entity.Producer;
import watch.movie.gn.entity.Season;
import watch.movie.gn.entity.Type;
import watch.movie.gn.repository.CountryRepository;
import watch.movie.gn.repository.MovieRepository;
import watch.movie.gn.repository.ProducerRepository;
import watch.movie.gn.repository.SeasonRepository;
import watch.movie.gn.repository.TypeRepository;
import watch.movie.gn.util.*;

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
    private MovieServiceSendRequestTemplate movieServiceSendRequestTemplate;

    @SuppressWarnings({"deprecation", "unused"})
    @Override
    @Transactional(rollbackOn = Exception.class)
    public CreateMovieListRequest fakeDataMovie() throws IOException {

        List<Movie> movies = movieRepository.findAll();
        Set<Movie> movieSet = new HashSet<>();
        if (movies.isEmpty()) {
            List<Country> countries = countryRepository.findAll();
            List<Season> seasons = seasonRepository.findAll();
            List<Type> types = typeRepository.findAll();
            List<Producer> producers = fakeDataProducers();
            List<Map<String, Object>> listMovieJson = readValueFromMovieJson("classpath:movies.json");
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
                movieSet = movies.stream()
                        .collect(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Movie::getName))));
                movieRepository.saveAll(movieSet);
            }
        } else {
            movieSet = Set.copyOf(movies);
        }
        CreateMovieListRequest createMovieListRequest = new CreateMovieListRequest();
        List<CreateMovieRequest> createMovieRequests = ConvertUtil.convertMovieToListCreateMovieRequest(movieSet);
        createMovieListRequest.setMovies(createMovieRequests);
        movieServiceSendRequestTemplate.sendPostRequestToSearchService(createMovieListRequest, Object.class);
        return createMovieListRequest;
    }

    @Override
    public List<Producer> fakeDataProducers() {
        List<Producer> producers = producerRepository.findAll();
        if (producers.isEmpty()) {
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
        }
        return producers;
    }

    private List<Map<String, Object>> readValueFromMovieJson(String pathFile)
            throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = ResourceUtils.getFile(pathFile);
        if (!file.exists()) {
            return null;
        }
        List<Map<String, Object>> listMovieJson = objectMapper.readValue(file,
                new TypeReference<List<Map<String, Object>>>() {
                });
        return listMovieJson;
    }

}
