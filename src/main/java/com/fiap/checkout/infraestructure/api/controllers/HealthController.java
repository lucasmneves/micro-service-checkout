package com.fiap.checkout.infraestructure.api.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HealthController {
    @GetMapping("/healthz")
    public ResponseEntity<String> healthz() {
        return ResponseEntity.ok("Health check OK");
    }

    @GetMapping("/readyz")
    public ResponseEntity<String> readyz() {
        return ResponseEntity.ok("Readiness check OK");
    }
}