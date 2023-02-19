package com.example.board.article;

import lombok.*;

import javax.persistence.*;

@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Article {
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
        if (likeCount > 0) {
            return --this.likeCount;
        }
        throw new IllegalStateException();
    }
}
