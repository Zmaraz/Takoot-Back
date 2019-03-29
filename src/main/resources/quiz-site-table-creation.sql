

DROP TABLE Flags;
DROP TABLE Answers;
DROP TABLE Question;
DROP TABLE High_Scores;
DROP TABLE Quizzes;
DROP TABLE Quiz_Users;
DROP TABLE Default_Status;
DROP TABLE Difficulty;
DROP TABLE Categories;


CREATE TABLE Categories (
    category_id     NUMBER,
    quiz_category   VARCHAR2 (30),
    
    CONSTRAINT categories_pk
    PRIMARY KEY (category_id)
);

CREATE TABLE Difficulty (
    difficulty_id   NUMBER,
    difficulty      VARCHAR2 (10),
    
    CONSTRAINT difficulty_pk
    PRIMARY KEY (difficulty_id)
);

CREATE TABLE Default_Status (
    default_id      NUMBER,
    default_value   VARCHAR2 (20),
    
    CONSTRAINT default_pk
    PRIMARY KEY (default_id)
);

CREATE TABLE Quiz_Users (
    user_id         NUMBER,
    first_name      VARCHAR2 (100),
    last_name       VARCHAR2 (100),
    username        VARCHAR2 (50) UNIQUE NOT NULL,
    user_password   VARCHAR2 (50),
    email           VARCHAR2 (250) UNIQUE NOT NULL,
    
    CONSTRAINT user_id_pk
    PRIMARY KEY (user_id)
);    

CREATE TABLE quizzes (
    quiz_id             NUMBER,
    title               VARCHAR2 (100),
    author_id           NUMBER,
    date_created        VARCHAR2 (250),
    date_last_updated   VARCHAR2 (250),
    category_id         NUMBER,
    difficulty_id       NUMBER,
    default_id          NUMBER,
    
    CONSTRAINT quizzes_pk
    PRIMARY KEY (quiz_id),
    
    CONSTRAINT author_id_fk
    FOREIGN KEY (author_id)
    REFERENCES quiz_users (user_id) ON DELETE CASCADE,
    
    CONSTRAINT category_id_fk
    FOREIGN KEY (category_id)
    REFERENCES categories (category_id) ON DELETE CASCADE,
    
    CONSTRAINT difficulty_id_fk 
    FOREIGN KEY (difficulty_id)
    REFERENCES difficulty (difficulty_id) ON DELETE CASCADE,
    
    CONSTRAINT default_id_fk 
    FOREIGN KEY (default_id) 
    REFERENCES default_status (default_id) ON DELETE CASCADE
);

CREATE TABLE high_scores (
    score_id    NUMBER,
    user_id     NUMBER,
    quiz_id     NUMBER,
    score       NUMBER NOT NULL,
    
    CONSTRAINT high_scores_pk
    PRIMARY KEY (score_id),
    
    CONSTRAINT user_id_fk
    FOREIGN KEY (user_id)
    REFERENCES quiz_users (user_id) ON DELETE CASCADE,
    
    CONSTRAINT quiz_id_fk
    FOREIGN KEY (quiz_id)
    REFERENCES quizzes (quiz_id) ON DELETE CASCADE
);

CREATE TABLE Question (
    question_id     NUMBER,
    question        VARCHAR2 (500),
    quiz_id         NUMBER,
    
    CONSTRAINT question_pk 
    PRIMARY KEY (question_id),
    
    CONSTRAINT quiz_question_fk
    FOREIGN KEY (quiz_id) 
    REFERENCES quizzes (quiz_id) ON DELETE CASCADE
);

CREATE TABLE Answers (
    answer_id       NUMBER,
    question_id     NUMBER,
    answer          VARCHAR2 (500),
    answer_value    NUMBER,
    
    CONSTRAINT answer_pk
    PRIMARY KEY (answer_id),
    
    CONSTRAINT question_fk
    FOREIGN KEY (question_id)
    REFERENCES Question (question_id) ON DELETE CASCADE
);

