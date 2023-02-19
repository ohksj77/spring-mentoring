package com.example.board.articleV2.dto.request;

import com.example.board.articleV2.entity.ArticleType;
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
