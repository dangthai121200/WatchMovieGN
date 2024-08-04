package watch.movie.gn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import watch.movie.gn.domain.movie.CreateMovieRequest;
import watch.movie.gn.domain.movie.GetAllMovieReponse;
import watch.movie.gn.domain.movie.GetAllMovieRequest;
import watch.movie.gn.domain.movie.UpdateMovieRequest;
import watch.movie.gn.entity.Movie;
import watch.movie.gn.exception.WatchMovieException;
import watch.movie.gn.repository.MovieRepository;
import watch.movie.gn.util.ConvertUtil;

@Slf4j
@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieRepository movieRepository;

	@Autowired
	private ObjectMapper objectMapper;

	@Override
	public GetAllMovieReponse getAllMovie(GetAllMovieRequest getAllMovieRequest) {
		log.debug("message = Get all Movie: " + getAllMovieRequest.toString());
		return null;
	}

	@Override
	public void pullMovie() {

	}

	@Override
	@Transactional(rollbackOn = Exception.class)
	public void createMovie(CreateMovieRequest createMovieRequest) {
		Movie movie = ConvertUtil.converCreateMovieRequestToMovie(createMovieRequest);
		movieRepository.save(movie);
	}

	@Override
	public void updateMovie(UpdateMovieRequest updateMovieRequest) throws WatchMovieException {
		if (ObjectUtils.isEmpty(updateMovieRequest.getPkIdMovie())) {
			throw new WatchMovieException("Movie Id is not null or empty");
		}

		Movie movie = ConvertUtil.converUpdateMovieRequestToMovie(updateMovieRequest);
		movieRepository.save(movie);
	}
}
