package watch.movie.gn.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MovieServiceSendRequestTemplate {

    @Autowired
    private WatchMovieGnRestTemplate watchMovieGnRestTemplate;

    @Value("${spring.application.name}")
    private String start;

    @Value("${watch.movie.gn.search.spring.application.name}")
    private String callTo;

    @Value("${watch.movie.gn.search.servlet.context-path}")
    private String watchMovieGnSearchServiceUrl;

    @Value("${watch.movie.gn.search.server.servlet.port}")
    private String  watchMovieGnSearchServicePort;
    public <T> T sendPostRequestToSearchService(Object object, Class<T> responseType) {
        String url = "http://localhost:" + watchMovieGnSearchServicePort + watchMovieGnSearchServiceUrl + UrlConstant.MOVIE_CONTROLLER_V1 + UrlConstant.MOVIE_CONTROLLER_V1_GET_CREATE_MOVIE;
        return watchMovieGnRestTemplate.sendPostRequest(url, start, callTo, object, responseType);
    }
}
