package com.example.assignment.controllers;

import com.example.assignment.services.UserDiaryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    private UserDiaryService services;

    @RequestMapping("/index")
    public String homePage(){
        return "index.html";
    }
}
