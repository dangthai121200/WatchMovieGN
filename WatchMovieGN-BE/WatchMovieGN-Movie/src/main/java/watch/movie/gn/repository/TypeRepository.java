package watch.movie.gn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jakarta.transaction.Transactional;
import watch.movie.gn.entity.Type;

@Transactional
public interface TypeRepository extends JpaRepository<Type, Integer> {

}
