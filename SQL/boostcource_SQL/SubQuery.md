# 서브 쿼리 (Sub Query)

    - SELECT 문 안에 SELECT 문이 있는 쿼리를 뜻한다
    - Main Query : 지금까지 학습한 일반적인 SELECT 문
    - 종류 : SELECT 절, FROM 절, WHERE 절 서브 쿼리가 존재한다

## SELECT 절 Sub Query

- 처리 속도가 느려서 잘 사용되지는 않는 서브 쿼리
- 스칼라 서브 쿼리 (스칼라 : 하나의 값만 보유하는 원자량)
```sql
SELECT *, (SELECT GENDER FROM CUSTOMER WHERE A.MEM_NO == B.MEM_NO) AS GENDER
FROM SALES AS A;
```

## FROM 절 Sub Query

- 가장 많이 사용되는 서브 쿼리로 JOIN과 함께 많이 사용된다
- 테이블로 사용되는 서브 쿼리
- 열 이름, 테이블 이름 지정
```sql
SELECT *
FROM 
    (SELECT MEM_NO,
            COUNT(ORDER_NO) AS 주문횟수
    FROM SALES
    WHERE A.MEM_NO == B.MEM_NO)
    AS A;
```

## WHERE 절 Sub Query

- WHERE절 안에 리스트 형태로 사용하는 서브 쿼리
```sql
SELECT COUNT(ORDER_NO) AS 주문 횟수
FROM SALES
WHERE MEM_NO
    IN (SELECT MEM_NO
        FROM CUSTOMER
        WHERE YEAR(JOIN_DATE) == 2019);
```
