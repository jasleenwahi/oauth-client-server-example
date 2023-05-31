package com.knoldus.resourcesercer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ResourceServerConfig {

    /**
     * Configures the security filter chain for the HTTP requests.
     *
     * @param http The HttpSecurity object used to configure security settings
     * @return The configured SecurityFilterChain
     * @throws Exception if an error occurs during the configuration
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((authorize)->authorize
                .anyRequest().authenticated()).httpBasic(Customizer.withDefaults());
        return http.build();

    }
}
