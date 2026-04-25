package com.example.assignment.services;


import com.example.assignment.model.*;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;


@Service
public class MentalHealthService {
    //Lists
    private List<User> users = new ArrayList<User>();
    private List<Diary> diaries = new ArrayList<Diary>();
    private List<Article> articles = new ArrayList<>();
    private List<Resources> resourcelist = new ArrayList<>();

    //GET lists
    public List<User> findAllUsers() {return users;}
    public List<Diary> findAllDiaries() {return diaries;}
    public List<Article> getAllArticles() {return articles;}

    //to have preset table data and show user and diary link
    @PostConstruct
    public void init() {
        User user = new User("1", "Ali", "ali@gmail.com");
        Diary diary = new Diary("My Day", "It was good", "2026-03-14", user);

        users.add(user);
        diaries.add(diary);
    }

    public MentalHealthService() {

        Resources hotline = new Resources();
        hotline.setName("Crisis Text Line");
        hotline.setType("Hotline");
        hotline.setPhoneNumber("741741");
        resourcelist.add(hotline);

        Resources foundation = new Resources();
        foundation.setName("Jed Foundation");
        foundation.setType("Non-Profit");
        foundation.setWebsite("www.jedfoundation.org");
        resourcelist.add(foundation);

        Resources foundation2 = new Resources();
        foundation2.setName("University Of Essex");
        foundation2.setType("Article");
        foundation2.setWebsite("www.essex.ac.uk");
        resourcelist.add(foundation2);

        Resources foundation3 = new Resources();
        foundation3.setName("Verywellmind");
        foundation3.setType("Article");
        foundation3.setWebsite("www.verywellmind.com");
        resourcelist.add(foundation3);

        Article article1 = new Article();
        article1.setTitle("What to do in a Crisis");
        article1.setAuthor("France Bridges");
        article1.setContent("<a href=\"/Crisis_Article.html\">If you feel overwhelmed, Focus on the next Step</a>");
        articles.add(article1);


        Article article2 = new Article();
        article2.setTitle("Managing Exam Anxiety");
        article2.setAuthor("Dr. Aris");
        article2.setContent("<a href=\"/Anxiety_Management.html\">Deep breathing and time management are key tools for student");
        articles.add(article2);

        Article article3 = new Article();
        article3.setTitle("The Benefits of Mindfulness");
        article3.setAuthor("Kendra Cherry");
        article3.setContent("<a href=\"/Mindfulness_Benefits.html\">Mindfulness involves being fully present in the moment");
        articles.add(article3);
    }

    //POST entities (add)
    public void addUser(User user) {
        this.users.add(user);
    }

    public void addDiary (Diary diary){
        diaries.add(diary);
    }

    public void addArticle(Article article) {
        articles.add(article);

      }
    }

