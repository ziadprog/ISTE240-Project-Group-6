package com.example.assignment.controllers;

import com.example.assignment.model.Resources;
import com.example.assignment.services.ResourceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ResourceController {

    private final ResourceService resourceService;

    public ResourceController(ResourceService resourceService) {
        this.resourceService = resourceService;
    }

    @GetMapping("/api/resources")
    public List<Resources> getAllResources() {
        return resourceService.getAllResources();
    }

    @GetMapping("/api/resources/{id}")
    public ResponseEntity<Resources> getResourceById(@PathVariable Long id) {
        Resources resource = resourceService.getResourceById(id);

        if (resource == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(resource);
    }

    @GetMapping("/api/resources/user/{userId}/search")
    public List<Resources> searchUserResources(@PathVariable Long userId, @RequestParam String name) {
        return resourceService.findByUserAndName(userId, name);
    }

    @PostMapping("/api/resources")
    public ResponseEntity<Resources> createResource(@RequestBody Resources resource) {
        return ResponseEntity.ok(resourceService.createResource(resource));
    }

    @PutMapping("/api/resources/{id}")
    public ResponseEntity<String> updateResource(@PathVariable Long id, @RequestBody Resources resource) {
        resourceService.updateResource(id, resource);
        return ResponseEntity.ok("Resource updated successfully");
    }

    @DeleteMapping("/api/resources/{id}")
    public ResponseEntity<String> deleteResource(@PathVariable Long id) {
        resourceService.deleteResource(id);
        return ResponseEntity.ok("Resource deleted successfully");
    }

    @GetMapping("/api/resources/user/{userId}")
    public List<Resources> getResourcesByUser(@PathVariable Long userId) {
        return resourceService.getByUserId(userId);
    }
}