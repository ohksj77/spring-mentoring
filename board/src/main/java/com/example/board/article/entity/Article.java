package com.example.board.article.entity;

import com.example.board.article.exception.LikeCountMinusException;
import com.example.board.global.BaseTime;
import com.example.board.global.SoftDelete;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@SoftDelete
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Article extends BaseTime {
    @Id @GeneratedValue
    private Long id;
    private String title;
    private String content;
    @Enumerated(EnumType.STRING)
    private ArticleType articleType;
    private Integer likeCount = 0;

    @Builder
    public Article(String title, String content, ArticleType articleType) {
        this.title = title;
        this.content = content;
        this.articleType = articleType;
    }

    public Integer addLike() {
        return ++likeCount;
    }

    public Integer cancelLike() {
        if (likeCount < 1) {
            throw new LikeCountMinusException();
        }
        return --likeCount;
    }

    public void delete() {
        deleteEntity();
    }
}
