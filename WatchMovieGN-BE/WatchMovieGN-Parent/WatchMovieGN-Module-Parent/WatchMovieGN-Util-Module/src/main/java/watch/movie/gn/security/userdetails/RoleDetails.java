package watch.movie.gn.security.userdetails;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

@Data
public class RoleDetails implements GrantedAuthority {

    private String role;
    @Override
    public String getAuthority() {
        return role;
    }
}
