package com.example.assignment.controllers;

import com.example.assignment.services.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @Autowired
    private Services services;

    @RequestMapping("/index")
    public String homePage(){
        return "index.html";
    }
}
