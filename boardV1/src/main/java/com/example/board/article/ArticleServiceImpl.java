package com.example.board.article;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository articleRepository;

    @Override
    public Long saveArticle(Article article) {
        return articleRepository.save(article).getId();
    }

    @Override
    public Article getArticle(Long id) {
        return getEntity(id);
    }

    @Override
    public List<Article> getArticleList() {
        return articleRepository.findAll();
    }

    @Override
    public List<Article> getArticleListByType(ArticleType articleType) {
        return articleRepository.findAllByArticleType(articleType);
    }

    @Override
    @Transactional
    public Integer addLike(Long id) {
        return getEntity(id).addLike();
    }

    @Override
    @Transactional
    public Integer cancelLike(Long id) {
        return getEntity(id).cancelLike();
    }

    @Override
    public void deleteArticle(Long id) {
        articleRepository.deleteById(id);
    }

    private Article getEntity(Long id) {
        return articleRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
}
