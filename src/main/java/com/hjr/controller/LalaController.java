package com.hjr.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LalaController {

    @GetMapping("/lala")
    public String lala() {
        return "lala";
    }
}
