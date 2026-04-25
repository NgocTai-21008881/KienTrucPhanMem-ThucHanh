package com.movie.ticket.userservice.config;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtils {
    // Secret key (Trong thực tế nên để ở application.yml)
    private final String JWT_SECRET = "PhaiCoItNhat32KyTuChoSecretKeyNàyNheTeamOi";
    private final long JWT_EXPIRATION = 86400000L; // 1 ngày

    private final Key key = Keys.hmacShaKeyFor(JWT_SECRET.getBytes());

    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + JWT_EXPIRATION))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }
}
