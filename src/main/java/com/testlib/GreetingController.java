package com.testlib;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/test-lib")
public class GreetingController {

    private final GreetingService greetingService;

    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping({"", "/"})
    public ResponseEntity<Void> serveUI() {
        return ResponseEntity.status(302)
                .location(URI.create("/test-lib/index.html"))
                .build();
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
