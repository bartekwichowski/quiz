INSERT INTO category(id, name) VALUES(100, 'CATEGORY_1');
INSERT INTO category(id, name) VALUES(101, 'CATEGORY_2');

INSERT INTO question(id, category_id, question) VALUES(300, 100, 'QUESTION_1');
INSERT INTO question(id, category_id, question) VALUES(301, 101, 'QUESTION_2');

INSERT INTO answer(id, question_id, answer, correct) VALUES (200, 300, 'ANSWER_1_T', TRUE);
INSERT INTO answer(id, question_id, answer, correct) VALUES (201, 300, 'ANSWER_2_T', TRUE);
INSERT INTO answer(id, question_id, answer, correct) VALUES (202, 300, 'ANSWER_3', FALSE);
INSERT INTO answer(id, question_id, answer, correct) VALUES (203, 301, 'ANSWER_4_T', TRUE);
INSERT INTO answer(id, question_id, answer, correct) VALUES (204, 301, 'ANSWER_5', FALSE);
