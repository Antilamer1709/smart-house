package com.smarthouse.usermanagement.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;


@Configuration
@EnableWebSecurity
class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // Enable CORS and disable CSRF
        http = http.cors().and().csrf().disable();

        // Set session management to stateless
        http = http.sessionManagement()
                .sessionCreationPolicy(STATELESS)
                .and();

        // Set permissions on endpoints
        http.authorizeHttpRequests()
                .requestMatchers("api/users/**")
                .hasRole("USER")
                .anyRequest().authenticated();

        http.oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt);

        return http.build();
    }
}