package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    @RequestMapping("/testDemo")
    public String testDemo(){
        System.out.println("111111111111111");
        return "rrrrrr";
    }
}
