//Name: Ziad Abdelrahman
//ID: 764002985

package com.example.assignment.Services;

import com.example.assignment.model.Article;
import com.example.assignment.Repositories.ArticleRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ArticleService {

    private final ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }

    public Article getArticleById(Long id) {
        return articleRepository.findById(id).orElse(null);
    }

    public List<Article> searchByTitle(String title) {
        return articleRepository.findByTitleContaining(title);
    }

    public Article createArticle(Article article) {
        return articleRepository.save(article);
    }

    public Article updateArticle(Long id, Article article) {
        article.setId(id);
        return articleRepository.save(article);
    }

    public void deleteArticle(Long id) {
        articleRepository.deleteById(id);
    }
}
