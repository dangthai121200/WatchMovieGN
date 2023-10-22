package watch.movie.gn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jakarta.transaction.Transactional;
import watch.movie.gn.entity.Role;

@Transactional
public interface RoleRepository extends JpaRepository<Role, Integer> {

}
