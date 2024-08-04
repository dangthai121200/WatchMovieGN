package watch.movie.gn.domain.movie;

import java.util.Date;

import lombok.Data;
import watch.movie.gn.domain.country.CountryDomain;
import watch.movie.gn.domain.producer.ProducerDomain;
import watch.movie.gn.domain.season.SeasonDomain;
import watch.movie.gn.domain.type.MovieTypeDomain;
import watch.movie.gn.enums.MovieStatusEnums;

@Data
public class CreateMovieRequest {


    private String name;
    private int view;
    private Date yearOfBroadcast;
    private String urlImage;
    private String content;
    private MovieStatusEnums status = MovieStatusEnums.NEW;
    private Integer time;
    private CountryDomain country;
    private ProducerDomain producer;
    private SeasonDomain season;
    private MovieTypeDomain type;
}
