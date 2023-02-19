package com.example.board.articleV2.service;

import com.example.board.articleV2.entity.ArticleType;
import com.example.board.articleV2.dto.request.ArticleRequestDto;
import com.example.board.articleV2.dto.response.ArticleIdResponseDto;
import com.example.board.articleV2.dto.response.ArticleLikeCountResponseDto;
import com.example.board.articleV2.dto.response.ArticleResponseDto;

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
