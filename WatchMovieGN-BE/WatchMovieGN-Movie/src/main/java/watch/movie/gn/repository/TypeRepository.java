package watch.movie.gn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;
import watch.movie.gn.entity.Type;

@Repository
@Transactional
public interface TypeRepository extends JpaRepository<Type, Integer> {

}
