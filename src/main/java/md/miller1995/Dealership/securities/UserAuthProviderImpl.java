package md.miller1995.Dealership.securities;

import md.miller1995.Dealership.services.users.UserAuthDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class UserAuthProviderImpl implements AuthenticationProvider {

    private final UserAuthDetailsServiceImpl userAuthDetailsServiceImpl;

    @Autowired
    public UserAuthProviderImpl(UserAuthDetailsServiceImpl userAuthDetailsServiceImpl) {
        this.userAuthDetailsServiceImpl = userAuthDetailsServiceImpl;
    }


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        // logic for authentication
        String username = authentication.getName();

        UserDetails userDetails = userAuthDetailsServiceImpl.loadUserByUsername(username);

        String password = authentication.getCredentials().toString();

        if (!password.equals(userDetails.getPassword())){
            throw new BadCredentialsException("Incorrect password!");
        }
        return new UsernamePasswordAuthenticationToken(userDetails, password, Collections.emptyList());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}