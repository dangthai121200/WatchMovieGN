package watch.movie.gn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jakarta.transaction.Transactional;
import watch.movie.gn.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer> {

}
