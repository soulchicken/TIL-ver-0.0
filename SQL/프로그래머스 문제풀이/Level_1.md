# 프로그래머스 MySQL Level 1

## CONTENTS

  - [1. 모든 레코드 조회하기](#1-모든-레코드-조회하기)
  - [2. 최댓값 구하기](#2-최댓값-구하기)
  - [3. 이름이 없는 동물의 아이디](#3-이름이-없는-동물의-아이디)
  - [4. 역순 정렬하기](#4-역순-정렬하기)
  - [5. 이름이 있는 동물의 아이디](#5-이름이-있는-동물의-아이디)
  - [6. 아픈 동물 찾기](#6-아픈-동물-찾기)
  - [7. 어린 동물 찾기](#7-어린-동물-찾기)
  - [8. 동물의 아이디와 이름](#8-동물의-아이디와-이름)
  - [9. 여러 기준으로 정렬](#9-여러-기준으로-정렬)
  - [10. 상위 n개의 레코드](#10-상위-n개의-레코드)

### 1. 모든 레코드 조회하기

- 문제 : 동물 보호소에 들어온 모든 동물의 정보를 ANIMAL_ID순으로 조회하는 SQL문을 작성해주세요. SQL을 실행하면 다음과 같이 출력되어야 합니다.
- 해결
  1. `ANIMAL_INS`의 모든 데이터를 가져오기 : `SELECT * FROM ANIMAL_INS`
  2. `ANIMAL_ID`순으로 정렬하기 : `ORDER BY ANIMAL_ID ASC`
- 코드

```SQL
SELECT   *
FROM     ANIMAL_INS
ORDER BY ANIMAL_ID;
```

### 2. 최댓값 구하기

- 문제 : 가장 최근에 들어온 동물은 언제 들어왔는지 조회하는 SQL 문을 작성해주세요.
- 해결
  1. `ANIMAL_INS`의 모든 데이터를 가져오기 : `SELECT * FROM ANIMAL_INS`
  2. SELECT 절에서 * 를 DATE_TIME의 최댓값으로 수정 : `SELECT MAX(DATETIME)`
  3. MAX(DATETIME)의 컬럼 명을 시간으로 변경 : `AS 시간`
- 코드

```SQL
SELECT MAX(DATETIME) AS 시간
FROM   ANIMAL_INS
```

### 3. 이름이 없는 동물의 아이디

- 문제 : 동물 보호소에 들어온 동물 중, 이름이 없는 채로 들어온 동물의 ID를 조회하는 SQL 문을 작성해주세요. 단, ID는 오름차순 정렬되어야 합니다.
- 해결
  1. `ANIMAL_INS`의 `ANIMAL_ID` 데이터를 가져오기
  2. `WHERE`절에서 `NAME IS NULL`을 찾기
  3. 오름차순 정렬
- 코드

```SQL
SELECT ANIMAL_ID
FROM ANIMAL_INS
WHERE NAME IS NULL
ORDER BY ANIMAL_ID;
```

### 4. 역순 정렬하기

- 문제 : 동물 보호소에 들어온 모든 동물의 이름과 보호 시작일을 조회하는 SQL문을 작성해주세요. 이때 결과는 ANIMAL_ID 역순으로 보여주세요. SQL을 실행하면 다음과 같이 출력되어야 합니다.
- 해결
  1. `ANIMAL_INS`의 `NAME, DATETIME` 데이터를 가져오기
  2. `ANIMAL_ID`을 `ORDER BY` 절에서 `DESC`로 정렬
- 코드

```SQL
SELECT NAME, DATETIME
FROM ANIMAL_INS
ORDER BY ANIMAL_ID DESC
```

### 5. 이름이 있는 동물의 아이디

- 문제 : 동물 보호소에 들어온 동물 중, 이름이 있는 동물의 ID를 조회하는 SQL 문을 작성해주세요. 단, ID는 오름차순 정렬되어야 합니다.
- 해결
  1. `ANIMAL_INS`의 `ANIMAL_ID` 데이터를  조회한다
  2. `NAME`이 `NULL`이 아닌 데이터로 필터링한다.
  3. `ID` 오름차순으로 정렬한다.
- 코드

```SQL
SELECT ANIMAL_ID
FROM ANIMAL_INS
WHERE NAME IS NOT NULL
ORDER BY ANIMAL_ID
```

### 6. 아픈 동물 찾기

- 문제 : 동물 보호소에 들어온 동물 중 아픈 동물(INTAKE_CONDITION이 Sick 인 경우를 뜻함)의 아이디와 이름을 조회하는 SQL 문을 작성해주세요. 이때 결과는 아이디 순으로 조회해주세요.
- 해결
  1. `ANIMAL_INS`의 `ANIMAL_ID`와 `NAME`를 조회
  2. `INTAKE_CONDITION`에서 값이 `si3.`인 데이터로 조건화
  3. `ANIMAL_ID` 순으로 정렬
- 코드

```SQL
SELECT ANIMAL_ID, NAME
FROM ANIMAL_INS
WHERE INTAKE_CONDITION = 'sick'
ORDER BY ANIMAL_ID
```

### 7. 어린 동물 찾기

- 문제 : 동물 보호소에 들어온 동물 중 젊은 동물(INTAKE_CONDITION이 Aged가 아닌 경우를 뜻함)의 아이디와 이름을 조회하는 SQL 문을 작성해주세요. 이때 결과는 아이디 순으로 조회해주세요.
- 해결
  1. `ANIMAL_INS`의 `ANIMAL_ID`와 `NAME`를 조회
  2. `INTAKE_CONDITION`에서 값이 `aged`이 아닌 데이터로 조건화
  3. `ANIMAL_ID` 순으로 정렬
- 코드

```SQL
SELECT ANIMAL_ID,NAME
FROM ANIMAL_INS
WHERE INTAKE_CONDITION != 'aged'
ORDER BY ANIMAL_ID
```

### 8. 동물의 아이디와 이름

- 문제 : 동물 보호소에 들어온 모든 동물의 아이디와 이름을 ANIMAL_ID순으로 조회하는 SQL문을 작성해주세요.
- 해결
  1. `ANIMAL_INS`의 `ANIMAL_ID`와 `NAME`를 조회
  2. `ANIMAL_ID` 순으로 정렬
- 코드

```SQL
SELECT ANIMAL_ID, NAME
FROM ANIMAL_INS
ORDER BY ANIMAL_ID
```

### 9. 여러 기준으로 정렬

- 문제 : 동물 보호소에 들어온 모든 동물의 아이디와 이름, 보호 시작일을 이름 순으로 조회하는 SQL문을 작성해주세요. 단, 이름이 같은 동물 중에서는 보호를 나중에 시작한 동물을 먼저 보여줘야 합니다.
- 해결
  1. `ANIMAL_INS`의 `ANIMAL_ID`, `NAME`, `DATETIME`를 조회
  2. `NAME` 순으로 정렬
  3. `DATETIME` 역순으로 정렬
- 코드

```SQL
SELECT ANIMAL_ID, NAME, DATETIME
FROM ANIMAL_INS
ORDER BY NAME,
          DATETIME DESC
```

### 10. 상위 n개의 레코드

- 문제 : 동물 보호소에 가장 먼저 들어온 동물의 이름을 조회하는 SQL 문을 작성해주세요.
- 해결
  1. `ANIMAL_INS`의 `NAME`를 조회 (AS A)
  2. `WHERE` 절에서 서브 쿼리를 사용한다.
  3. `ANIMAL_INS`에서 `DATETIME`이 가장 최신인 값을 찾는다 (AS B)
  4. `WHERE`절에서 `A.DATETIME`과 같다면 출력한다
- 코드

```SQL
SELECT NAME
FROM ANIMAL_INS AS A
WHERE A.DATETIME = (SELECT MIN(DATETIME)
                    FROM ANIMAL_INS AS B)
```
