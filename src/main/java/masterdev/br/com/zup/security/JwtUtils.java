package masterdev.br.com.zup.security;



import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class JwtUtils {
    public static String key = "6068e468-0ab2-4a86-a9ba-a5266ed0aa87";
    public static String createJWT(long id)  {
        return Jwts.builder().setIssuer("masterdev")
                .setSubject("game/"+id)
                .claim("id",id)
                .setExpiration(getExpirationTime())
                .signWith(SignatureAlgorithm.HS256,key)
                .compact();
    }
    public static  Date getExpirationTime(){
        LocalDateTime tomorrow = LocalDateTime.now().plus(1, ChronoUnit.DAYS);
        return Date.from(tomorrow.atZone(ZoneId.systemDefault()).toInstant());
    }

}

