package watch.movie.gn.util;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import watch.movie.gn.domain.*;
import watch.movie.gn.elastic.document.MovieDocument;
import watch.movie.gn.entity.Country;
import watch.movie.gn.entity.Movie;
import watch.movie.gn.entity.Producer;
import watch.movie.gn.entity.Season;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ConvertUtil {

	private ConvertUtil() {
	}

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

	public static MovieDocument converMovieToMovieDocument(Movie movie) {
		MovieDocument movieDocument = modelMapper.map(movie, MovieDocument.class);
		return movieDocument;
	}

	public static MovieDomain converMovieDocumentToMovieDomain(MovieDocument movieDocument) {
		MovieDomain movieDomain = modelMapper.map(movieDocument, MovieDomain.class);
		return movieDomain;
	}

	public static Movie converCreateMovieRequestToMovie(CreateMovieRequest createMovieRequest) {
		Movie movie = modelMapper.map(createMovieRequest, Movie.class);
		return movie;
	}

	public static Movie converUpdateMovieRequestToMovie(UpdateMovieRequest updateMovieRequest) {
		Movie movie = modelMapper.map(updateMovieRequest, Movie.class);
		return movie;
	}

	public static Set<MovieDocument> convertListMovieDomaiToListMovie(Set<Movie> movies) {
		if (!movies.isEmpty()) {
			return movies.stream().map(ConvertUtil::converMovieToMovieDocument).collect(Collectors.toSet());
		}
		return Collections.emptySet();
	}

	public static List<Movie> convertListMovieDomaiToListMovie(List<MovieDomain> movieDomains) {
		if (!movieDomains.isEmpty()) {
			return movieDomains.stream().map(ConvertUtil::converMovieDomainToMovie).collect(Collectors.toList());
		}
		return Collections.emptyList();
	}
	
	public static List<MovieDomain> converListMovieDocumentToListMovieDomain(List<MovieDocument> movieDocuments) {

		if (!movieDocuments.isEmpty()) {
			return movieDocuments.stream().map(ConvertUtil::converMovieDocumentToMovieDomain)
					.collect(Collectors.toList());
		}
		return Collections.emptyList();
	}
	
	public static List<MovieDomain> converListMovieDocumentToListMovieDomain(Set<MovieDocument> movieDocuments) {

		if (!movieDocuments.isEmpty()) {
			return movieDocuments.stream().map(ConvertUtil::converMovieDocumentToMovieDomain)
					.collect(Collectors.toList());
		}
		return Collections.emptyList();
	}

	public static CountryDomain convertCountryToCountryDomain(Country country) {
		CountryDomain countryDomain = modelMapper.map(country, CountryDomain.class);
		return countryDomain;
	}

	public static Country convertCountryDomainToCountry(CountryDomain countryDomain) {
		Country country = modelMapper.map(countryDomain, Country.class);
		return country;
	}

	public static List<CountryDomain> convertListCountryToListCountryDomain(List<Country> countries) {
		if (!countries.isEmpty()) {
			return countries.stream().map(ConvertUtil::convertCountryToCountryDomain).collect(Collectors.toList());
		}
		return Collections.emptyList();
	}

	public static List<Country> convertListCountryDomainToListCountry(List<CountryDomain> countries) {
		if (!countries.isEmpty()) {
			return countries.stream().map(ConvertUtil::convertCountryDomainToCountry).collect(Collectors.toList());
		}
		return Collections.emptyList();
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
