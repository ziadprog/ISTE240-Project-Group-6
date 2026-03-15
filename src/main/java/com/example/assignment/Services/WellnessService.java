package com.example.assignment.services;

import com.example.assignment.model.Category;
import com.example.assignment.model.Resource;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WellnessService {

    private final List<Category> categories = new ArrayList<>();
    private final List<Resource> resources = new ArrayList<>();

    @PostConstruct
    public void initData() {

        Category stress = new Category(1, "Stress Management", "Ways to manage and reduce stress.");
        Category anxiety = new Category(2, "Anxiety Support", "Helpful strategies to cope with anxiety.");
        Category sleep = new Category(3, "Sleep Wellness", "Resources to improve sleep quality.");
        Category selfCare = new Category(4, "Self Care", "Practices that support mental wellbeing.");

        categories.add(stress);
        categories.add(anxiety);
        categories.add(sleep);
        categories.add(selfCare);

        Resource r1 = new Resource(1, "Breathing Exercises for Stress", "Article",
                "Simple breathing techniques that help calm the nervous system.", stress);

        Resource r2 = new Resource(2, "5 Minute Mindfulness Meditation", "Video",
                "A short guided meditation to help relax the mind.", stress);

        Resource r3 = new Resource(3, "Grounding Techniques for Anxiety", "Guide",
                "Easy techniques that help bring focus back to the present moment.", anxiety);

        Resource r4 = new Resource(4, "Understanding Anxiety Triggers", "Article",
                "Learn how to recognize and manage anxiety triggers.", anxiety);

        Resource r5 = new Resource(5, "Healthy Sleep Routine", "Article",
                "Practical tips for building a better sleep schedule.", sleep);

        Resource r6 = new Resource(6, "Relaxation Techniques Before Bed", "Guide",
                "Relaxation exercises that help prepare the body for sleep.", sleep);

        Resource r7 = new Resource(7, "Daily Self Care Checklist", "Checklist",
                "Small daily habits that improve emotional wellbeing.", selfCare);

        Resource r8 = new Resource(8, "Journaling for Mental Health", "Article",
                "Writing exercises that help process thoughts and emotions.", selfCare);

        Resource r9 = new Resource(9, "Nature Walks and Mental Wellness", "Article",
                "How spending time outdoors improves mood and reduces stress.", stress);

        Resource r10 = new Resource(10, "Positive Affirmations Practice", "Guide",
                "Simple affirmations that support positive thinking.", selfCare);

        resources.add(r1);
        resources.add(r2);
        resources.add(r3);
        resources.add(r4);
        resources.add(r5);
        resources.add(r6);
        resources.add(r7);
        resources.add(r8);
        resources.add(r9);
        resources.add(r10);

        stress.getResources().add(r1);
        stress.getResources().add(r2);
        stress.getResources().add(r9);

        anxiety.getResources().add(r3);
        anxiety.getResources().add(r4);

        sleep.getResources().add(r5);
        sleep.getResources().add(r6);

        selfCare.getResources().add(r7);
        selfCare.getResources().add(r8);
        selfCare.getResources().add(r10);
    }

    public List<Resource> getAllResources() {
        return resources;
    }

    public List<Category> getAllCategories() {
        return categories;
    }

    public void addResource(Resource resource) {
        resource.setId(resources.size() + 1);
        resources.add(resource);

        if (resource.getCategory() != null) {
            resource.getCategory().getResources().add(resource);
        }
    }

    public Category findCategoryById(int id) {
        for (Category category : categories) {
            if (category.getId() == id) {
                return category;
            }
        }
        return null;
    }
}
