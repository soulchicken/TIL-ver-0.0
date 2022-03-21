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

- 문제 : ㅇ
- 해결
  1. `ANIMAL_INS`의 모든 데이터를 가져오기 : `SELECT * FROM ANIMAL_INS`
  2. `ANIMAL_ID`순으로 정렬하기 : `ORDER BY ANIMAL_ID ASC`
- 코드

```SQL
```

### 4. 동명 동물 수 찾기

- 문제 : ㅇ
- 해결
  1. `ANIMAL_INS`의 모든 데이터를 가져오기 : `SELECT * FROM ANIMAL_INS`
  2. `ANIMAL_ID`순으로 정렬하기 : `ORDER BY ANIMAL_ID ASC`
- 코드

```SQL
```

### 5. 이름에 el이 들어가는 동물 찾기

- 문제 : ㅇ
- 해결
  1. `ANIMAL_INS`의 모든 데이터를 가져오기 : `SELECT * FROM ANIMAL_INS`
  2. `ANIMAL_ID`순으로 정렬하기 : `ORDER BY ANIMAL_ID ASC`
- 코드

```SQL
```

### 6. 동물 수 구하기

- 문제 : ㅇ
- 해결
  1. `ANIMAL_INS`의 모든 데이터를 가져오기 : `SELECT * FROM ANIMAL_INS`
  2. `ANIMAL_ID`순으로 정렬하기 : `ORDER BY ANIMAL_ID ASC`
- 코드

```SQL
```

### 7. 입양 시각 구하기(1)

- 문제 : ㅇ
- 해결
  1. `ANIMAL_INS`의 모든 데이터를 가져오기 : `SELECT * FROM ANIMAL_INS`
  2. `ANIMAL_ID`순으로 정렬하기 : `ORDER BY ANIMAL_ID ASC`
- 코드

```SQL
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
