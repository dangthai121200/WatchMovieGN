package watch.movie.gn.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import watch.movie.gn.entity.Role;
import watch.movie.gn.enums.RoleEnum;
import watch.movie.gn.repository.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepository roleRepository;

	@Override
	public void updateRoleEnumsIntoDatabase() {
		List<Role> roles = new ArrayList<>();
		for (RoleEnum roleEnum : RoleEnum.values()) {
			Role role = new Role();
			role.setPkIdRole(roleEnum.getPkIdRole());
			role.setName(roleEnum.getName());
			roles.add(role);
		}
		roleRepository.saveAll(roles);
	}

}
