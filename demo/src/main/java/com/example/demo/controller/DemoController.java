package com.example.demo.controller;

import com.example.demo.service.DemoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/demo")
public class DemoController {

    private final DemoService demoService;

    public DemoController(DemoService demoService) {
        this.demoService = demoService;
    }

    @Operation(summary = "테스트 API 2", description = "고정값 'ssss'을 반환합니다.")
    @GetMapping("/test2")
    public String sayHello2() {
        return demoService.getHelloMessage("ssss");
    }

    @Operation(summary = "테스트 API", description = "Query Parameter로 전달된 name을 받아 메시지를 반환합니다.")
    @GetMapping("/test")
    public String sayHello(
            @Parameter(description = "사용자의 이름", example = "Zippity") @RequestParam(required = false, defaultValue = "Guest") String name) {
        return demoService.getHelloMessage(name);
    }
}
