package com.testlib;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test-lib")
public class GreetingController {

    private final GreetingService greetingService;

    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping("/greet/{name}")
    public String greet(@PathVariable String name) {
        return greetingService.greet(name);
    }

    @GetMapping("/shout/{name}")
    public String shout(@PathVariable String name) {
        return greetingService.shout(name);
    }
}
