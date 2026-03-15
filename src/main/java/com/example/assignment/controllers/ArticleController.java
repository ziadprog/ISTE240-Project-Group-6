package com.example.assignment.controllers;

import com.example.assignment.model.Article;
import com.example.assignment.Services.MentalHealthService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ArticleController {
    private final MentalHealthService service;

    public ArticleController(MentalHealthService service) {
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
    public String saveArticle(@ModelAttribute Article article, RedirectAttributes redirectAttributes) {
        service.addArticle(article);

        redirectAttributes.addFlashAttribute("title", article.getTitle());

        return "redirect:/add/success/Article";
    }

    @GetMapping("/add/success/{entityName}")
    public String showSuccess(@PathVariable String entityName, Model model) {
        model.addAttribute("entity", entityName);
        return "Success";
    }
}
