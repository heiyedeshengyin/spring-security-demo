package com.hjr.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    @PreAuthorize("hasAuthority('hello')")
    public String hello() {
        return "hello";
    }
}
