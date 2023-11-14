package watch.movie.gn.enums;

import lombok.Getter;

@Getter
public enum RoleEnum {
	ADMIN(1, "ADMIN");

	private int pkIdRole;
	private String name;

	private RoleEnum(int pkIdRole, String name) {
		this.pkIdRole = pkIdRole;
		this.name = name;
	}

}
