package watch.movie.gn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import watch.movie.gn.domain.movie.CreateMovieRequest;
import watch.movie.gn.domain.movie.GetAllMovieReponse;
import watch.movie.gn.domain.movie.GetAllMovieRequest;
import watch.movie.gn.domain.movie.MovieDomain;
import watch.movie.gn.domain.movie.UpdateMovieRequest;
import watch.movie.gn.elastic.document.MovieDocument;
import watch.movie.gn.elastic.repository.MovieDocumentRepository;
import watch.movie.gn.entity.Movie;
import watch.movie.gn.exception.WatchMovieException;
import watch.movie.gn.repository.MovieRepository;
import watch.movie.gn.util.ConvertUtil;

@Slf4j
@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	public MovieRepository movieRepository;

	@Autowired
	public MovieDocumentRepository movieDocumentRepository;

	@Autowired
	public RestTemplate restTemplate;

	@Autowired
	public ObjectMapper objectMapper;

	@Override
	public GetAllMovieReponse getAllMovie(GetAllMovieRequest getAllMovieRequest) {
		log.debug("Get all Movie: " + getAllMovieRequest.toString());
		GetAllMovieReponse getAllMovieReponse = new GetAllMovieReponse();
		int page = getAllMovieRequest.getPage();
		int size = getAllMovieRequest.getSize();
		Page<MovieDocument> movies = movieDocumentRepository.findAll(PageRequest.of(page, size));
		Page<MovieDomain> movieDomains = movies.map(movie -> ConvertUtil.converMovieDocumentToMovieDomain(movie));
		getAllMovieReponse.setMovies(movieDomains);
		return getAllMovieReponse;
	}

	@Override
	public void pullMovie() {

	}

	@Override
	@Transactional(rollbackOn = Exception.class)
	public void createMovie(CreateMovieRequest createMovieRequest) {
		Movie movie = ConvertUtil.converCreateMovieRequestToMovie(createMovieRequest);
		movieRepository.save(movie);
		MovieDocument movieDocument = ConvertUtil.converMovieToMovieDocument(movie);
		movieDocumentRepository.save(movieDocument);
	}

	@Override
	public void updateMovie(UpdateMovieRequest updateMovieRequest) throws WatchMovieException {
		if (ObjectUtils.isEmpty(updateMovieRequest.getPkIdMovie())) {
			throw new WatchMovieException("Movie Id is not null or empty");
		}
		Movie movie = ConvertUtil.converUpdateMovieRequestToMovie(updateMovieRequest);
		movieRepository.save(movie);
		MovieDocument movieDocument = ConvertUtil.converMovieToMovieDocument(movie);
		movieDocumentRepository.save(movieDocument);
	}
}
