package com.example.gymapp.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleController {

    @PostMapping("/addLitigation")
    public String example(){
        System.out.println("vijay jangid 222");
        return "vijayAPI";
    }

}
