package com.example.test01.dto;

import com.example.test01.entity.Article;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
public class ArticleForm {

    private Long id; // id 필드 추가
    private String title;
    private String content;

    public Article toEntity() {
        return new Article(id, title, content);
    }
}
