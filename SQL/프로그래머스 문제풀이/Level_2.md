# 프로그래머스 MySQL Level 2

## CONTENTS

  - [1. 고양이와 개는 몇 마리 있을까](#1-고양이와-개는-몇-마리-있을까)
  - [2. 루시와 엘라 찾기](#2-루시와-엘라-찾기)
  - [3. 최솟값 구하기](#3-최솟값-구하기)
  - [4. 동명 동물 수 찾기](#4-동명-동물-수-찾기)
  - [5. 이름에 el이 들어가는 동물 찾기](#5-이름에-el이-들어가는-동물-찾기)
  - [6. 동물 수 구하기](#6-동물-수-구하기)
  - [7. 입양 시각 구하기(1)](#7-입양-시각-구하기1)
  - [8. NULL 처리하기](#8-null-처리하기)
  - [9. 중성화 여부 파악하기](#9-중성화-여부-파악하기)
  - [10. 중복 제거하기](#10-중복-제거하기)
  - [11. DATETIME에서 DATE로 형 변환](#11-datetime에서-date로-형-변환)

### 1. 고양이와 개는 몇 마리 있을까

- 문제 : 동물 보호소에 들어온 동물 중 고양이와 개가 각각 몇 마리인지 조회하는 SQL문을 작성해주세요. 이때 고양이를 개보다 먼저 조회해주세요.
- 해결
  1. `ANIMAL_INS`의 `ANIMAL_TYPE` 데이터를 가져오기
  2. `GROUP BY`, `COUNT()`를 사용해 수량 테이블 만들기
  3. 동물 종의 이름 순으로 정렬
- 코드

```SQL
SELECT   ANIMAL_TYPE,
         COUNT(ANIMAL_TYPE)
FROM ANIMAL_INS
GROUP BY ANIMAL_TYPE
ORDER BY ANIMAL_TYPE
```

### 2. 루시와 엘라 찾기

- 문제 : 동물 보호소에 들어온 동물 중 이름이 Lucy, Ella, Pickle, Rogan, Sabrina, Mitty인 동물의 아이디와 이름, 성별 및 중성화 여부를 조회하는 SQL 문을 작성해주세요. 이때 결과는 아이디 순으로 조회해주세요.
- 해결
  1. `ANIMAL_INS`의 아이디, 이름, 성별, 중성화 여부 데이터를 가져오기
  2. `ANIMAL_ID`순으로 정렬하기
  3. `WHERE` 절에서 이름이 원하는 이름들과 같은지 조건화
- 코드

```SQL
SELECT   ANIMAL_ID,
        NAME,
        SEX_UPON_INTAKE
FROM     ANIMAL_INS
WHERE    NAME
        IN ('Lucy','Ella',
            'Pickle', 'Rogan',
            'Sabrina', 'Mitty')
ORDER BY ANIMAL_ID;
```

### 3. 최솟값 구하기

- 문제 : 동물 보호소에 가장 먼저 들어온 동물은 언제 들어왔는지 조회하는 SQL 문을 작성해주세요.
- 해결
  1. `ANIMAL_INS`의 데이터를 가져오기
  2. 가장 먼저 들어온 날짜 조회
- 코드

```SQL
SELECT MIN(DATETIME)
AS     시간
FROM   ANIMAL_INS
```

### 4. 동명 동물 수 찾기

- 문제 : 동물 보호소에 들어온 동물 이름 중 두 번 이상 쓰인 이름과 해당 이름이 쓰인 횟수를 조회하는 SQL문을 작성해주세요. 이때 결과는 이름이 없는 동물은 집계에서 제외하며, 결과는 이름 순으로 조회해주세요.
- 해결
  1. `ANIMAL_INS`의 모든 데이터를 가져오기
  2. `GROUP BY`, `COUNT()`로 집계
  3. `HAVING`절로 `NULL` 제외하고 2번 이상 쓰인 이름만 나오도록 조건화
  4. `NAME`순으로 정렬하기
- 코드

```SQL
SELECT   NAME,
         COUNT(NAME)
FROM     ANIMAL_INS
GROUP BY NAME
HAVING   NAME IS NOT NULL
         AND COUNT(NAME) > 1
```

### 5. 이름에 el이 들어가는 동물 찾기

- 문제 : 보호소에 돌아가신 할머니가 기르던 개를 찾는 사람이 찾아왔습니다. 이 사람이 말하길 할머니가 기르던 개는 이름에 'el'이 들어간다고 합니다. 동물 보호소에 들어온 동물 이름 중, 이름에 "EL"이 들어가는 개의 아이디와 이름을 조회하는 SQL문을 작성해주세요. 이때 결과는 이름 순으로 조회해주세요. 단, 이름의 대소문자는 구분하지 않습니다.
- 해결
  1. `ANIMAL_INS`의 `ANIMAL_ID`, `NAME`을 조회한다.
  2. `WHERE`절의 `LIKE`로 이름에 `EL`이 들어가는지 조건화
  3. 동물의 종이 개가 되도록 조건화
  4. `NAME`순으로 정렬하기
- 코드

```SQL
SELECT   ANIMAL_ID,
         NAME
FROM     ANIMAL_INS
WHERE    ANIMAL_TYPE = 'Dog'
         AND NAME LIKE '%EL%'
ORDER BY NAME
```

### 6. 동물 수 구하기

- 문제 : 동물 보호소에 동물이 몇 마리 들어왔는지 조회하는 SQL 문을 작성해주세요.
- 해결
  1. `ANIMAL_INS`의 데이터 가져오기
  2. `COUNT`로 전체 수 조회
- 코드

```SQL
SELECT COUNT(*)
       AS count
FROM   ANIMAL_INS
```

### 7. 입양 시각 구하기(1)

- 문제 : 보호소에서는 몇 시에 입양이 가장 활발하게 일어나는지 알아보려 합니다. 09:00부터 19:59까지, 각 시간대별로 입양이 몇 건이나 발생했는지 조회하는 SQL문을 작성해주세요. 이때 결과는 시간대 순으로 정렬해야 합니다.
- 해결
  1. `ANIMAL_OUTS`의 데이터를 가져오기
  2. `GROUP BY`로 `HOUR(DATETIME)` 묶기
  3. 09:00 ~ 19:59 사이에 들어온 입양건으로 조건화
  3. 시간과 `COUNT`를 조회
  4. 시간순 정렬
- 코드

```SQL
SELECT   HOUR(DATETIME) AS HOUR,
         COUNT(HOUR(DATETIME)) AS COUNT
FROM     ANIMAL_OUTS
WHERE    HOUR(DATETIME) >= 9
         AND HOUR(DATETIME) < 20
GROUP BY HOUR(DATETIME)
ORDER BY HOUR(DATETIME)
```

### 8. NULL 처리하기

- 문제 : ㅇ
- 해결
  1. `ANIMAL_INS`의 모든 데이터를 가져오기 : `SELECT * FROM ANIMAL_INS`
  2. `ANIMAL_ID`순으로 정렬하기 : `ORDER BY ANIMAL_ID ASC`
- 코드

```SQL
```

### 9. 중성화 여부 파악하기

- 문제 : ㅇ
- 해결
  1. `ANIMAL_INS`의 모든 데이터를 가져오기 : `SELECT * FROM ANIMAL_INS`
  2. `ANIMAL_ID`순으로 정렬하기 : `ORDER BY ANIMAL_ID ASC`
- 코드

```SQL
```

### 10. 중복 제거하기

- 문제 : ㅇ
- 해결
  1. `ANIMAL_INS`의 모든 데이터를 가져오기 : `SELECT * FROM ANIMAL_INS`
  2. `ANIMAL_ID`순으로 정렬하기 : `ORDER BY ANIMAL_ID ASC`
- 코드

```SQL
```

### 11. DATETIME에서 DATE로 형 변환

- 문제 : ㅇ
- 해결
  1. `ANIMAL_INS`의 모든 데이터를 가져오기 : `SELECT * FROM ANIMAL_INS`
  2. `ANIMAL_ID`순으로 정렬하기 : `ORDER BY ANIMAL_ID ASC`
- 코드

```SQL
```
