package com.example.board.articleV2.mapper;

import com.example.board.articleV2.dto.request.ArticleRequestDto;
import com.example.board.articleV2.dto.response.ArticleResponseDto;
import com.example.board.articleV2.entity.Article;
import org.springframework.stereotype.Component;

@Component
public class ArticleMapper {

    public Article toEntity(ArticleRequestDto request) {
        return Article.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .articleType(request.getArticleType())
                .build();
    }

    public ArticleResponseDto toResponseDto(Article article) {
        return ArticleResponseDto.builder()
                .id(article.getId())
                .title(article.getTitle())
                .content(article.getContent())
                .articleType(article.getArticleType())
                .likeCount(article.getLikeCount())
                .build();
    }
}
