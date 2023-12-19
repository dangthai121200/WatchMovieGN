package watch.movie.gn.security.userdetails;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;

@Data
public class AccountDetails implements UserDetails {

    private String password;

    private final String username;

    private final Set<GrantedAuthority> authorities;

    private final boolean accountNonExpired;

    private final boolean accountNonLocked;

    private final boolean credentialsNonExpired;

    private final boolean enabled;

    public AccountDetails(String password, String username, Set<GrantedAuthority> authorities, boolean accountNonExpired, boolean accountNonLocked, boolean credentialsNonExpired, boolean enabled) {
        this.password = password;
        this.username = username;
        this.authorities = authorities;
        this.accountNonExpired = accountNonExpired;
        this.accountNonLocked = accountNonLocked;
        this.credentialsNonExpired = credentialsNonExpired;
        this.enabled = enabled;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    public static class AccountDetailsBuilder {

        private String password;

        private String username;

        private Set<GrantedAuthority> authorities;

        private boolean accountNonExpired;

        private boolean accountNonLocked;

        private boolean credentialsNonExpired;

        private boolean enabled;

        public AccountDetailsBuilder setPassword(String password) {
            this.password = password;
            return this;
        }

        public AccountDetailsBuilder setUsername(String username) {
            this.username = username;
            return this;
        }

        public AccountDetailsBuilder setAuthorities(Set<GrantedAuthority> authorities) {
            this.authorities = authorities;
            return this;
        }

        public AccountDetailsBuilder setAccountNonExpired(boolean accountNonExpired) {
            this.accountNonExpired = accountNonExpired;
            return this;
        }

        public AccountDetailsBuilder setAccountNonLocked(boolean accountNonLocked) {
            this.accountNonLocked = accountNonLocked;
            return this;
        }

        public AccountDetailsBuilder setCredentialsNonExpired(boolean credentialsNonExpired) {
            this.credentialsNonExpired = credentialsNonExpired;
            return this;
        }

        public AccountDetailsBuilder setEnabled(boolean enabled) {
            this.enabled = enabled;
            return this;
        }

        public AccountDetails build() {
            return new AccountDetails(this.password, this.username, this.authorities, this.accountNonExpired, this.accountNonLocked, this.credentialsNonExpired, this.enabled);
        }
    }
}
