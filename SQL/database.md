# SQL

## 1. SQL 데이터타입

- 테이블은 각 열마다 **반드시 1가지의 데이터 타입**으로 정의되어야 한다.

### 1.1. SQLite3에서 사용한 데이터 타입

- integer : 정수
- real : 실수
- text : 문자열
- null : null 값 (데이터 없음)

### 1.2. MySQL에서 사용한 데이터 타입

- 숫자형
  - BIT : 논리형
  - INT : 정수
  - BIGNT : 정수
  - FLOAT : 실수
  - DOUBLE : 실수

- 문자형
  - CHAR(n) : 고정길이 문자열
  - NCHAR(n) : 유니코드 고정길이 문자열
  - VARCHAR(n) : 가변길이 문자열
  - NVARCHAR(n) : 유니코드 가변길이 문자열

- 날짜형
  - DATETIME : YYYY:MM:DD HH:MM:SS
  - DATE : YYYY:MM:DD
  - TIME : HH:MM:SS

</br>

> **데이터 정의어 DLL (Data Definition Language)**
> - 테이블을 생성, 변경, 삭제할 때 사용하는 명령어

## 2. 테이블 생성 쿼리

- `CREAT TABLE 테이블명 (컬럼명1 데이터타입, 컬럼명2 데이터타입);`
- 예 ) `CREAT TABLE students (id integer, name text);`

### 2.1. 제약 조건 1 (PK, primary key)

- 구분짓는 값
- `CREAT TABLE 테이블명 (컬럼명1 데이터타입 primary key, 컬럼명2 데이터타입);`
- 예 ) `CREAT TABLE students (id integer primary key, name text);`
- 학생 번호가 자동증가하게 만들고 싶다면
  - `CREAT TABLE students (id integer primary key autoincrement, name text);`

### 2.2. 제약 조건 2 (not null)

- `null`값이 들어가지 못하게 하는 조건, 데이터가 비어있을 수 없음
- `CREAT TABLE 테이블명 (컬럼명1 데이터타입 not null, 컬럼명2 데이터타입);`
- 예 ) `CREAT TABLE students (id integer not null, name text);`

### 2.3. 제약 조건 3 (default)

- 기본값
- `CREAT TABLE 테이블명 (컬럼명1 데이터타입 default 'value', 컬럼명2 데이터타입);`
- 예 ) `CREAT TABLE students (id integer primary key, name text default '홍길동');`

### 2.4. 제약 조건 4 (unique)

- 유일값  
- `CREAT TABLE 테이블명 (컬럼명1 데이터타입 unique, 컬럼명2 데이터타입);`
- 예 ) `CREAT TABLE students (id integer unique , name text);`
</br>

## 3. 테이블 삭제 쿼리

- `DROP TABLE 테이블명`
- 예 ) `DROP TABLE students`
</br>

## 4. 테이블 수정 쿼리

</br>

### 4.1. 테이블명 수정

- `ALTER TABLE 테이블명 RENAME TO 바꿀 테이블명`
- 예 ) `ALTER TABLE students RENAME TO students_list`

### 4.2. 테이블 컬럼 추가

- `ALTER TABLE 테이블명 ADD COLUMN 컬럼명`
- 예 ) `ALTER TABLE students_list ADD COLUMN sex_type`

### 4.3. 테이블 컬럼 삭제

- `ALTER TABLE 테이블명 DROP COLUMN 컬럼명`
- 예 ) `ALTER TABLE students_list DROP COLUMN sex_type`

### 4.4. 테이블 컬럼 이름 변경

- `ALTER TABLE 테이블명 RENAME COLUMN 컬럼명 TO 바꿀 컬럼명`
- 예 ) `ALTER TABLE students_list RENAME COLUMN sex_type to s ex`
- `ALTER TABLE 회원테이블 CHANGE 컬럼명 바꿀컬럼명 데이터타입;`
- 예 ) `ALTER TABLE 회원테이블 CHANGE 성함 이름 VARCHAR(20);`

### 4.5. 테이블 컬럼 데이터 타입 변경

- `ALTER TABLE 테이블명 MODIFY 컬럼명 VARCHAR(20)` 

> **데이터조작어 DML (Data Manipulation Language)**
> - 데이터를 삽입, 조회, 수정, 삭제할 때 사용하는 명령어

## 5. 데이터 조작 쿼리 (CRUD)

### 5.1. 데이터 행 삽입

- `INSERT INTO 테이블명(컬럼명1, 컬럼명2) VALUES (값1, 값2);`
- 예) `INSERT INTO students_list(id, name) VALUES (99, "전학생");`

