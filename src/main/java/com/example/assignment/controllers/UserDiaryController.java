package com.example.assignment.controllers;

import com.example.assignment.model.Diary;
import com.example.assignment.model.User;
import com.example.assignment.services.UserDiaryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserDiaryController {

    private UserDiaryService service;

    public UserDiaryController(UserDiaryService service) {
        this.service = service;
    }


    @GetMapping("/diaries")
    public String viewDiaries(Model model) {
        model.addAttribute("diaries", service.findAllDiaries());
        return "diaries";
    }

    @GetMapping("/diaries/add")
    public String showAddDiaryForm(Model model) {
        model.addAttribute("users", service.findAllUsers());
        return "add-diaries";
    }

    @PostMapping("/diaries/add")
    public String addDiary(@RequestParam String userId,
                           @RequestParam String userName,
                           @RequestParam String email,
                           @RequestParam String title,
                           @RequestParam String content,
                           @RequestParam String date) {
        User user = new User(userId, userName, email);
        service.addUser(user);
        Diary diary = new Diary(title, content, date, user);
        service.addDiary(diary);
        return "redirect:/add/success/diary";
    }

    @GetMapping("/add/success/{entityName}")
    public String addSuccess(@PathVariable String entityName, Model model) {
        model.addAttribute("entityName", entityName);
        return "success";
    }
}
