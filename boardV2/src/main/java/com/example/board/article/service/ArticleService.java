package com.example.board.article.service;

import com.example.board.article.entity.ArticleType;
import com.example.board.article.dto.request.ArticleRequestDto;
import com.example.board.article.dto.response.ArticleIdResponseDto;
import com.example.board.article.dto.response.ArticleLikeCountResponseDto;
import com.example.board.article.dto.response.ArticleResponseDto;

import java.util.List;

public interface ArticleService {
    ArticleIdResponseDto saveArticle(ArticleRequestDto dto);
    ArticleResponseDto getArticle(Long id);
    List<ArticleResponseDto> getArticleList();
    List<ArticleResponseDto> getArticleListByType(ArticleType articleType);
    ArticleLikeCountResponseDto addLike(Long id);
    ArticleLikeCountResponseDto cancelLike(Long id);
    void deleteArticle(Long id);
}