### 5.2. 데이터 조회

- 특정 컬럼 선택 : `SELECT 컬럼명1, 컬럼명2 FROM 테이블명;`
- 모든 컬럼 선택 : `SELECT * FROM 테이블명;`
- 특정 컬럼 이름을 다른 이름으로 바꿔서 조회 : `SELECT 컬럼명1 AS 바꾼 이름 FROM 테이블명;`
- `WHERE` 조건 조회 : `SELECT 컬럼명1, 컬럼명2 FROM 테이블명 WHERE 조건;`
- 예) `SELECT id, name FROM students_list WHERE id = 99;`
- `LIKE`, `BETWEEN`, `IN` : WHERE` 조회 조건을 더 상세하게 만들 수 있다.
- `ORDER BY` 정렬 : `SELECT 컬럼명1, 컬럼명2 FROM 테이블명 ORDER BY 컬럼명 [ASC | DESC];`
- `ASC`, `DESC` : 오름차순, 내림차순

### 5.3. 데이터 수정

- `UPDATE 테이블명 SET 컬럼명 = 값, ... WHERE 조건식;`
- 모든 데이터 수정 : `UPDATE 테이블명 SET 컬럼명 = 값`
-  

### 5.4. 데이터 삭제

- `DELETE 테이블명 WHERE 조건식`

> **데이터제어어 DCL (Data Control Language)**
> - 데이터 접근 권한 부여 및 제거할 때 사용하는 명령어
> - 데이터베이스 관리자(DBA)가 특정 사용자(user)에게 데이터 접근 권한을 부여 및 제거할 때 사용하는 명령어

## 6. 사용자 관리

### 6.1. 사용자 확인

- `MYSQL`을 열어서 사용자를 확인할 수 있다.

```SQL
USE MYSQL;
SELECT * FROM USER;
```

### 6.2 사용자 추가

- 사용자의 아이디, 비밀번호를 생성한다.
- `CREATE USER '아이디' @LOCALHOST IDENTIFIED BY '비밀번호'`

### 6.3. 비밀번호 변경

- `SET PASSWORD FOR '아이디' @LOCALHOST = '바꿀 비밀번호'`

### 6.4. 권한 부여

- 권한 : `CREATE, ALERT, DROP, INSERT, DELETE, UPDATE, SELECT 등`
- 특정 권한 부여 : `GRANT 권한1, 권한2 ... ON 데이터베이스명.테이블명 TO '아이디'@LOCALHOST`
- 모든 권한 부여 : `GRANT ALL ON 데이터베이스명.테이블명 TO '아이디'@LOCALHOST`

### 6.5. 권한 삭제

- 특정 권한 삭제 : `REVOKE 권한1, 권한2 ... ON 데이터베이스명.테이블명 TO '아이디'@LOCALHOST`
- 모든 권한 삭제 : `REVOKE ALL ON 데이터베이스명.테이블명 TO '아이디'@LOCALHOST`

### 6.6. 사용자 삭제

- `DROP USER '아이디'@LOCALHOST`

> **트랜잭션 제어어 TCL (Transaction Control Language)**
> - 데이터 조작어 (DML) 사용시 실행, 취소, 임시저장을 하는 명령어
> - 분할할 수 없는 최소단위. 논리적인 작업 영역

## 7. 트랜잭션 제어어

- 실행 (COMMIT) : 모든 작업 완료
- 취소 (ROLLBACK) : 실행 전 상태로 돌려 놓음

### 7.1. 트랜잭션 시작

- `BEGIN` : 명령어를 실행하면 트랜잭션이 시작된다.

### 7.2. 임시 저장

- `ROLLBACK` 지점을 만드는 행위
- `SAVEPOINT 지점이름` : 명령어를 사용하면 그 지점에 세이브포인트가 생긴다.
- `ROLLBACK TO 지점이름` : 해당 지금으로 롤백한다.

## 8. GROUP BY

- `SELECT 컬럼명 FROM 테이블명 GROUP BY 컬럼명`
- 예) `SELECT gender, count(*) FROM user GROUP BY gender`
- 예) `SELECT gender, avg(age) FROM user WHERE age > 20 GROUP BY gender`

## 9. JOIN

- `SELECT 컬럼명1, 컬럼명2 FROM 테이블명1 INNER JOIN 테이블명2 WHERE 조건문;`
- `INNER JOIN`을 `콤마(,)`로 바꾸기도 가능: `SELECT * FROM post, user WHERE post.author = user.email;`
- 예) `SELECT * FROM post, user WHERE post.author = user.email;`
