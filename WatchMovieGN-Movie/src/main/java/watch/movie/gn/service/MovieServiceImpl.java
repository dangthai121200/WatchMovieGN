package watch.movie.gn.service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;
import watch.movie.gn.domain.CreateMovieRequest;
import watch.movie.gn.domain.GetAllMovieReponse;
import watch.movie.gn.domain.GetAllMovieRequest;
import watch.movie.gn.domain.MovieDomain;
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
		log.info("Start pull movie");
		ResponseEntity<String> response = restTemplate.getForEntity("https://anime47.com/", String.class);
		File file = new File("E:\\TuHoc\\Java\\WatchMovieGN\\file\\abc.txt");
		try {
			FileWriter fileWriter = new FileWriter(file);
			fileWriter.write(response.getBody());
			file.exists();
			fileWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		log.info("Pull movie ok");
	}

	@Override
	public void createMovie(CreateMovieRequest createMovieRequest) {
		List<Movie> movies = ConvertUtil.convertListMovieDomaiToListMovie(createMovieRequest.getMovieDomains());
		movieRepository.saveAll(movies);
	}
}
