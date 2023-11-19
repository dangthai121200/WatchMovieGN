package watch.movie.gn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jakarta.transaction.Transactional;
import watch.movie.gn.entity.Season;

@Transactional
public interface SeasonRepository extends JpaRepository<Season, Integer> {

}