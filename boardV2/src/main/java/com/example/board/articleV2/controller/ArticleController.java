package com.example.board.articleV2.controller;

import com.example.board.articleV2.dto.request.ArticleRequestDto;
import com.example.board.articleV2.dto.response.ArticleIdResponseDto;
import com.example.board.articleV2.dto.response.ArticleLikeCountResponseDto;
import com.example.board.articleV2.dto.response.ArticleResponseDto;
import com.example.board.articleV2.entity.ArticleType;
import com.example.board.articleV2.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v2/articles")
public class ArticleController {

    private final ArticleService articleService;

    @PostMapping
    public ResponseEntity<ArticleIdResponseDto> saveArticle(@RequestBody ArticleRequestDto dto) {
        return ResponseEntity.ok(articleService.saveArticle(dto));
    }

    @GetMapping("/all-types")
    public ResponseEntity<List<ArticleResponseDto>> getArticleList() {
        return ResponseEntity.ok(articleService.getArticleList());
    }

    @GetMapping
    public ResponseEntity<List<ArticleResponseDto>> getArticleList(@RequestParam ArticleType type) {
        return ResponseEntity.ok(articleService.getArticleListByType(type));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArticleResponseDto> getArticle(@PathVariable Long id) {
        return ResponseEntity.ok(articleService.getArticle(id));
    }

    @PostMapping("/{id}/like-count/add")
    public ResponseEntity<ArticleLikeCountResponseDto> addLikeCount(@PathVariable Long id) {
        return ResponseEntity.ok(articleService.addLike(id));
    }

    @PostMapping("/{id}/like-count/cancel")
    public ResponseEntity<ArticleLikeCountResponseDto> cancelLikeCount(@PathVariable Long id) {
        return ResponseEntity.ok(articleService.cancelLike(id));
    }

    @DeleteMapping("/{id}")
    public void deleteArticle(@PathVariable Long id) {
        articleService.deleteArticle(id);
    }
}
