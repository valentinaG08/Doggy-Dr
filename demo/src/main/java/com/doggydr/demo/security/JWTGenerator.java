package com.doggydr.demo.security;

import java.security.Key;
import java.util.Date;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JWTGenerator {

    private static final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS512);
    public static final Long EXPIRATION_TIME = 7000000L;

    /* Crear el JWT */
    public String generateToken(Authentication authentication) {
        // Cambiamos para manejar el principal como String directamente
        String username = authentication.getName();
        
        Date currentDate = new Date();
        Date expireDate = new Date(currentDate.getTime() + EXPIRATION_TIME);

        /* Crear el JWT */
        return Jwts.builder()
            .setSubject(username)
            .setIssuedAt(currentDate)
            .setExpiration(expireDate)
            .signWith(key, SignatureAlgorithm.HS512)
            .compact();
    }

    /* Método para obtener el usuario a partir del JWT */
    public String getUserFromJwt(String token) {
        return Jwts.parserBuilder()
            .setSigningKey(key)
            .build()
            .parseClaimsJws(token)
            .getBody()
            .getSubject();
    }

    /* Método para validar el JWT */
    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
