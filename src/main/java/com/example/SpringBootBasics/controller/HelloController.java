package com.example.SpringBootBasics.controller;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Component
public class HelloController {

    @GetMapping("/")
    public String helloWorld(){
        return "Hello from spring-boot for second ";
    }
}