CREATE TABLE Flags (
    flag_id             NUMBER,
    question_id         NUMBER,
    flag_description    VARCHAR2 (500) NOT NULL,
    
    CONSTRAINT flags_pk
    PRIMARY KEY (flag_id),
    
    CONSTRAINT ques_flag_fk 
    FOREIGN KEY (question_id) 
    REFERENCES question (question_id) ON DELETE CASCADE 
);


INSERT INTO Quiz_Users VALUES (1, 'Ricky', 'Bobby', 'Shake', 'password', 'rb@hotmail.com');
INSERT INTO Quiz_Users VALUES (2, 'Kal', 'Nooten', 'Bake', 'password', 'kn@hotmail.com');
INSERT INTO Quiz_Users VALUES (3, 'Princess', 'Rainbow', 'PR', 'girlpower', 'pr@hotmail.com');
INSERT INTO Quiz_Users VALUES (4, 'Ron', 'Burgandy', 'RonnyB', 'password', 'ronnyb@hotmail.com');
INSERT INTO Quiz_Users VALUES (5, 'Jon', 'Snow', 'poorjon', 'password', 'poorjon@hotmail.com');

INSERT INTO Difficulty VALUES (1, 'easy');
INSERT INTO Difficulty VALUES (2, 'medium');
INSERT INTO Difficulty VALUES (3, 'hard');

INSERT INTO Default_Status VALUES (1, 'default');
INSERT INTO Default_Status VALUES (2, 'user created');

INSERT INTO Categories VALUES (1, 'Movies');
INSERT INTO Categories VALUES (2, 'Television');
INSERT INTO Categories VALUES (3, 'Animals');
INSERT INTO Categories VALUES (4, 'Olympic Sports');
INSERT INTO Categories VALUES (5, '2000s Throwback');
INSERT INTO Categories VALUES (6, 'Geology');

--INSERT INTO Quizzes VALUES (1, 'Blah', 1, 'poop', 'peep', 1, 1, 2);
INSERT INTO Quizzes VALUES (1, 'Rom Coms', 1, '3/28/19', '3/28/19', 1, 1, 2);

--INSERT INTO Question VALUES (1, 'Hello?', 1);

--INSERT INTO Answers VALUES (1, 1, 'Test answer', 0);

--INSERT INTO Flags VALUES (1, 1, 'This question sucked!');

--INSERT INTO High_Scores VALUES (1, 2, 1, 60); 
INSERT INTO High_Scores VALUES (1, 1, 1, 80);
INSERT INTO High_Scores VALUES (2, 2, 1, 60);
INSERT INTO High_Scores VALUES (3, 3, 1, 100);
INSERT INTO High_Scores VALUES (4, 4, 1, 40);
INSERT INTO High_Scores VALUES (5, 5, 1, 0);

DROP SEQUENCE quiz_seq;
CREATE SEQUENCE quiz_seq
MINVALUE 1 
MAXVALUE 999999999 
INCREMENT BY 1
START WITH 2;

DROP SEQUENCE question_seq;
CREATE SEQUENCE question_seq
MINVALUE 1 
MAXVALUE 999999999 
INCREMENT BY 1
START WITH 1;

DROP SEQUENCE highscore_seq;
CREATE SEQUENCE highscore_seq
MINVALUE 1 
MAXVALUE 999999999 
INCREMENT BY 1
START WITH 6;

DROP SEQUENCE flags_seq;
CREATE SEQUENCE flags_seq
MINVALUE 1 
MAXVALUE 999999999 
INCREMENT BY 1
START WITH 1;

DROP SEQUENCE answers_seq;
CREATE SEQUENCE answers_seq
MINVALUE 1 
MAXVALUE 999999999 
INCREMENT BY 1
START WITH 1;

DROP SEQUENCE user_sequence;
CREATE SEQUENCE user_sequence
MINVALUE 1 
MAXVALUE 999999999 
INCREMENT BY 1
START WITH 6;

commit;
select * from quiz_users;
