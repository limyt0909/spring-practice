package com.example.demo.controller;

import com.example.demo.service.DemoService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/demo")
public class DemoController {

    private final DemoService demoService;

    public DemoController(DemoService demoService) {
        this.demoService = demoService;
    }

    @GetMapping("/test2")
    public String sayHello2() {
        return demoService.getHelloMessage("ssss");
    }

    @GetMapping("/test")
    public String sayHello(@RequestParam(required = false, defaultValue = "Guest") String name) {
        return demoService.getHelloMessage(name);
    }
}
