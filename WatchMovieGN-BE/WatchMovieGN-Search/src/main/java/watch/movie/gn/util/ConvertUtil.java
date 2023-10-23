package watch.movie.gn.util;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import watch.movie.gn.domain.movie.MovieDomain;
import watch.movie.gn.elastic.document.MovieDocument;

@Service
public class ConvertUtil {

	private ConvertUtil() {
	}

	public static ModelMapper modelMapper;

	@Autowired
	public void setSomeThing(ModelMapper modelMapper) {
		ConvertUtil.modelMapper = modelMapper;
	}

	public static MovieDomain converMovieDocumentToMovieDomain(MovieDocument movieDocument) {
		MovieDomain movieDomain = modelMapper.map(movieDocument, MovieDomain.class);
		return movieDomain;
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

}
