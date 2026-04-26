//Name: Ziad Abdelrahman
//ID: 764002985

package com.example.assignment.services;

import com.example.assignment.model.Activity;
import com.example.assignment.repositories.ActivityRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActivityService {

    private final ActivityRepository activityRepository;

    public ActivityService(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    public List<Activity> getAllActivities() {
        return activityRepository.findAll();
    }

    public Optional<Activity> getActivityById(Long id) {
        return activityRepository.findById(id);
    }

    public List<Activity> getByUserId(Long userId) {
        return activityRepository.findByUserId(userId);
    }

    public List<Activity> findByUserAndTitle(Long userId, String title) {
        return activityRepository.findByUserAndTitle(userId, title);
    }

    public Activity saveActivity(Activity activity) {
        return activityRepository.save(activity);
    }

    public boolean updateActivity(Long id, Activity activity){

        int updated = activityRepository.updateActivityById(
                        id,
                        activity.getTitle(),
                        activity.getCategory(),
                        activity.getDescription(),
                        activity.getDate(),
                        activity.getDuration(),
                        activity.getUser()
                );

        return updated > 0;

    }

    public void deleteActivity(Long id) {
        activityRepository.deleteById(id);
    }
}
