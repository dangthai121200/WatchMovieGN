package watch.movie.gn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import watch.movie.gn.entity.Producer;

@Repository
public interface ProducerRepository extends JpaRepository<Producer, Integer> {

}
