package watch.movie.gn.util;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import watch.movie.gn.domain.movie.CreateMovieRequest;
import watch.movie.gn.domain.movie.MovieDomain;
import watch.movie.gn.elastic.document.MovieDocument;

@Service
public class ConvertUtil {

    private ConvertUtil() {
    }

    private static ModelMapper modelMapper;

    @Autowired
    public void setSomeThing(ModelMapper modelMapper) {
        ConvertUtil.modelMapper = modelMapper;
    }

    public static MovieDomain converMovieDocumentToMovieDomain(MovieDocument movieDocument) {
        MovieDomain movieDomain = modelMapper.map(movieDocument, MovieDomain.class);
        return movieDomain;
    }

    public static MovieDocument convertMovieDomainToMovieDocument(MovieDomain movieDomain) {
        MovieDocument movieDocument = modelMapper.map(movieDomain, MovieDocument.class);
        return movieDocument;
    }

    public static MovieDocument convertCreateMovieRequestToMovieDocument(CreateMovieRequest createMovieRequest) {
        MovieDocument movieDocument = modelMapper.map(createMovieRequest, MovieDocument.class);
        return movieDocument;
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

    public static List<MovieDocument> convertListMovieDomainToListMovieDocument(List<MovieDomain> movieDomains) {
        if (!movieDomains.isEmpty()) {
            return movieDomains.stream().map(ConvertUtil::convertMovieDomainToMovieDocument)
                    .collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    public static List<MovieDocument> convertListMovieCreateMovieRequestToListMovieDocument(List<CreateMovieRequest> createMovieRequests) {
        if (!createMovieRequests.isEmpty()) {
            return createMovieRequests.stream().map(ConvertUtil::convertCreateMovieRequestToMovieDocument)
                    .collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

}
