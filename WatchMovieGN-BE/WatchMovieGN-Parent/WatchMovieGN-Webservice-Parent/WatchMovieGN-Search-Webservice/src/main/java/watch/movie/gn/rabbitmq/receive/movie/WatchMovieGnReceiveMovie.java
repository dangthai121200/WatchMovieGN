package watch.movie.gn.rabbitmq.receive.movie;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import watch.movie.gn.rabbitmq.domain.movie.CreateMovieRabbitMqSender;
import watch.movie.gn.service.MovieDocumentService;

@Configuration
@Slf4j
public class WatchMovieGnReceiveMovie {
    @Autowired
    private MovieDocumentService movieDocumentService;

    @Autowired
    private Queue createMoviesQueue;

    @RabbitListener(queues = "#{createMoviesQueue.name}")
    public void createMovies(CreateMovieRabbitMqSender createMovieRabbitMqSender) {
        log.info("message = Receive RabbitMq createMovie");
        movieDocumentService.createMovies(createMovieRabbitMqSender);
    }
}
