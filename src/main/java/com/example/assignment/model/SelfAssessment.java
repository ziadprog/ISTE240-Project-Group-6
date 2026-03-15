package com.example.assignment.model;


public class SelfAssessment {

    private String username;
    private int stresspoints;
    private int anxietypoints;
    private String result;
    private String recommendedAction;

    private Resources resource;
    private Article article;

    public SelfAssessment(String username, int stresspoints) {
        this.username = username;
        this.stresspoints = stresspoints;

        this.resource = new Resources();
        this.article = new Article();

        this.resource.setName("Stress Hotline");
        if (this.stresspoints > 5) {
            this.resource.setType("HOTLINE");
            this.resource.setPhoneNumber("1-800-STRESS");
        }

        this.article.setTitle("Managing Stress");
        if (this.stresspoints > 5) {
            this.article.setAuthor("Dr. Johnson");
            this.article.setContent("Tips for high stress...");
        }

        this.recommendedAction = "Call " + resource.getName() + " and read " + article.getTitle();
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

    public Resources getResource() {
        return resource;
    }

    public Article getArticle() {
        return article;
    }
}