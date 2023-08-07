package lt.codeAcademy.AukcionoAPI.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class AuthConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/buyer**").permitAll() // Everyone can access all /exams EPs
                .anyRequest().authenticated()
                .and()
                .httpBasic();
        return http.build();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails admin = User
                .withUsername("admin")
                .password(passwordEncoder().encode("admin1"))
                .roles("ADMIN")
                .build();

        UserDetails buyer = User
                .withUsername("buyer")
                .password(passwordEncoder().encode("buyer1"))
                .roles("BUYER")
                .build();

        UserDetails seller = User
                .withUsername("seller")
                .password(passwordEncoder().encode("seller1"))
                .roles("SELLER")
                .build();

        UserDetails guest = User
                .withUsername("guest")
                .password(passwordEncoder().encode("guest1"))
                .roles("GUEST")
                .build();

        return new InMemoryUserDetailsManager(admin, buyer, seller, guest);
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(8);
    }

}
