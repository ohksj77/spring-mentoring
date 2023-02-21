package com.example.board.article.service.impl;

import com.example.board.article.dto.request.ArticleRequestDto;
import com.example.board.article.dto.response.ArticleLikeCountResponseDto;
import com.example.board.article.dto.response.ArticleResponseDto;
import com.example.board.article.entity.Article;
import com.example.board.article.entity.ArticleType;
import com.example.board.article.mapper.ArticleMapper;
import com.example.board.article.repository.ArticleRepository;
import com.example.board.article.service.ArticleService;
import com.example.board.global.IdResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository articleRepository;
    private final ArticleMapper articleMapper;

    @Override
    public IdResponse<Long> saveArticle(ArticleRequestDto dto) {
        return new IdResponse<>(articleRepository.save(articleMapper.toEntity(dto)).getId());
    }

    @Override
    public ArticleResponseDto getArticle(Long id) {
        return articleMapper.toResponseDto(getEntity(id));
    }

    @Override
    public List<ArticleResponseDto> getArticleList() {
        return articleRepository.findAll().stream()
                .map(articleMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ArticleResponseDto> getArticleListByType(ArticleType articleType) {
        return articleRepository.findAllByArticleType(articleType).stream()
                .map(articleMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public ArticleLikeCountResponseDto addLike(Long id) {
        return new ArticleLikeCountResponseDto(getEntity(id).addLike());
    }

    @Override
    @Transactional
    public ArticleLikeCountResponseDto cancelLike(Long id) {
        return new ArticleLikeCountResponseDto(getEntity(id).cancelLike());
    }

    @Override
    @Transactional
    public void deleteArticle(Long id) {
        getEntity(id).delete();
    }

    private Article getEntity(Long id) {
        return articleRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
}
