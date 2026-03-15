package com.example.assignment.model;


public class Diary {
    private String title;
    private String content;
    private String date;
    private final User user;

    public Diary(String title, String content, String date, User user) {
        this.title = title;
        this.content = content;
        this.date = date;
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public User getUser (){return user;}
}

