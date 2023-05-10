package md.miller1995.Dealership.configs;

import md.miller1995.Dealership.securities.UserAuthDetailsProviderImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final UserAuthDetailsProviderImpl userAuthDetailsProvider;

    @Autowired
    public SecurityConfig(UserAuthDetailsProviderImpl authProvider) {
        this.userAuthDetailsProvider = authProvider;
    }

    // config HTTP security
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authenticationProvider(userAuthDetailsProvider);

        http.csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("/auth/login", "/auth/registration", "/error")
                .permitAll()
                .anyRequest()
                .authenticated()
                    .and()
                    .formLogin()
                    .loginPage("/auth/login")
                    .defaultSuccessUrl("/api/users", true)
                    .failureUrl("/auth/login")
                        .and()
                        .httpBasic();

        return http.build();
    }
}
