-- 기존 인덱스를 삭제
DROP INDEX idx_score ON score;

-- 새로운 인덱스를 생성
CREATE INDEX idx_score ON score(score);