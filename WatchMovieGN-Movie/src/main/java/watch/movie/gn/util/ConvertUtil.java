package watch.movie.gn.util;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import watch.movie.gn.domain.MovieDomain;
import watch.movie.gn.entity.Movie;

@Service
public class ConvertUtil {
	
	@Autowired
	public static ModelMapper modelMapper;
	
	
	public static MovieDomain convertPageMovieToPageMovieDomain(Movie movie) {
		MovieDomain movieDomain = modelMapper.map(movie, MovieDomain.class);
		return movieDomain;
	}
	
	public static Movie converMovieDomainToMovie(MovieDomain movieDomain) {
		Movie movie = modelMapper.map(movieDomain, Movie.class);
		return movie;
	}
	
	public static List<Movie> convertListMovieDomaiToListMovie(List<MovieDomain> movieDomains) {
		if (!movieDomains.isEmpty()) {
			return movieDomains.stream().map(ConvertUtil::converMovieDomainToMovie).collect(Collectors.toList());
		}
		return Collections.emptyList();
	}
}
