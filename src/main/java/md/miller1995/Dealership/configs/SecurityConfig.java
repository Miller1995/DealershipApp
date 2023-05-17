package md.miller1995.Dealership.configs;

import md.miller1995.Dealership.securities.UserAuthProviderImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
public class SecurityConfig {

    private final UserAuthProviderImpl userAuthDetailsProvider;

    @Autowired
    public SecurityConfig(UserAuthProviderImpl authProvider) {
        this.userAuthDetailsProvider = authProvider;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authenticationProvider(userAuthDetailsProvider);

        http
            .csrf().disable()
            .authorizeHttpRequests()
            .requestMatchers("/auth/login", "/auth/registration", "/error").permitAll()
            .anyRequest().hasAnyRole("USER", "ADMIN")
                .and()
                .formLogin()
                .loginPage("/auth/login")
                .defaultSuccessUrl("/api/users", true)
                .failureUrl("/auth/login")
                    .and()
                    .logout()
                    .logoutUrl("/logout")
                    .invalidateHttpSession(true)
                    .logoutSuccessUrl("/auth/login")
                    .deleteCookies("JSESSIONID")
                        .and()
                        .httpBasic();
        return http.build();
    }
}