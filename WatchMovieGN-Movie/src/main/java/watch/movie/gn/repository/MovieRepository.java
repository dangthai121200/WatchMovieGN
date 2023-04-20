package watch.movie.gn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import watch.movie.gn.entity.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {

}