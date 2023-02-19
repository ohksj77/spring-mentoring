package com.example.board.articleV2.dto.response;

import com.example.board.articleV2.entity.ArticleType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ArticleResponseDto {
    private Long id;
    private String title;
    private String content;
    private Integer likeCount;
    private ArticleType articleType;
}
