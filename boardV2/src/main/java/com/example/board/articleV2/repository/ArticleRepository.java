package com.example.board.articleV2.repository;

import com.example.board.articleV2.entity.Article;
import com.example.board.articleV2.entity.ArticleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
    List<Article> findAllByArticleType(ArticleType articleType);
}
