package com.asupranovich.expense.tracker.web.configuration;

import com.asupranovich.expense.tracker.domain.service.PersonService;
import com.asupranovich.expense.tracker.web.jwt.JwtFilter;
import com.asupranovich.expense.tracker.web.jwt.JwtHelper;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration(proxyBeanMethods = false)
@EnableWebSecurity
public class ExpenseTrackerSecurityConfiguration {

    @Bean
    public JwtHelper jwtHelper(@Value("${jwt.secret-key}") String secretKey) {
        return new JwtHelper(secretKey);
    }

    @Bean
    public JwtFilter jwtFilter(JwtHelper jwtHelper, PersonService personService) {
        return new JwtFilter(jwtHelper, personService);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, JwtFilter jwtFilter) throws Exception {
        http
            .csrf(AbstractHttpConfigurer::disable)
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/authenticate").permitAll()
                .requestMatchers("/signup").permitAll()
                .anyRequest().authenticated()
            )
            .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

}
