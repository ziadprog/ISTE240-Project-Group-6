//package com.example.assignment.model;
//
//import org.springframework.stereotype.Service;
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//public class sentimentalisation {
//    private List<Article> articles = new ArrayList<>();
//    private List<Resources> resourcelist = new ArrayList<>();
//
//    public sentimentalisation() {
//        Resources hotline = new Resources();
//        hotline.setName("Crisis Text Line");
//        hotline.setType("Hotline");
//        resourcelist.add(hotline);
//
//        Article stressArticle = new Article();
//        stressArticle.setTitle("Managing Stress");
//        stressArticle.setAuthor("Dr. Aris");
//        stressArticle.setRelatedResource(hotline);
//        articles.add(stressArticle);
//    }
//
//    public List<Article> getAllArticles() { return articles; }
//    public void addArticle(Article article) { articles.add(article); }
//}

package com.example.assignment.model;

import com.example.assignment.model.Article;
import com.example.assignment.model.Resources;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;


@Service
public class mentalhealthservice {
    private List<Article> articles = new ArrayList<>();
    private List<Resources> resourcelist = new ArrayList<>();

    public mentalhealthservice() {

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

        Article article1 = new Article();
        article1.setTitle("What to do in a Crisis");
        article1.setAuthor("France Bridges");
        article1.setContent("<a href=\"/Crisis_Article.html\">If you feel overwhelmed, Focus on the next Step</a>");
        article1.setRelatedResource(hotline);
        articles.add(article1);


        Article article2 = new Article();
        article2.setTitle("Managing Exam Anxiety");
        article2.setAuthor("Dr. Aris");
        article2.setContent("Deep breathing and time management are key tools for student");
        article2.setRelatedResource(foundation); // Linking to resource 2
        articles.add(article2);

        Article article3 = new Article();
        article3.setTitle("The Benefits of Mindfulness");
        article3.setAuthor("Leo Tolsoy");
        article3.setContent("Mindfulness involves being fully present in the moment");
        articles.add(article3);
    }

    public List<Article> getAllArticles() {
        return articles;
    }

    public void addArticle(Article article) {
        articles.add(article);
        System.out.println("SERVICE VERIFICATION: Created " + articles.size() + " articles.");
        for (Article a : articles) {
            System.out.println("Loaded Article: " + a.getTitle());
        }
    }

}