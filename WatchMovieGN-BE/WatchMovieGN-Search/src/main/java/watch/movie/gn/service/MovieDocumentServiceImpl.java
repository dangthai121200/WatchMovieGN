package watch.movie.gn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import watch.movie.gn.domain.movie.MovieDomain;
import watch.movie.gn.elastic.document.MovieDocument;
import watch.movie.gn.elastic.repository.MovieDocumentRepository;
import watch.movie.gn.rabbitmq.domain.movie.GetAllMovieRabbitMqReceive;
import watch.movie.gn.rabbitmq.domain.movie.GetAllMovieRabbitMqSender;
import watch.movie.gn.util.ConvertUtil;

@Service
public class MovieDocumentServiceImpl implements MovieDocumentService {

	@Autowired
	private MovieDocumentRepository movieDocumentRepository;

	@Override
	public GetAllMovieRabbitMqReceive getAllMovie(GetAllMovieRabbitMqSender getAllMovieRabbitMqSender) {
		GetAllMovieRabbitMqReceive getAllMovieRabbitMqReceive = new GetAllMovieRabbitMqReceive();
		int page = getAllMovieRabbitMqSender.getPage();
		int size = getAllMovieRabbitMqSender.getSize();
		Page<MovieDocument> movies = movieDocumentRepository.findAll(PageRequest.of(page, size));
		Page<MovieDomain> movieDomains = movies.map(movie -> ConvertUtil.converMovieDocumentToMovieDomain(movie));
		getAllMovieRabbitMqReceive.setMovies(movieDomains);
		return getAllMovieRabbitMqReceive;
	}

}
