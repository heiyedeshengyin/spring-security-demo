package com.hjr.utils;

import io.jsonwebtoken.Claims;
import org.junit.jupiter.api.Test;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;

public class JwtUtilTest {

    @Test
    public void getUUIDTest() {
        System.out.println(JwtUtil.getUUID());
    }

    @Test
    public void generalKeyTest() {
        SecretKey secretKey = JwtUtil.secretKey;
        System.out.println(secretKey.getEncoded().length);
        System.out.println(secretKey);
    }

    @Test
    public void createJWTTest() throws Exception {
        SecretKey secretKey = JwtUtil.secretKey;
        String secretKeyEncoded = new String(secretKey.getEncoded(), StandardCharsets.US_ASCII);
        System.out.println(secretKey.getEncoded().length);
        System.out.println(secretKeyEncoded);
        String jwt = JwtUtil.createJWT("2133");
        System.out.println(jwt);
        Claims claims = JwtUtil.parseJWT(jwt);
        System.out.println(claims.getSubject());
    }

    @Test
    public void parseJWTTest() {
        try {
            Claims claims = JwtUtil.parseJWT("eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIyZTAxYjg4NzQwODY0Yjc1OTUxZjRmNjBiNWEzMmM5MCIsInN1YiI6IjIxMjMiLCJpc3MiOiJoanIiLCJpYXQiOjE2ODAxOTA0MTAsImV4cCI6MTY4MDE5NDAxMH0.WzQHvuWlgjsGzFsqIgEEsQuHdHMKp8vAiyfUpPQMbac");
            System.out.println(claims.getSubject());
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
