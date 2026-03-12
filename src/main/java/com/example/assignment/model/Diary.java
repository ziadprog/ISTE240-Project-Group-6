package com.example.assignment.model;


public class Diary {
    private String Title;
    private String content;
    private String date;

    public Diary(String title, String content, String date) {
        Title = title;
        this.content = content;
        this.date = date;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
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
}

