package watch.movie.gn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jakarta.transaction.Transactional;
import watch.movie.gn.entity.Country;

@Transactional
public interface CountryRepository extends JpaRepository<Country, Integer> {

}
