package watch.movie.gn.domain.movie;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import watch.movie.gn.domain.country.CountryDomain;
import watch.movie.gn.domain.producer.ProducerDomain;
import watch.movie.gn.domain.season.SeasonDomain;
import watch.movie.gn.domain.type.MovieTypeDomain;
import watch.movie.gn.enums.MovieStatusEnums;

@Data
public class MovieDomain implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 4781495224864878832L;

    private int pkIdMovie;
    private String name;
    private Date yearOfBroadcast;
    private int view;
    private String urlImage;
    private MovieStatusEnums status;
    private Integer time;
    private SeasonDomain season;
    private CountryDomain country;
    private ProducerDomain producer;
    private MovieTypeDomain type;

}
