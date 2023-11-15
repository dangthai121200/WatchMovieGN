package watch.movie.gn.service;

import watch.movie.gn.domain.country.GetAllCountryResponse;
import watch.movie.gn.domain.type.GetAllMovieTypeDomain;

public interface MovieTypeService {
    GetAllMovieTypeDomain getAllMovieType();

    void updateMovieTypeEnumsIntoDatabase();
}
