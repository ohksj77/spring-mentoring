package com.example.board.hello;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/")
public class HelloController {

    @GetMapping
    public String hello() {
        return "hello spring!";
    }

    @GetMapping("/{num}")
    public Integer plusOne(@PathVariable Integer num) {
        log.info("{} + 1 = {}", num, (num + 1));
        return num + 1;
    }

    @GetMapping("/{a}/{b}")
    public Hello getHello(@PathVariable Integer a, @PathVariable Integer b) {
        return new Hello(a, b);
    }

    @PostMapping
    public Hello postHello(@RequestBody Hello hello) {
        return hello;
    }
}
