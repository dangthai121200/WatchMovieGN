package watch.movie.gn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;
import watch.movie.gn.entity.Country;

@Repository
@Transactional
public interface CountryRepository extends JpaRepository<Country, Integer> {

}
