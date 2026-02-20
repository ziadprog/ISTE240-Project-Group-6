package com.example.assignment.model;

import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;

@Component
public class SelfAssessment {

    private String username;
    private int stresspoints;
    private int anxietypoints;
    private String result;
    private String recommendedAction;

    private resources resource;
    private Article article;

    @PostConstruct
    public void connectAll() {
        resource = new resources();
        resource.setName("Stress Hotline");
        if (this.stresspoints > 5) {
            resource.setType("HOTLINE");
            resource.setPhoneNumber("1-800-STRESS");
        }

        article = new Article();
        article.setTitle("Managing Stress");
        if (this.stresspoints > 5) {
            article.setAuthor("Dr. Johnson");
            article.setContent("Tips for high stress...");
        }

        this.recommendedAction = "Call " + resource.getName() +
                " and read " + article.getTitle();

        System.out.println("Connected: " + this.username +
                " -> " + resource.getName() +
                " -> " + article.getTitle());
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getstresspoints() {
        return stresspoints;
    }

    public void setstresspoints(int stresspoints) {
        this.stresspoints = stresspoints;
    }

    public int getanxietypoints() {
        return anxietypoints;
    }

    public void setanxietypoints(int anxietypoints) {
        this.anxietypoints = anxietypoints;
    }

    public String getResult() {
        return result;
    }

    public void setresult(String result) {
        this.result = result;
    }

    public String getRecommendedAction() {
        return recommendedAction;
    }

    public void setRecommendedAction(String recommendedAction) {
        this.recommendedAction = recommendedAction;
    }

    public resources getResource() {
        return resource;
    }

    public Article getArticle() {
        return article;
    }
}