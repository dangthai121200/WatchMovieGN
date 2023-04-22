package watch.movie.gn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import watch.movie.gn.entity.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {

}
