package com.example.assignment.Services;


import com.example.assignment.model.Article;
import com.example.assignment.model.Resources;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;


@Service
public class MentalHealthService {
    private List<Article> articles = new ArrayList<>();
    private List<Resources> resourcelist = new ArrayList<>();

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
        article1.setRelatedResource(hotline);
        articles.add(article1);


        Article article2 = new Article();
        article2.setTitle("Managing Exam Anxiety");
        article2.setAuthor("Dr. Aris");
        article2.setContent("<a href=\"/Anxiety_Management.html\">Deep breathing and time management are key tools for student");
        article2.setRelatedResource(foundation2);
        articles.add(article2);

        Article article3 = new Article();
        article3.setTitle("The Benefits of Mindfulness");
        article3.setAuthor("Kendra Cherry");
        article3.setContent("<a href=\"/Mindfulness_Benefits.html\">Mindfulness involves being fully present in the moment");
        article3.setRelatedResource(foundation3);
        articles.add(article3);
    }

    public List<Article> getAllArticles() {
        return articles;
    }

    public void addArticle(Article article) {
        articles.add(article);

      }
    }

