-- User 테이블 생성
CREATE TABLE user (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

-- Score 테이블 생성
CREATE TABLE score (
    id BINARY(16) PRIMARY KEY,
    uid BIGINT NOT NULL,
    score INT NOT NULL
) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
