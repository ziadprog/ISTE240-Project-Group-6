//ziad abdelrahman - 764002985

package com.example.assignment.controllers;

import com.example.assignment.model.Activity;
import com.example.assignment.services.ActivityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ActivityController {

    private final ActivityService activityService;

    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }

    @GetMapping("/api/activities")
    public List<Activity> getAllActivities() {
        return activityService.getAllActivities();
    }

    @GetMapping("/api/activities/{id}")
    public ResponseEntity<Activity> getActivityById(@PathVariable Long id) {
        Activity activity = activityService.getActivityById(id).orElse(null);

        if (activity == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(activity);
    }

    @GetMapping("/api/activities/user/{userId}")
    public List<Activity> getActivitiesByUser(@PathVariable Long userId) {
        return activityService.getByUserId(userId);
    }

    @GetMapping("/api/activities/user/{userId}/search")
    public List<Activity> searchUserActivities(@PathVariable Long userId, @RequestParam String title) {
        return activityService.findByUserAndTitle(userId, title);
    }

    @PostMapping("/api/activities")
    public ResponseEntity<Activity> createActivity(@RequestBody Activity activity) {
        return ResponseEntity.ok(activityService.saveActivity(activity));
    }

    @PutMapping("/api/activities/{id}")
    public ResponseEntity<String> updateActivity(@PathVariable Long id, @RequestBody Activity updatedActivity) {
        activityService.updateActivity(id, updatedActivity);
        return ResponseEntity.ok("Activity updated successfully");
    }

    @DeleteMapping("/api/activities/{id}")
    public ResponseEntity<String> deleteActivity(@PathVariable Long id) {
        activityService.deleteActivity(id);
        return ResponseEntity.ok("Activity deleted successfully");
    }
}
