INSERT INTO article(id, title, content) VALUES(1, '가가가가', '1111');
INSERT INTO article(id, title, content) VALUES(2, '나나나나', '2222');
INSERT INTO article(id, title, content) VALUES(3, '다다다다', '3333');

-- article 더미 데이터
INSERT INTO article(id, title, content) VALUES(4, '당신의 인생 영화는?', '댓글 ㄱ');
INSERT INTO article(id, title, content) VALUES(5, '당신의 소울 푸드는?', '댓글 ㄱㄱ');
INSERT INTO article(id, title, content) VALUES(6, '당신의 취미는?', '댓글 ㄱㄱㄱ');

-- comment 더미 데이터
-- 4번 데이터
INSERT INTO comment(id, article_id, nickname, body) VALUES(1, 4, 'Park', '기생충');
INSERT INTO comment(id, article_id, nickname, body) VALUES(2, 4, 'Cha', '헤어질 결심');
INSERT INTO comment(id, article_id, nickname, body) VALUES(3, 4, 'Lee', '괴물');

-- 5번 데이터
INSERT INTO comment(id, article_id, nickname, body) VALUES(4, 5, 'Park', '곱창');
INSERT INTO comment(id, article_id, nickname, body) VALUES(5, 5, 'Cha', '떡볶이');
INSERT INTO comment(id, article_id, nickname, body) VALUES(6, 5, 'Lee', '라면');

-- 6번 데이터
INSERT INTO comment(id, article_id, nickname, body) VALUES(7, 6, 'Park', '코딩하기');
INSERT INTO comment(id, article_id, nickname, body) VALUES(8, 6, 'Cha', '멍 때리기');
INSERT INTO comment(id, article_id, nickname, body) VALUES(9, 6, 'Lee', '픽셀 아트');

