package com.asupranovich.expense.tracker.web.jwt;

import com.asupranovich.expense.tracker.domain.model.Person;
import com.asupranovich.expense.tracker.domain.service.PersonService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.Date;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

@RequiredArgsConstructor
public class JwtFilter extends OncePerRequestFilter {

    private final JwtHelper jwtHelper;

    private final PersonService personService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
        throws ServletException, IOException {
        String header = request.getHeader("Authorization");
        if (header != null && header.startsWith("Bearer ") && SecurityContextHolder.getContext().getAuthentication() == null) {
            String token = header.substring(7);
            try {
                authenticateByToken(token);
            } catch (Exception e) {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                return;
            }
        }
        filterChain.doFilter(request, response);
    }

    private void authenticateByToken(String token) {
        Claims tokenClaims = jwtHelper.getTokenClaims(token);
        if (tokenClaims != null && isValid(tokenClaims)) {
            Person person = getPerson(tokenClaims);
            Authentication authentication = new UsernamePasswordAuthenticationToken(person, null, Collections.emptyList());
            SecurityContextHolder.getContext().setAuthentication(authentication);
        } else {
            throw new JwtException("Token is invalid or expired");
        }
    }

    private boolean isValid(Claims tokenClaims) {
        Date now = new Date();
        return now.before(tokenClaims.getExpiration());
    }

    private Person getPerson(Claims tokenClaims) {
        //TODO: move to jwtHelper?
        return Optional.ofNullable(tokenClaims.get("personId", Long.class))
            .flatMap(personService::findById)
            .orElseThrow();
    }
}
