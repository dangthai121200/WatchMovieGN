package watch.movie.gn.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.ArrayType;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import watch.movie.gn.domain.CreateMovieRequest;
import watch.movie.gn.domain.GetAllMovieReponse;
import watch.movie.gn.domain.GetAllMovieRequest;
import watch.movie.gn.domain.MovieDomain;
import watch.movie.gn.domain.UpdateMovieRequest;
import watch.movie.gn.entity.Movie;
import watch.movie.gn.repository.MovieRepository;
import watch.movie.gn.util.ConvertUtil;

@Slf4j
@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	public MovieRepository movieRepository;

	@Autowired
	public RestTemplate restTemplate;

	@Autowired
	public ObjectMapper objectMapper;

	@Override
	public GetAllMovieReponse getAllMovie(GetAllMovieRequest getAllMovieRequest) {
		log.info("Get all Movie: " + getAllMovieRequest.toString());
		GetAllMovieReponse getAllMovieReponse = new GetAllMovieReponse();
		int page = getAllMovieRequest.getPage();
		int size = getAllMovieRequest.getSize();
		Page<Movie> movies = movieRepository.findAll(PageRequest.of(page, size));
		Page<MovieDomain> movieDomains = movies.map(movie -> ConvertUtil.convertPageMovieToPageMovieDomain(movie));
		getAllMovieReponse.setMovies(movieDomains);
		return getAllMovieReponse;
	}

	@Override
	public void pullMovie() {

	}

	@Override
	public void createMovie(CreateMovieRequest createMovieRequest) {
		List<Movie> movies = ConvertUtil.convertListMovieDomaiToListMovie(createMovieRequest.getMovies());
		movieRepository.saveAll(movies);
	}

	@Override
	public void updateMovie(UpdateMovieRequest updateMovieRequest) {
		Movie movie = ConvertUtil.converMovieDomainToMovie(updateMovieRequest.getMovieDomain());
		movieRepository.save(movie);
	}

	@Override
	@Transactional(rollbackOn = Exception.class)
	public void fakeDataMovie() throws StreamReadException, DatabindException, IOException {

		ObjectMapper objectMapper = new ObjectMapper();
		File file = new File("E:\\TuHoc\\Java\\WatchMovieGN\\WatchMovieGN-Movie\\src\\main\\resources\\movies.json");
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
				movie.setContent(extract);
				movie.setUrlImage(thumbnail);
				movies.add(movie);
			}
		});
		
		Set<Movie> movieSet = movies.stream()
				.collect(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Movie::getName))));
		
		movieRepository.saveAll(movieSet);
	}
	
	public static void main(String[] args) throws IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		File file = new File("E:\\TuHoc\\Java\\WatchMovieGN\\WatchMovieGN-Movie\\src\\main\\resources\\movies.json");
		List<Map<String, Object>> myObjects = objectMapper.readValue(file, new TypeReference<List<Map<String, Object>>>() {
		});
		
		System.out.println(myObjects.get(0));
		
//		Iterator<JsonNode> iterator = objectMapper.readTree(file).iterator();
//		System.out.println();
//		while(iterator.hasNext()) {
//			JsonNode jsonNode = iterator.next();
//			System.out.println(jsonNode.toString());
//		}
//		System.out.println();
	}
}
