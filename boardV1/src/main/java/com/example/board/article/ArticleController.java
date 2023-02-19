package com.example.board.article;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/articles")
public class ArticleController {

    private final ArticleService articleService;

    @PostMapping
    public Long saveArticle(@RequestBody Article article) {
        return articleService.saveArticle(article);
    }

    @GetMapping("/all-types")
    public List<Article> getArticleList() {
        return articleService.getArticleList();
    }

    @GetMapping
    public List<Article> getArticleList(@RequestParam ArticleType type) {
        return articleService.getArticleListByType(type);
    }

    @GetMapping("/{id}")
    public Article getArticle(@PathVariable Long id) {
        return articleService.getArticle(id);
    }

    @PostMapping("/{id}/like-count/add")
    public Integer addLikeCount(@PathVariable Long id) {
        return articleService.addLike(id);
    }

    @PostMapping("/{id}/like-count/cancel")
    public Integer cancelLikeCount(@PathVariable Long id) {
        return articleService.cancelLike(id);
    }

    @DeleteMapping("/{id}")
    public void deleteArticle(@PathVariable Long id) {
        articleService.deleteArticle(id);
    }
}
