package watch.movie.gn.rabbitmq.util;

import org.springframework.amqp.core.ExchangeTypes;
import watch.movie.gn.util.ConstantGlobal;

public class RabbitMQConstantGlobal {
    private RabbitMQConstantGlobal() {
    }

    public static final String MOVIE_SERVICE = "WatchMovieGN-Movie";
    public static final String SEARCH_SERVICE = "WatchMovieGN-Search";

    public static final String QUEUE = "Queue";
    public static final String EXCHANGE = "Exchange";
    public static final String ROUTING = "Routing";

    // @formatter:off
//    ----------------------------------- WatchMovieGN-Search ----------------------------------------------

    public static final String SEARCH_SERVICE_MOVIE_CRUD_EXCHANGE
            = RabbitMQUtil.getExchange(SEARCH_SERVICE,
        ConstantGlobal.MOVIE + ConstantGlobal.DOT + ConstantGlobal.CRUD, ExchangeTypes.DIRECT);
    public static final String SEARCH_SERVICE_MOVIE_CREATE_ACTION = RabbitMQUtil.getAction(ConstantGlobal.CREATE, ConstantGlobal.MOVIE);
    public static final String SEARCH_SERVICE_MOVIE_CREATE_ROUTING =
            RabbitMQUtil.getRoutingKey(SEARCH_SERVICE, SEARCH_SERVICE_MOVIE_CREATE_ACTION);
//    ----------------------------------- WatchMovieGN-Search ----------------------------------------------
    // @formatter:on
}
