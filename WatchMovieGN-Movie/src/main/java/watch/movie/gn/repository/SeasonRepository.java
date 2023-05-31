package watch.movie.gn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;
import watch.movie.gn.entity.Season;

@Repository
@Transactional
public interface SeasonRepository extends JpaRepository<Season, Integer> {

}
