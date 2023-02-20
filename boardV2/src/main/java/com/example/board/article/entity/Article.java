package com.example.board.article.entity;

import com.example.board.article.exception.LikeCountMinusException;
import com.example.board.global.BaseTime;
import com.example.board.global.SoftDelete;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Getter
@Entity
@SoftDelete
@AllArgsConstructor
@NoArgsConstructor
public class Article extends BaseTime {
    @Id @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String title;

    @Lob
    @Column(nullable = false)
    private String content;

    private Integer likeCount = 0;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ArticleType articleType;

    @Builder
    public Article(String title, String content, ArticleType articleType) {
        this.title = title;
        this.content = content;
        this.articleType = articleType;
    }

    public Integer addLike() {
        return ++this.likeCount;
    }

    public Integer cancelLike() {
        if (likeCount < 1) {
            throw new LikeCountMinusException();
        }
        return --this.likeCount;
    }

    public void delete() {
        this.deleteEntity();
    }
}
