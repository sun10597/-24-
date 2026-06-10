select user();

create user 'hr'@'%' identified by 'hr';

ALTER USER 'hr'@'%' IDENTIFIED BY 'hr';
FLUSH PRIVILEGES;

GRANT ALL PRIVILEGES ON hr.* TO 'hr'@'%';

-- 1. hrdb 데이터베이스가 없다면 생성 (이미 있다면 통과)
CREATE DATABASE IF NOT EXISTS hrdb;

-- 2. hr 유저에게 hrdb 데이터베이스에 대한 모든 권한 부여
GRANT ALL PRIVILEGES ON hrdb.* TO 'hr'@'%';

-- 3. 권한 설정 적용
FLUSH PRIVILEGES;


CREATE TABLE board (
    board_id    INT AUTO_INCREMENT PRIMARY KEY, 
    title       VARCHAR(200) NOT NULL,
    content     TEXT,
    user_id     VARCHAR(100),
    author_name VARCHAR(100),
    regdate     DATETIME DEFAULT NOW(),
    view_cnt    INT DEFAULT 0
);


INSERT INTO board (title, content, user_id, author_name) 
VALUES ('안녕하세요, 가입 인사드립니다!', '오늘 처음 가입했어요. 잘 부탁드립니다!', 'lion123', '사자');

INSERT INTO board (title, content, user_id, author_name) 
VALUES ('자바 JDBC 공부 꿀팁 공유', 'DTO와 DAO 구조를 먼저 이해하는 게 정말 중요하네요.', 'tiger_dev', '호랑이');

INSERT INTO board (title, content, user_id, author_name) 
VALUES ('게시판 만들기 완성!', '드디어 CRUD 기능을 모두 구현했습니다. 뿌듯하네요.', 'bear_ok', '곰');

CREATE TABLE user (
    user_id     VARCHAR(50) PRIMARY KEY, -- 아이디 (PK)
    password    VARCHAR(100) NOT NULL,   -- 비밀번호
    name        VARCHAR(50) NOT NULL,    -- 이름
    email       VARCHAR(100) UNIQUE,     -- 이메일 (중복 방지)
    created_at  DATETIME DEFAULT NOW()   -- 가입일
);






CREATE TABLE category (
    category_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    color_code VARCHAR(7) DEFAULT '#000000' 
);

CREATE TABLE schedule (
    schedule_id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(200) NOT NULL,
    content TEXT,
    start_at DATETIME NOT NULL,
    end_at DATETIME NOT NULL,
    status VARCHAR(20) DEFAULT '미완료',
    category_id INT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (category_id) REFERENCES category(category_id) ON DELETE SET NULL
);


INSERT INTO category (name, color_code) VALUES ('공부', '#ffffff');
INSERT INTO category (name, color_code) VALUES ('알바', '#eeeeee');
INSERT INTO category (name, color_code) VALUES ('개인', '#111111');

INSERT INTO schedule (title, content, start_at, end_at, status, category_id) 
VALUES ('자바 프로젝트 설계', '스케쥴러 만들기', '2026-04-23 13:00:00', '2026-04-23 16:00:00', '공부', 1);

delete from schedule where schedule_id = 1;