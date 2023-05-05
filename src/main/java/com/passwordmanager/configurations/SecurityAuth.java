package com.passwordmanager.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import com.passwordmanager.services.UserDetailsServiceImpl;

@EnableWebSecurity
@Configuration
public class SecurityAuth {
    private final RequestMatcher[] ignoringRequestMatchers = {
            new AntPathRequestMatcher("/user", "POST")
    };

    @Autowired
    private UserDetailsServiceImpl userDetailsServiceImpl;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(csrf -> csrf
                        .ignoringRequestMatchers(ignoringRequestMatchers)
                        .ignoringRequestMatchers(
                                new AntPathRequestMatcher("/user/**/login", "PUT")))
                .authorizeHttpRequests(
                        auth -> auth
                                .requestMatchers(ignoringRequestMatchers)
                                .permitAll()
                                .anyRequest()
                                .authenticated())
                .userDetailsService(userDetailsServiceImpl)
                .formLogin()
                .and()
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
