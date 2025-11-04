package com.asupranovich.expense.tracker.web.jwt;

import com.asupranovich.expense.tracker.domain.model.Person;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import javax.crypto.SecretKey;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class JwtHelper {

    private static final long EXPIRATION_TIME = 36_000_000; // 10 hours

    private final String secretKey;

    public String generateToken(Person person) {
        return Jwts.builder()
            .subject(person.getEmail())
            .claim("roles", "USER")
            .claim("personId", person.getId())
            .claim("householdId", person.getHouseholdId())
            .issuedAt(new Date())
            .expiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
            .signWith(getSigningKey())
            .compact();
    }

    public String getPersonEmail(String token) {
        return Jwts.parser()
            .verifyWith(getSigningKey())
            .build()
            .parseSignedClaims(token)
            .getPayload()
            .getSubject();
    }

    public Claims getTokenClaims(String token) {
        return Jwts.parser()
            .verifyWith(getSigningKey())
            .build()
            .parseSignedClaims(token)
            .getPayload();
    }

    private SecretKey getSigningKey() {
        try {
            // Hash the secret key to ensure it's at least 256 bits (32 bytes) for HS256
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(secretKey.getBytes(StandardCharsets.UTF_8));
            return Keys.hmacShaKeyFor(hash);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Failed to create signing key", e);
        }
    }

}
