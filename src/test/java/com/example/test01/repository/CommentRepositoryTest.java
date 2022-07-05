package com.example.test01.repository;

import com.example.test01.entity.Article;
import com.example.test01.entity.Comment;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.repository.query.Param;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CommentRepositoryTest {

    @Autowired
    CommentRepository commentRepository;

    @Test
    @DisplayName("특정 게시글의 모든 댓글 조회")
    void findByArticle() {
        /* Case 1 : 4번 게시글의 모든 댓글 조회 */
        {
            // 입력 데이터 준비
            Long articleId = 4L;

            // 실제 수행
            List<Comment> comments = commentRepository.findByArticleId(articleId);

            // 예상하기
            Article article = new Article(4L, "당신의 인생 영화는?", "댓글 ㄱ");
            Comment a = new Comment(1L, article,"Park", "기생충");
            Comment b = new Comment(2L, article,"Cha", "헤어질 결심");
            Comment c = new Comment(3L, article,"Lee", "괴물");
            List <Comment> expected = Arrays.asList(a, b, c);

            // 검증
            assertEquals(expected.toString(), comments.toString(), "1번 글의 모든 댓글 출력");
        }

        /* Case 2 : 1번 게시글의 모든 댓글 조회 */
        {
            // 입력 데이터 준비
            Long articleId = 1L;

            // 실제 수행
            List<Comment> comments = commentRepository.findByArticleId(articleId);

            // 예상하기
            Article article = new Article(1L, "가가가가", "1111");
            List <Comment> expected = Arrays.asList();

            // 검증
            assertEquals(expected.toString(), comments.toString(), "1번 글의 댓글이 없음");
        }

        /* Case 3 : 9번 게시글의 모든 댓글 조회 */ {

            Long articleId = 9L;

            // 실제 수행
            List<Comment> comments = commentRepository.findByArticleId(articleId);
            List <Comment> expected = Arrays.asList();
            assertEquals(expected.toString(), comments.toString(), "9번 글이 없음");

        }

        /* Case 4 : 999번 게시글의 모든 댓글 조회 */ {
            Long articleId = 999L;

            // 실제 수행
            List<Comment> comments = commentRepository.findByArticleId(articleId);
            List <Comment> expected = Arrays.asList();
            assertEquals(expected.toString(), comments.toString(), "9번 글이 없음");

        }

        /* Case 5 : -1번 게시글의 모든 댓글 조회 */ {
            Long articleId = -1L;

            // 실제 수행
            List<Comment> comments = commentRepository.findByArticleId(articleId);
            List <Comment> expected = Arrays.asList();
            assertEquals(expected.toString(), comments.toString(), "9번 글이 없음");

        }
    }

    @Test
    @DisplayName("특정 닉네임의 모든 댓글 조회")
    void findByNickname() {
        /* Case 1 : "Park"의 모든 댓글 조회 */ {
            // 입력 데이터 준비
            String nickname = "Park";

            // 실제 수행
            List<Comment> comments = commentRepository.findByNickname(nickname);

            // 예상하기
            Comment a = new Comment(1L, new Article(4L, "당신의 인생 영화는?", "댓글 ㄱ"),"Park", "기생충");
            Comment b = new Comment(4L, new Article(5L, "당신의 소울 푸드는?", "댓글 ㄱㄱ"),"Park", "곱창");
            Comment c = new Comment(7L, new Article(6L, "당신의 취미는?", "댓글 ㄱㄱㄱ"),"Park", "코딩하기");
            List <Comment> expected = Arrays.asList(a, b, c);

            // 검증
            assertEquals(expected.toString(), comments.toString(), "Park의 모든 댓글을 출력");
        }

        /* Case 2 : "Cha"의 모든 댓글 조회 */ {
            String nickname = "Cha";

            // 실제 수행
            List<Comment> comments = commentRepository.findByNickname(nickname);

            // 예상하기
            Comment a = new Comment(2L, new Article(4L, "당신의 인생 영화는?", "댓글 ㄱ"),"Cha", "헤어질 결심");
            Comment b = new Comment(5L, new Article(5L, "당신의 소울 푸드는?", "댓글 ㄱㄱ"),"Cha", "떡볶이");
            Comment c = new Comment(8L, new Article(6L, "당신의 취미는?", "댓글 ㄱㄱㄱ"),"Cha", "멍 때리기");
            List <Comment> expected = Arrays.asList(a, b, c);

            // 검증
            assertEquals(expected.toString(), comments.toString(), "Cha의 모든 댓글을 출력");
            
        }

        /* Case 3 : NULL의 모든 댓글 조회 */ {
            String nickname = null;
            List<Comment> comments = commentRepository.findByNickname(nickname);
            List <Comment> expected = Arrays.asList();
            assertEquals(expected, comments, "Null의 모든 댓글을 출력");


        }

        /* Case 4 : ""의 모든 댓글 조회 */ {
            String nickname = "";
            List<Comment> comments = commentRepository.findByNickname(nickname);

            List<Comment> expected = Arrays.asList();

            assertEquals(expected, comments);

        }

        /* Case 5 : "a"의 모든 댓글 조회 */ {
            String nickname = "a";
            List<Comment> comments = commentRepository.findByNickname(nickname);

            List<Comment> expected = Arrays.asList();

            assertEquals(expected, comments);

        }

    }
}