# 테이블 간의 결합 (JOIN)

- 관계 : `1:1`, `1:N`, `N:N`

## ERM (Entity-Relationship Modelling)

- 개체-관계 모델링으로 관계형 데이터 베이스에서 테이블을 모델링할 때 사용
- 개체(Entity) : 하나 이상의 속성(Attribute)으로 구성된 객체
- 관계(Relationship) : 속성들(Entity) 간의 관계
- ex) 회원 테이블 개체에 이름, 가입 일자, 나이 등의 속성을 갖는다.
      상품 테이블 개체에는 상품코드, 카테고리, 가격 등의 속성을 갖는다.
      회원 테이블과 상품 테이블 간의 관계(Relationship)으로 주문 테이블을 만든다.

## FK (FOREIGN KEY)

- 다른 테이블에서 PK(PRIVATE KEY)로 사용된 열

## JOIN

### INNER JOIN

- 두 테이블 간의 공통 값이 매칭되는 데이터만 결합
- ex) CUSTOMER 테이블과 SALES 테이블의 회원번호 기준으로 매칭

```sql
SELECT * FROM CUSTOMER AS A
INNER JOIN SALES AS B
ON A.MEM_NO = B.MEM_NO;
```

- ex) CUSTOMER 테이블과 SALES 테이블 간의 관계가 1:N 인지 확인하기

```sql
SELECT * FROM CUSTOMER AS A
INNER JOIN SALES AS B
ON A.MEM_NO = B.MEM_NO
WHERE A.MEM_NO == '100070';
```

### LEFT JOIN (RIGHT JOIN)

- 두 테이블 간의 공통 값이 매칭되는 데이터만 결합 + 왼쪽(오른쪽) 테이블에 매칭되지 않는 데이터는 `NULL`로 표기
- ex) LEFT JOIN 사용. CUSTOMER 테이블과 SALES 테이블의 회원번호 기준으로 매칭 `NULL`은 주문하지 않은 회원

```sql
SELECT * FROM CUSTOMER AS A
INNER JOIN SALES AS B
ON A.MEM_NO = B.MEM_NO;
```

- ex) 회원테이블에 존재하지 않지만 (비회원) 주문을 한 데이터 확인

```sql
SELECT * FROM CUSTOMER AS A
RIGHT JOIN SALES AS B
ON A.MEM_NO = B.MEM_NO
WHERE A.MEM_NO IS NULL;
```

### OUTTER JOIN

- d
  
## 테이블 결합(JOIN)과 테이블 조회(SELECT)

- SELECT에서 FROM 절 + JOIN 을 사용
- WHERE 절로 조건화한다
- GROUP BY 절로 그룹화한다
- HAVING 절로 그룹을 필터링한다

```SQL
SELECT   열1
         ,열2
         ,집계함수() AS 열이름
FROM     테이블명A AS A
INNER JOIN 테이블명B AS B
WHERE    조건
GROUP BY 열1
         ,열2
HAVING   조건
ORDER BY 열 (DESC or ASC);
```

## 3개 이상의 테이블 JOIN 예시

```SQL
SELECT      *
FROM        테이블명A AS A
LEFT JOIN   테이블명B AS B
ON          A.컬럼명A == B.컬럼명B

LEFT JOIN   테이블명C AS C
ON          A.컬럼명A == C.컬럼명C;
```
