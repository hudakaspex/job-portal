package com.job.portal.Jobportal.Security.utlis;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.function.Function;

@Component
public class JwtUtil {

    private final String SCRET_KEY = ")a0APpaw72$1";

    public String extractUsername(String token) {
        return extraClaim(token, Claims::getSubject);
    }

    public Date extraExpiration(String token) {
        return extraClaim(token, Claims::getExpiration);
    }

    private <T> T extraClaim(String token, Function<Claims, T> claimResolver) {
        final Claims claims = extractAllClaim(token);
        return claimResolver.apply(claims);
    }

    private Claims extractAllClaim(String token) {
        return Jwts.parser().setSigningKey(SCRET_KEY).parseClaimsJws(token).getBody();
    }

    private Boolean isTokenExpired(String token) {
        return extraExpiration(token).before(new Date());
    }

    public String generateToken(String username) {
        var claims = new HashMap<String, Object>();
        int twelveHour = 1000 * 60 * 60 * 12;
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + twelveHour))
                .signWith(SignatureAlgorithm.HS256, SCRET_KEY)
                .compact();
    }

}
