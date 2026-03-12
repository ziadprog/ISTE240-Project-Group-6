package com.example.assignment.controllers;


import com.example.assignment.model.Article;
import com.example.assignment.model.mentalhealthservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ArticleController {
    private final mentalhealthservice service;

    public ArticleController(mentalhealthservice service) {
        this.service = service;
    }

    @GetMapping("/articles")
    public String viewArticles(Model model) {
        model.addAttribute("articles", service.getAllArticles());
        return "articles";
    }

    @GetMapping("/article/add")
    public String showAddForm() {
        return "add-article";
    }

    @PostMapping("/article/add")
    public String saveArticle(@ModelAttribute Article article) {
        service.addArticle(article);
        return "redirect:/articles";
    }
}

//@Controller
//public class ArticleController {
//    private final mentalhealthservice service;
//
//    public ArticleController(mentalhealthservice service) {
//        this.service = service;
//    }
//    @GetMapping("/articles")
//    public String viewArticles(Model model) {
//        // This pulls the preset articles created in the service constructor
//        model.addAttribute("articles", service.getAllArticles());
//        return "articles";
//    }
//
//    @Autowired
//    private mentalhealthservice mentalService; // Injects your service
//
//    @GetMapping("/article/add") // Serve the add form [cite: 202]
//    public String showAddForm() { return "add-article"; }
//
//    @PostMapping("/article/add") // Save data and redirect [cite: 204, 206]
//    public String saveArticle(@ModelAttribute Article article) {
//        service.addArticle(article);
//        return "redirect:/add/success/Article";
//    }
//
//    @GetMapping("/add/success/{entityName}") // Confirmation page [cite: 208, 209]
//    public String showSuccess(@PathVariable String entityName, Model model) {
//        model.addAttribute("entity", entityName);
//        return "success";
//    }
//}





//    @GetMapping("/articles") // Display data in tabular format [cite: 188, 200]
//    public String showArticles(Model model) {
//        model.addAttribute("articlesList", service.getAllArticles());
//        return "articles"
