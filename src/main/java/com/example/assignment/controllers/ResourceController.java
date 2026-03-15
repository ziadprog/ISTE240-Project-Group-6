package com.example.assignment.controllers;

import com.example.assignment.model.Category;
import com.example.assignment.model.Resource;
import com.example.assignment.services.WellnessService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ResourceController {

    private final WellnessService wellnessService;

    public ResourceController(WellnessService wellnessService) {
        this.wellnessService = wellnessService;
    }

    @GetMapping("/resources")
    public String showResources(Model model) {
        model.addAttribute("resources", wellnessService.getAllResources());
        return "resources";
    }

    @GetMapping("/resources/add")
    public String showAddResourceForm(Model model) {
        model.addAttribute("categories", wellnessService.getAllCategories());
        return "add-resource";
    }

    @PostMapping("/resources/add")
    public String addResource(@RequestParam String title,
                              @RequestParam String type,
                              @RequestParam String shortDescription,
                              @RequestParam int categoryId) {

        Category category = wellnessService.findCategoryById(categoryId);

        Resource resource = new Resource();
        resource.setTitle(title);
        resource.setType(type);
        resource.setShortDescription(shortDescription);
        resource.setCategory(category);

        wellnessService.addResource(resource);

        return "redirect:/add/success/resource";
    }
}
