package com.example.board.article;

import java.util.List;

public interface ArticleService {
    Long saveArticle(Article article);
    Article getArticle(Long id);
    List<Article> getArticleList();
    List<Article> getArticleListByType(ArticleType articleType);
    Integer addLike(Long id);
    Integer cancelLike(Long id);
    void deleteArticle(Long id);
}
