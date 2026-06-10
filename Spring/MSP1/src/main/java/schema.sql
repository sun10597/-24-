-- MySQL 외래키 체크 일시 해제 (테이블 재생성 시 에러 방지)
SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS chat_message;
DROP TABLE IF EXISTS chat_participant;
DROP TABLE IF EXISTS chat_room;
DROP TABLE IF EXISTS friend;
DROP TABLE IF EXISTS users;

SET FOREIGN_KEY_CHECKS = 1;

-- 1. 유저 테이블
CREATE TABLE users (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       email VARCHAR(100) NOT NULL UNIQUE,
                       password VARCHAR(255) NOT NULL,
                       name VARCHAR(50) NOT NULL,
                       role VARCHAR(20) NOT NULL,          -- USER, ADMIN
                       status VARCHAR(20) NOT NULL,        -- ACTIVE, BLACK
                       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- 2. 친구 관계 테이블
CREATE TABLE friend (
                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                        user_id BIGINT NOT NULL,
                        friend_id BIGINT NOT NULL,
                        created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                        FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
                        FOREIGN KEY (friend_id) REFERENCES users(id) ON DELETE CASCADE
);

-- 3. 채팅방 테이블 (애그리거트 루트)
CREATE TABLE chat_room (
                           id BIGINT AUTO_INCREMENT PRIMARY KEY,
                           title VARCHAR(100) NOT NULL,
                           created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- 4. 채팅방 참여자 매핑 테이블
CREATE TABLE chat_participant (
                                  id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                  chat_room_id BIGINT NOT NULL,
                                  user_id BIGINT NOT NULL,
                                  joined_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                  FOREIGN KEY (chat_room_id) REFERENCES chat_room(id) ON DELETE CASCADE,
                                  FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);

-- 5. 채팅 메시지 테이블
CREATE TABLE chat_message (
                              id BIGINT AUTO_INCREMENT PRIMARY KEY,
                              chat_room_id BIGINT NOT NULL,
                              sender_id BIGINT NOT NULL,
                              content TEXT NOT NULL,
                              sent_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                              FOREIGN KEY (chat_room_id) REFERENCES chat_room(id) ON DELETE CASCADE,
                              FOREIGN KEY (sender_id) REFERENCES users(id) ON DELETE CASCADE
);