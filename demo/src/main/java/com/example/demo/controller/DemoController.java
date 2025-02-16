package com.example.demo.controller;

import com.example.demo.service.DemoService;

import io.swagger.v3.oas.annotations.Operation;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/demo")public class DemoController {

    private final DemoService demoService;

    public DemoController(DemoService demoService) {
        this.demoService = demoService;
    }

        @Operation(summary = "테스트 API 2", description = "redis save test.")

    @PostMapping("/redis/save")
    public String saveToRedis(@RequestParam String key, @RequestParam String value) {
        demoService.saveToRedis(key, value);
        return "Saved!";
    }

    
        @Operation(summary = "테스트 API 1", description = "redis get test2")

    @GetMapping("/redis/get")
    public String getFromRedis(@RequestParam String key) {
        String value = demoService.getFromRedis(key);
        return value != null ? "Value: " + value : "Key not found!";
    }
}