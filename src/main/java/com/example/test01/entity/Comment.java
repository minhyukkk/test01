package com.example.test01.entity;

import com.example.test01.dto.CommentDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;

@Entity
@Getter
@ToString
@Slf4j
@NoArgsConstructor
@AllArgsConstructor

public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne // 해당 댓글 엔티티 여러개가 하나의 article에 연관
    @JoinColumn(name = "article_id")
    private Article article;

    @Column
    private String Nickname;

    @Column
    private String body;

    public static Comment createComment(CommentDto dto, Article article) {
        // 예외 처리
        if (dto.getId() != null)
            throw new IllegalArgumentException("댓글 생성 실패 댓글의 id가 없어야합니다.");
        if (dto.getArticleId() != dto.getId())
            throw new IllegalArgumentException("댓글 생성 실패 댓글의 id가 없어야합니다.");

        // 엔티티 생성 및 반환
        return new Comment(
                dto.getId(),
                article,
                dto.getNickname(),
                dto.getBody()
        );
    }

    public void patch(CommentDto dto) {
        // 예외 발생
        if (this.id != dto.getId())
            throw new IllegalArgumentException("댓글 수정 실패. 잘못된 id 입니다.");

        // 객체 갱신
        if (dto.getNickname() != null)
            this.Nickname = dto.getNickname();

        if (dto.getBody() != null)
            this.body = dto.getBody();
    }
}