package com.example.assignment.model;


import jakarta.persistence.*;

@Entity
@Table(name = "assessments")
public class SelfAssessment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private int stresspoints;
    private int anxietypoints;
    private String result;
    private String recommendedAction;

    @ManyToOne
    @JoinColumn(name = "resource_id")
    private Resources resource;

    @ManyToOne
    @JoinColumn(name = "article_id")
    private Article article;

    // Constructors
    public SelfAssessment() {}

    public SelfAssessment(String username, int stresspoints) {
        this.username = username;
        this.stresspoints = stresspoints;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public int getStresspoints() { return stresspoints; }
    public void setStresspoints(int stresspoints) { this.stresspoints = stresspoints; }

    public int getAnxietypoints() { return anxietypoints; }
    public void setAnxietypoints(int anxietypoints) { this.anxietypoints = anxietypoints; }

    public String getResult() { return result; }
    public void setResult(String result) { this.result = result; }

    public String getRecommendedAction() { return recommendedAction; }
    public void setRecommendedAction(String recommendedAction) { this.recommendedAction = recommendedAction; }

    public Resources getResource() { return resource; }
    public void setResource(Resources resource) { this.resource = resource; }

    public Article getArticle() { return article; }
    public void setArticle(Article article) { this.article = article; }
}