-- 데이터 베이스 생성 및 사용
CREATE DATABASE Practice01;
USE practice01;

-- 회원테이블 생성
CREATE TABLE 회원테이블 (
	회원번호 INT PRIMARY KEY,
    이름 VARCHAR(20),
    가입일자 DATE NOT NULL,
    수신동의 BIT
    );
    
-- 테이블 조회
SELECT * FROM 회원테이블;

-- 테이블에 컬럼 추가
ALTER TABLE 회원테이블 ADD 성별 VARCHAR(2);

-- 테이블 데이터타입 변경
ALTER TABLE 회원테이블 MODIFY 성별 VARCHAR(20);

-- 테이블 명 변경
ALTER TABLE 회원테이블 RENAME column 이름 to 성함;
ALTER TABLE 회원테이블 CHANGE 성함 이름 VARCHAR(20); 

USE MYSQL;

SELECT * FROM USER;