//Name: Ziad Abdelrahman
//ID: 764002985
package com.example.assignment.Repositories;

import com.example.assignment.model.Article;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {

    @Query("SELECT a FROM Article a WHERE a.title LIKE %:title%")
    List<Article> findByTitleContaining(@Param("title") String title);

    @Modifying
    @Transactional
    @Query("UPDATE Article a SET a.title = :title WHERE a.id = :id")
    int updateTitleById(@Param("id") Long id, @Param("title") String title);
}
