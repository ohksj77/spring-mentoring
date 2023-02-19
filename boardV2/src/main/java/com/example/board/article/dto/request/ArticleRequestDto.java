package com.example.board.article.dto.request;

import com.example.board.article.entity.ArticleType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ArticleRequestDto {
    private String title;
    private String content;
    private ArticleType articleType;
}
