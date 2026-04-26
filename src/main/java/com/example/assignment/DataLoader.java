package com.example.assignment;

import com.example.assignment.model.*;
import com.example.assignment.repositories.*;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class DataLoader {
//

    private final UserRepository userRepository;
    private final DiaryRepository diaryRepository;
    private final AppointmentRepository appointmentRepository;
    private final ActivityRepository activityRepository;
    private final ResourceRepository resourceRepository;

    public DataLoader(UserRepository userRepository,
                      DiaryRepository diaryRepository,
                      AppointmentRepository appointmentRepository,
                      ActivityRepository activityRepository,
                      ResourceRepository resourceRepository) {

        this.userRepository = userRepository;
        this.diaryRepository = diaryRepository;
        this.appointmentRepository = appointmentRepository;
        this.activityRepository = activityRepository;
        this.resourceRepository = resourceRepository;
    }

    @PostConstruct
    public void loadData() {

        User user = new User();
        user.setUsername("demo");
        user.setPassword("demo123");
        user.setEmail("demo@clearmind.com");
        userRepository.save(user);

        Diary d1 = new Diary();
        d1.setTitle("Morning Reflection");
        d1.setContent("Completed assignments and felt productive.");
        d1.setDate("2026-04-25");
        d1.setUser(user);
        diaryRepository.save(d1);

        Diary d2 = new Diary();
        d2.setTitle("Stress Journal");
        d2.setContent("Used breathing exercises to manage stress.");
        d2.setDate("2026-04-23");
        d2.setUser(user);
        diaryRepository.save(d2);

        Appointment a1 = new Appointment();
        a1.setTitle("Therapy Session");
        a1.setDescription("Weekly counselling session.");
        a1.setDate("2026-04-28");
        a1.setTime("14:00");
        a1.setUser(user);
        appointmentRepository.save(a1);

        Appointment a2 = new Appointment();
        a2.setTitle("Doctor Checkup");
        a2.setDescription("General wellbeing appointment.");
        a2.setDate("2026-04-30");
        a2.setTime("10:30");
        a2.setUser(user);
        appointmentRepository.save(a2);

        Activity activity1 = new Activity();
        activity1.setTitle("Evening Walk");
        activity1.setCategory("Exercise");
        activity1.setDescription("Went for a calm walk to reduce stress.");
        activity1.setDate("2026-04-24");
        activity1.setDuration("1.5");
        activity1.setUser(user);
        activityRepository.save(activity1);

        Activity activity2 = new Activity();
        activity2.setTitle("Breathing Exercise");
        activity2.setCategory("Breathing");
        activity2.setDescription("Practised deep breathing before studying.");
        activity2.setDate("2026-04-22");
        activity2.setDuration("0.25");
        activity2.setUser(user);
        activityRepository.save(activity2);

        Resources r1 = new Resources();
        r1.setName("WHO Mental Health");
        r1.setType("Website");
        r1.setDescription("Information about mental health and wellbeing.");
        r1.setWebsite("www.who.int/health-topics/mental-health");
        r1.setUser(user);
        resourceRepository.save(r1);

        Resources r2 = new Resources();
        r2.setName("Mind Support");
        r2.setType("Non-Profit");
        r2.setDescription("Support resource for stress and anxiety.");
        r2.setWebsite("www.mind.org.uk");
        r2.setUser(user);
        resourceRepository.save(r2);

        System.out.println("Sample data loaded.");
    }
}