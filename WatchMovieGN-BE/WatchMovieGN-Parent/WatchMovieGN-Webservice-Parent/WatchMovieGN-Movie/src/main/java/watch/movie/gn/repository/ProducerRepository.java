package watch.movie.gn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import watch.movie.gn.entity.Producer;

public interface ProducerRepository extends JpaRepository<Producer, Integer> {

}
