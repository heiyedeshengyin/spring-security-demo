package com.hjr.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
public class PasswordEncoderTest {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    public void passwordEncodeTest() {
        System.out.println(passwordEncoder.encode("123456"));
        System.out.println(passwordEncoder.encode("123456"));
    }

    @Test
    public void passwordMatchesTest() {
        System.out.println(passwordEncoder.matches("123456", "$2a$10$ig3bV3lJmKpoDgl/x4khQehcvI5EH0JblgyqLxRCbYygDnWfgyPPq"));
    }
}
