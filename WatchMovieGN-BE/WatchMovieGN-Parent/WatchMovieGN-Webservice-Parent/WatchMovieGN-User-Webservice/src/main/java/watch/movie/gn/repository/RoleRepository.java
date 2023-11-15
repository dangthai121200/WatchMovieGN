package watch.movie.gn.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import watch.movie.gn.entity.Role;

@Transactional
public interface RoleRepository extends JpaRepository<Role, Integer> {

}
