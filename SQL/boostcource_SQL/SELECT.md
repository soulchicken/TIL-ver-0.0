# 데이터 조회 (SELECT)

- 여러 절들과 같이 사용된다.
- `SELECT, FROM, WHERE, GROUP BY, HAVING, ORDER BY` 순으로 사용한다.

## 보기 좋게 작성하기

```SQL
SELECT   열1
         ,열2
         ,집계함수() AS 열이름
FROM     테이블명
WHERE    조건
GROUP BY 열1
         ,열2
HAVING   조건
ORDER BY 열 (DESC or ASC);
```

## **FROM 절** (필수)

- `FROM 테이블 명` : 해당 테이블을 통해서 조회한다.

## WHERE 절

- `WHERE` : FROM 절에 특정 조건으로 필터링한다.

## GROUP BY

- GROUP BY 의 열들을 SELECT 절에도 작성해야한다.
- `GROUP BY` : 열 별로 그룹화한다. 집계함수를 사용하게 된다.

## HAVING

- GROUP BY 이후에 사용된다.
- `HAVING` : 그룹화된 새로운 테이블을 특정 조건으로 필터링한다.

## ORDER BY

- `ORDER BY` : 열 정렬
- `DESC` : 내림차순
- `ASC` : 오름차순
