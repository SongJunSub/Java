/*
 * 실전 데이터베이스 성능/운영 (심화)
 * - 인덱스 튜닝 SQL, Flyway 마이그레이션 스크립트, Replication 장애 복구
 */

// 인덱스 튜닝 SQL 예제 (주석 참고)
/*
-- 인덱스 생성
CREATE INDEX idx_user_email ON user(email);

-- 인덱스 사용 확인
EXPLAIN SELECT * FROM user WHERE email = 'test@example.com';
*/

// Flyway 마이그레이션 스크립트 예제 (주석 참고)
/*
-- V1__create_user_table.sql
CREATE TABLE user (
  id BIGINT PRIMARY KEY,
  name VARCHAR(100),
  email VARCHAR(100)
);

-- V2__add_age_column.sql
ALTER TABLE user ADD COLUMN age INT;
*/

// Replication 장애 복구 예제 (주석 참고)
/*
# MySQL Replication 장애 복구
STOP SLAVE;
CHANGE MASTER TO MASTER_LOG_FILE='mysql-bin.000123', MASTER_LOG_POS=456789;
START SLAVE;
SHOW SLAVE STATUS\G
*/

public class DbOpsExamples {
    public static void main(String[] args) {
        System.out.println("인덱스 튜닝 SQL, Flyway 마이그레이션, Replication 장애 복구 등은 주석의 예시를 참고하세요.\n실행은 별도 DB 환경에서 가능합니다.");
    }
} 