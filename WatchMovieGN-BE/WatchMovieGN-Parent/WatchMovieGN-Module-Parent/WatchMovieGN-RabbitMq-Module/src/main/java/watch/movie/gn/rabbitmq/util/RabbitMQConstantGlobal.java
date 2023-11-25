package watch.movie.gn.rabbitmq.util;

import org.springframework.amqp.core.ExchangeTypes;
import watch.movie.gn.util.ConstantGlobal;

public class RabbitMQConstantGlobal {
    private RabbitMQConstantGlobal() {
    }

    public static final String MOVIE_SERVICE = "WebserviceMovie";
    public static final String SEARCH_SERVICE = "WebserviceSearch";
    public static final String USER_SERVICE = "WebserviceUser";


    public static final String QUEUE = "Queue";
    public static final String EXCHANGE = "Exchange";
    public static final String ROUTING = "Routing";


    // @formatter:off
//    ----------------------------------- WatchMovieGN-User ----------------------------------------------
    public static final String USER_SERVICE_USER_AUTHENTICATION_EXCHANGE
            = RabbitMQUtil.getExchange(USER_SERVICE,
            ConstantGlobal.USER + ConstantGlobal.DOT + ConstantGlobal.AUTHENTICATION);

    public static final String USER_SERVICE_USER_AUTHENTICATION_ACTION = RabbitMQUtil.getAction(ConstantGlobal.AUTHENTICATION,
            ConstantGlobal.USER);
    public static final String USER_SERVICE_USER_AUTHENTICATION_ROUTING =
            RabbitMQUtil.getRoutingKey(SEARCH_SERVICE, USER_SERVICE_USER_AUTHENTICATION_ACTION);
    public static final String USER_SERVICE_USER_AUTHENTICATION_QUEUE = USER_SERVICE_USER_AUTHENTICATION_ACTION;

//    ----------------------------------- WatchMovieGN-User ----------------------------------------------
    // @formatter:on


    // @formatter:off
//    ----------------------------------- WatchMovieGN-Search ----------------------------------------------

    public static final String SEARCH_SERVICE_MOVIE_CRUD_EXCHANGE
            = RabbitMQUtil.getExchange(SEARCH_SERVICE,
        ConstantGlobal.MOVIE + ConstantGlobal.DOT + ConstantGlobal.CRUD);

    public static final String SEARCH_SERVICE_MOVIE_CREATE_ACTION = RabbitMQUtil.getAction(ConstantGlobal.CREATE, ConstantGlobal.MOVIE);
    public static final String SEARCH_SERVICE_MOVIE_CREATE_ROUTING =
            RabbitMQUtil.getRoutingKey(SEARCH_SERVICE, SEARCH_SERVICE_MOVIE_CREATE_ACTION);
    public static final String SEARCH_SERVICE_MOVE_CREATE_QUEUE = SEARCH_SERVICE_MOVIE_CREATE_ACTION;
//    ----------------------------------- WatchMovieGN-Search ----------------------------------------------
    // @formatter:on
}
