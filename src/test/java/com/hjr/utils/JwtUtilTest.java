package com.hjr.utils;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.junit.jupiter.api.Test;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.*;

public class JwtUtilTest {

    @Test
    public void getUUIDTest() {
        System.out.println(JwtUtil.getUUID());
    }

    @Test
    public void generalKeyTest() {
        SecretKey secretKey = JwtUtil.generalKey();
        System.out.println(secretKey.getEncoded().length);
    }

    @Test
    public void createJWTTest() {
        SecretKey secretKey = JwtUtil.generalKey();
        System.out.println(secretKey.getEncoded().length);
        String jwt = JwtUtil.createJWT("2133534523");
        System.out.println(jwt);
        Claims claims = JwtUtil.parseJWT(jwt);
        System.out.println(claims.getSubject());
    }

    @Test
    public void parseJWTTest() {
        Claims claims = JwtUtil.parseJWT("eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI2N2IyZWQ2NjFmNDY0ZmVhODM4ODU2ZDg1YjJhNTI3OCIsInN1YiI6IjIxMzM1MzQ1MjMiLCJpc3MiOiJoanIiLCJpYXQiOjE2ODAyMjczNTEsImV4cCI6MTY4MDIzMDk1MX0.EP6HG40Wk18wpTAEQD2QoEKcLiiIyyavgwWx1tesoKo");
        System.out.println(claims.getSubject());
        System.out.println(claims.getId());
        System.out.println(claims.getIssuer());
    }

    @Test
    public void test1() {
        SecretKey secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);
        String secretKeyEncoded = Base64.getUrlEncoder().encodeToString(secretKey.getEncoded());
        System.out.println(secretKeyEncoded);
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        System.out.println(uuid);
        long nowMillis = System.currentTimeMillis();
        long expMillis = nowMillis + 60 * 60 * 1000L;
        Date now = new Date(nowMillis);
        System.out.println(now);
        Date exp = new Date(expMillis);
        System.out.println(exp);
        Map<String, Object> map = new HashMap<>();
        map.put("name", "zhangsan");
        map.put("age", 18);
        JwtBuilder jwtBuilder = Jwts.builder()
                .setId(uuid)
                .setSubject("lalala")
                .setIssuer("hjr")
                .setIssuedAt(now)
                .setExpiration(exp)
                .addClaims(map)
                .setHeaderParam("typ", "JWT")
                .signWith(secretKey, SignatureAlgorithm.HS256);
        String compact = jwtBuilder.compact();
        System.out.println(compact);
    }

    @Test
    public void test2() {
        String encodedKeyString = "cBwrdpZtFSCW-9-Qk4s8iDnMa8C87s7a_DxwGjJAZOE=";
        String uuid = "40b1f983b2034c238ba9ef6b125a952f";
        String jwt = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI0MGIxZjk4M2IyMDM0YzIzOGJhOWVmNmIxMjVhOTUyZiIsInN1YiI6ImxhbGFsYSIsImlzcyI6ImhqciIsImlhdCI6MTY4MDIyNjYyMCwiZXhwIjoxNjgwMjMwMjIwLCJuYW1lIjoiemhhbmdzYW4iLCJhZ2UiOjE4fQ.4sTWJHy2CwW-rpIEIHbmOnoCGoIiTVzuG_IcsqgInWM";
        byte[] keyArray = Base64.getUrlDecoder().decode(encodedKeyString);
        System.out.println(keyArray.length);
        SecretKey key = new SecretKeySpec(keyArray, 0 , keyArray.length, "HmacSHA256");
        JwtParser parser = Jwts.parserBuilder().setSigningKey(key).build();
        Jws<Claims> claimsJws = parser.parseClaimsJws(jwt);
        Claims body = claimsJws.getBody();
        JwsHeader header = claimsJws.getHeader();
        System.out.println(header.getAlgorithm());
        System.out.println(header.get("typ"));
        System.out.println(body.getId());
        System.out.println(body.getSubject());
        System.out.println(body.getIssuer());
        System.out.println(body.get("name"));
        System.out.println(body.get("age"));
    }
}
