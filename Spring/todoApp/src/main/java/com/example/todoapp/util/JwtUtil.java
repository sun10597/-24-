package com.example.todoapp.util;

import org.springframework.stereotype.Component;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class JwtUtil {
    private static final String SECRET= "my-secret-key";
    private static final long EXPIRATION_TIME=1000*60*60;
    private final ConcurrentHashMap<String, Boolean> invalidTokens = new ConcurrentHashMap<>();

    //JWT생성
    public String generateToken(Long userId){
        return JWT.create()
                .withSubject(String.valueOf(userId))
                .withExpiresAt(new Date(System.currentTimeMillis()+EXPIRATION_TIME))
                .sign(Algorithm.HMAC256(SECRET));
    }
    //JWT검증 및 사용자 ID 반환
    public Long validateToken(String token){
        try{
            if (invalidTokens.containsKey(token)) {
                return null;
            }
            DecodedJWT decodedJWT = JWT.require(Algorithm.HMAC256(SECRET)).build().verify(token);
            return Long.parseUnsignedLong(decodedJWT.getSubject());
        }catch (Exception e){
            return null;
        }
    }

    //JWT무효화
    public void invalidateToken(String token){
        invalidTokens.put(token, true);
    }
}
