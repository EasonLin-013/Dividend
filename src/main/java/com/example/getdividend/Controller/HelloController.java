package com.example.getdividend.Controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//@OpenAPIDefinition(info = @Info(title = "Ruyut Example", version = "1.0.0"))
@RestController
@Tag(name = "Hello")
public class HelloController {
//    @RequestMapping(value = "/")
//    public String spring() {
//        return "Spring Boot!!";
//    }
//
//    @RequestMapping(value = "/hello")
//    public String hello() {
//        return "Hello World!!";
//    }

    @GetMapping("hello")
    @Operation(summary = "測試", description = "Creates a new book")
    public String Hello() {
        return "Hello";
    }
}