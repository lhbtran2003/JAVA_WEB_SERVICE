package liliana.session_15.security.jwt;

import io.jsonwebtoken.*;
import liliana.session_15.security.principle.UserDetail;
import liliana.session_15.security.principle.UserDetail;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Slf4j
public class JwtProvider {
    @Value("${security.jwt.secret-key}")
    private String secretKey;
    @Value("${security.jwt.expiration-time}")
    private long expirationTime;

    // tạo token
    public String generateJwtToken(liliana.session_15.security.principle.UserDetail userDetail) {
        Map<String, Object> claims = new HashMap<>();

        List<String> roles = userDetail.getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .toList();
        claims.put("roles", roles);

        Date today = new Date();
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(userDetail.getUsername())
                .setIssuedAt(today)
                .setExpiration(new Date(today.getTime() + expirationTime))
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    // validate token
    public boolean validateJwtToken(String token) {
        // kiểm tra tính hợp lệ của token
        try {
            Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
            return true;
        } catch (ExpiredJwtException e) {
            log.error("JWT: message error expired:", e.getMessage());
        } catch (UnsupportedJwtException e) {
            log.error("JWT: message error unsupported:", e.getMessage());
        } catch (MalformedJwtException e) {
            log.error("JWT: message error not formated:", e.getMessage());
        } catch (SignatureException e) {
            log.error("JWT: message error signature not math:", e.getMessage());
        } catch (IllegalArgumentException e) {
            log.error("JWT: message claims empty or argument invalid: ", e.getMessage());
        }
        return false;
    }

    // lấy thông tin từ token
    public String getUsernameFromToken(String token) {
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
    }
}
