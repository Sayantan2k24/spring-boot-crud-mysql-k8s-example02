package com.javatechie.crud.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    private static final String VERSION = "v1.1.0"; // change this per version

    @GetMapping("/health")
    public String healthCheck() {
        return "Service is up and running! Version: " + VERSION;
    }
}
