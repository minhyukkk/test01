package com.example.test01.service;

import com.example.test01.dto.ArticleForm;
import com.example.test01.entity.Article;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.test01.repository.ArticleRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest // 해당 클래스는 스프링부트와 연동되어 테스팅
class ArticleServiceTest {

    @Autowired
    ArticleService articleService;
    @Autowired
    private ArticleRepository articleRepository;

    @Test
    void index() {
        // 예상
        Article a = new Article(1L, "가가가가", "1111");
        Article b = new Article(2L, "나나나나", "2222");
        Article c = new Article(3L, "다다다다", "3333");
        List<Article> expected = new ArrayList<Article>(Arrays.asList(a,b,c));
        // 실제
        List<Article> articles = articleService.index();
        // 비교
        assertEquals(expected.toString(), articles.toString());
    }

    @Test
    void show_성공___존재하는_id_입력() {
        // 예상
        Long id = 1L;
        Article expected = new Article(id, "가가가가", "1111");

        // 실제
        Article article = articleService.show(id);

        // 비교
        assertEquals(expected.toString(), article.toString());

    }

    @Test
    void show_실패___존재하지_않는_id_입력() {
        Long id = -1L;
        Article expected = null;

        // 실제
        Article article = articleService.show(id);

        // 비교
        assertEquals(expected, article);
    }

    @Test
    @Transactional
    void create_성공___title과_content만_있는_dto_입력() {
        String title = "라라라라";
        String content = "4444";
        ArticleForm dto = new ArticleForm(null, title, content);
        Article expected = new Article(4L, title, content);

        // 실제
        Article article = articleService.create(dto);

        // 비교
        assertEquals(expected.toString(), article.toString());
    }

    @Test
    @Transactional
    void create_실패__id가_포함된_dto_입력() {
        String title = "라라라라";
        String content = "4444";
        ArticleForm dto = new ArticleForm(4L, title, content);
        Article expected = null;

        Article article = articleService.create(dto);

        assertEquals(expected, article);
    }

    @Test
    @Transactional
    void update_성공__존재하는_id와_title_content가_있는_dto_입력() {
        Long id = 1L;
        String title = "나는";
        String content = "변경됐다!";
        ArticleForm dto = new ArticleForm(id, title, content);
        Article expected = new Article(id, title, content);

        Article article = articleService.update(id, dto);

        assertEquals(expected.toString(), article.toString());
    }

    @Test
    @Transactional
    void update_성공__존재하는_id와_title만_있는_dto_입력() {
        Long id = 1L;
        String title = "나는";
        String content = articleRepository.findById(id).orElse(null).getTitle();

        ArticleForm dto = new ArticleForm(id, title, content);
        Article expected = new Article(id, title, content);

        Article article = articleService.update(id, dto);

        assertEquals(expected.toString(), article.toString());

    }

    @Test
    @Transactional
    void update_실패__존재하지않는_id의_dto_입력() {
        Long id = -1L;
        String title = "나는";
        String content = "덥다";
        ArticleForm dto = new ArticleForm(id, title, content);
        Article expected = null;

        Article article = articleService.update(id, dto);

        assertEquals(expected, article);

    }

    @Test
    @Transactional
    void update_실패__id만_있는_dto_입력() {
        Long id = 1L;
        String title = null;
        String content = null;
        ArticleForm dto = new ArticleForm(id, title, content);
        Article expected = null;

        Article article = articleService.update(id, dto);

        assertEquals(expected, article);
    }

    @Test
    @Transactional
    void delete_성공__존재하는_id_입력() {
        Long id = 1L;

        String title = articleRepository.findById(id).orElse(null).getTitle();
        String content = articleRepository.findById(id).orElse(null).getContent();
        ArticleForm dto = new ArticleForm(id, title, content);

        Article expected = new Article(id, title, content);

        Article article = articleService.delete(id);

        assertEquals(expected.toString(), article.toString());
    }

    @Test
    @Transactional
    void delete_실패__존재하지않는_id_입력() {
        Long id = -1L;

        Article expected = null;

        Article article = articleService.delete(id);

        assertEquals(expected, article);
    }

}