package net.java.todo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.DefaultSecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SpringSecurityConfig {

    @Bean
    public static PasswordEncoder passwordEncoder(){

        return new BCryptPasswordEncoder();

    }

    @Bean
    DefaultSecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{

        http.csrf((csrf) -> csrf.disable()).authorizeHttpRequests((authorize)->{
//            authorize.requestMatchers(HttpMethod.POST, "/api/**").hasRole("ADMIN");
//            authorize.requestMatchers(HttpMethod.PUT, "/api/**").hasRole("ADMIN");
//            authorize.requestMatchers(HttpMethod.DELETE, "/api/**").hasRole("ADMIN");
//            authorize.requestMatchers(HttpMethod.GET, "/api/**").hasAnyRole("ADMIN", "USER");
//            authorize.requestMatchers(HttpMethod.PATCH, "/api/**").hasAnyRole("ADMIN", "USER");

            authorize.anyRequest().authenticated();
        }).httpBasic(Customizer.withDefaults());

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService(){

        UserDetails JoJo = User.builder()
                .username("jojo")
                .password(passwordEncoder().encode("admin"))
                .roles("USER")
                .build();

        UserDetails admin = User.builder()
                .username("admin")
                .password(passwordEncoder().encode("admin2"))
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(JoJo, admin);
    }
}
