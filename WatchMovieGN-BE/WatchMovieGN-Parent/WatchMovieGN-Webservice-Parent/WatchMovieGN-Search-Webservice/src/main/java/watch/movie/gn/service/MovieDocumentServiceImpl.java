package watch.movie.gn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import watch.movie.gn.domain.movie.CreateMovieListRequest;
import watch.movie.gn.domain.movie.GetAllMovieReponse;
import watch.movie.gn.domain.movie.GetAllMovieRequest;
import watch.movie.gn.domain.movie.MovieDomain;
import watch.movie.gn.elastic.document.MovieDocument;
import watch.movie.gn.elastic.repository.MovieDocumentRepository;
import watch.movie.gn.rabbitmq.domain.movie.CreateMovieRabbitMqSender;
import watch.movie.gn.util.ConvertUtil;

@Service
public class MovieDocumentServiceImpl implements MovieDocumentService {

    @Autowired
    private MovieDocumentRepository movieDocumentRepository;

    @Override
    public GetAllMovieReponse getAllMovie(GetAllMovieRequest getAllMovieRequest) {
        GetAllMovieReponse getAllMovieReponse = new GetAllMovieReponse();
        int page = getAllMovieRequest.getPage();
        int size = getAllMovieRequest.getSize();
        Page<MovieDocument> movies = movieDocumentRepository.findAll(PageRequest.of(page, size));
        Page<MovieDomain> movieDomains = movies.map(movie -> ConvertUtil.converMovieDocumentToMovieDomain(movie));
        getAllMovieReponse.setMovies(movieDomains);
        return getAllMovieReponse;
    }

    @Override
    public void createMovies(CreateMovieRabbitMqSender createMovieRabbitMqSender) {
        List<MovieDocument> movieDocuments = ConvertUtil
                .convertListMovieDomainToListMovieDocument(createMovieRabbitMqSender.getMovies());
        movieDocumentRepository.saveAll(movieDocuments);
    }

    @Override
    public void createMovies(CreateMovieListRequest createMovieListRequest) {
        List<MovieDocument> movieDocuments = ConvertUtil
                .convertListMovieCreateMovieRequestToListMovieDocument(createMovieListRequest.getMovies());
        movieDocumentRepository.saveAll(movieDocuments);

    }

}
