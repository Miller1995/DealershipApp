package md.miller1995.Dealership.securities;

import md.miller1995.Dealership.models.entities.UserAuthEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class UserAuthDetails implements UserDetails {

    private final UserAuthEntity userAuthEntity;

    public UserAuthDetails(UserAuthEntity userAuthEntity) {
        this.userAuthEntity = userAuthEntity;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority(userAuthEntity.getUserRole()));
    }

    @Override
    public String getPassword() {
        return this.userAuthEntity.getUserPassword();
    }

    @Override
    public String getUsername() {
        return this.userAuthEntity.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    // need for get info/data about authenticated user
    public UserAuthEntity getUserEntity(){
        return this.userAuthEntity;
    }
}