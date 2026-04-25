package com.example.assignment.config;

import com.example.assignment.model.Article;
import com.example.assignment.model.Resources;
import com.example.assignment.model.User;
import com.example.assignment.model.SelfAssessment;
import com.example.assignment.Repositories.ArticleRepository;
import com.example.assignment.Repositories.ResourceRepository;
import com.example.assignment.Repositories.UserRepository;
import com.example.assignment.Repositories.AssessmentRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class DataLoader {

    private final ArticleRepository articleRepository;
    private final ResourceRepository resourceRepository;
    private final UserRepository userRepository;
    private final AssessmentRepository assessmentRepository;

    public DataLoader(ArticleRepository articleRepository,
                      ResourceRepository resourceRepository,
                      UserRepository userRepository,
                      AssessmentRepository assessmentRepository) {
        this.articleRepository = articleRepository;
        this.resourceRepository = resourceRepository;
        this.userRepository = userRepository;
        this.assessmentRepository = assessmentRepository;
    }

    @PostConstruct
    public void loadData() {
        System.out.println("Loading sample data...");

        Resources hotline = new Resources();
        hotline.setName("Crisis Text Line");
        hotline.setType("Hotline");
        hotline.setPhoneNumber("741741");
        resourceRepository.save(hotline);

        Resources foundation = new Resources();
        foundation.setName("Jed Foundation");
        foundation.setType("Non-Profit");
        foundation.setWebsite("www.jedfoundation.org");
        resourceRepository.save(foundation);

        // Add Articles
        Article article1 = new Article();
        article1.setTitle("What to do in a Crisis");
        article1.setAuthor("France Bridges");
        article1.setContent("Focus on the next step. Take deep breaths. Reach out for help.");
        article1.setRelatedResource(hotline);
        articleRepository.save(article1);

        Article article2 = new Article();
        article2.setTitle("Managing Exam Anxiety");
        article2.setAuthor("Dr. Aris");
        article2.setContent("Deep breathing and time management are key tools for students.");
        articleRepository.save(article2);

        User user1 = new User();
        user1.setUserId("U001");
        user1.setUserName("John Doe");
        user1.setEmail("john@example.com");
        userRepository.save(user1);

        User user2 = new User();
        user2.setUserId("U002");
        user2.setUserName("Jane Smith");
        user2.setEmail("jane@example.com");
        userRepository.save(user2);

        SelfAssessment assessment1 = new SelfAssessment();
        assessment1.setUsername("john@example.com");
        assessment1.setStresspoints(8);
        assessment1.setAnxietypoints(7);
        assessment1.setResult("High stress - consider professional help");
        assessmentRepository.save(assessment1);

        SelfAssessment assessment2 = new SelfAssessment();
        assessment2.setUsername("jane@example.com");
        assessment2.setStresspoints(3);
        assessment2.setAnxietypoints(4);
        assessment2.setResult("Moderate stress - practice mindfulness");
        assessmentRepository.save(assessment2);

        System.out.println("Sample data loaded!");
    }
}

//package com.example.assignment.config;
//
//import com.example.assignment.model.User;
//import com.example.assignment.model.SelfAssessment;
//import com.example.assignment.Repositories.UserRepository;
//import com.example.assignment.Repositories.AssessmentRepository;
//import jakarta.annotation.PostConstruct;
//import org.springframework.stereotype.Component;
//
//@Component
//public class DataLoader {
//
//    private final UserRepository userRepository;
//    private final AssessmentRepository assessmentRepository;
//
//    public DataLoader(UserRepository userRepository, AssessmentRepository assessmentRepository) {
//        this.userRepository = userRepository;
//        this.assessmentRepository = assessmentRepository;
//    }
//
//    @PostConstruct
//    public void loadData() {
//        // Add sample users
//        User user1 = new User();
//        user1.setUserId("U001");
//        user1.setUserName("John Doe");
//        user1.setEmail("john@example.com");
//        userRepository.save(user1);
//
//        User user2 = new User();
//        user2.setUserId("U002");
//        user2.setUserName("Jane Smith");
//        user2.setEmail("jane@example.com");
//        userRepository.save(user2);
//
//        // Add sample assessments
//        SelfAssessment assessment1 = new SelfAssessment();
//        assessment1.setUsername("john@example.com");
//        assessment1.setStresspoints(8);
//        assessment1.setAnxietypoints(7);
//        assessment1.setResult("High stress detected");
//        assessmentRepository.save(assessment1);
//
//        SelfAssessment assessment2 = new SelfAssessment();
//        assessment2.setUsername("jane@example.com");
//        assessment2.setStresspoints(3);
//        assessment2.setAnxietypoints(4);
//        assessment2.setResult("Moderate stress");
//        assessmentRepository.save(assessment2);
//
//        System.out.println("✅ Sample users and assessments loaded!");
//    }
//}