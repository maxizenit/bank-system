package ru.maxizenit.banksystem.userservice.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.time.Duration;
import java.util.Date;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.maxizenit.banksystem.userservice.entity.User;

@Component
public class JwtTokenUtils {

  @Value("${jwt.secret}")
  private String secret;

  @Value("${jwt.lifetime}")
  private Duration lifetime;

  public String generateToken(User user) {
    Date issuedDate = new Date();
    Date expiredDate = new Date(issuedDate.getTime() + lifetime.toMillis());

    return Jwts.builder()
        .setSubject(user.getEmail())
        .setIssuedAt(issuedDate)
        .setExpiration(expiredDate)
        .signWith(SignatureAlgorithm.HS256, secret)
        .claim("id", user.getId())
        .compact();
  }

  public String getUsernameFromToken(String token) {
    return getClaimsFromToken(token).getSubject();
  }

  private Claims getClaimsFromToken(String token) {
    return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
  }
}
