package watch.movie.gn.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import watch.movie.gn.entity.RequestHistoryEntity;

@Transactional
public interface RequestHistoryRepository extends JpaRepository<RequestHistoryEntity, String> {
}
