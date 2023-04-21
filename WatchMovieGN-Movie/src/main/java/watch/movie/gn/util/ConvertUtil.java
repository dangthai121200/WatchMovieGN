package watch.movie.gn.util;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import watch.movie.gn.domain.CountryDomain;
import watch.movie.gn.domain.MovieDomain;
import watch.movie.gn.domain.ProducerDomain;
import watch.movie.gn.domain.SeasonDomain;
import watch.movie.gn.entity.Country;
import watch.movie.gn.entity.Movie;
import watch.movie.gn.entity.Producer;
import watch.movie.gn.entity.Season;

@Service
public class ConvertUtil {

	public static ModelMapper modelMapper;
	
	@Autowired
	public void setSomeThing(ModelMapper modelMapper) {
		ConvertUtil.modelMapper = modelMapper;
	}

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

	public static CountryDomain convertCountryToCountryDomain(Country country) {
		CountryDomain countryDomain = modelMapper.map(country, CountryDomain.class);
		return countryDomain;
	}

	public static ProducerDomain convertProducerToProducerDomain(Producer producer) {
		ProducerDomain producerDomain = modelMapper.map(producer, ProducerDomain.class);
		return producerDomain;
	}

	public static SeasonDomain convertSeasonToSeasonDomain(Season season) {
		SeasonDomain seasonDomain = modelMapper.map(season, SeasonDomain.class);
		return seasonDomain;
	}

}
