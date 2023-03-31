package com.hjr.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HjrController {

    @GetMapping("/hjr")
    public String hjr() {
        return "hjr";
    }
}
