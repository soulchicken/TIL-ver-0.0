# 파이썬에서 데이터 베이스 사용하기

## 1. 데이터 베이스(sql lite3)와 파이썬 파일을 연결하기

- `sqllite3` 모듈을 추가하고 파일을 열고 커서를 생성한다.

```python
# 모듈 추가
import sqlite3

# DB 파일 열기 (database_study.db)
connect_db = sqlite3.connect('./database_study.db')

# 커서 생성
cur = connect_db.cursor()
```

## 2. 명령어 만들기

- SQL쿼리문을 문자열로 만든다.

```python
INSERT_SQL = """
    INSERT INTO Item(code,name,price) VALUES (?,?,?);  
"""
```

## 3. 명령어 실행하기

- 위에 만든 `INSERT_SQL` 명령어를 실행해보자
- 예시 : 데이터 1개만 넣을 경우) : `cur.execute(INSERT_SQL,('A123123','수학책','5000'))`
- 예시 2 여러 데이터를 넣는 경우) : `cur.executemany(INSERT_SQL,리스트)`

## 4. 명령어가 끝나고 난 이후

```python
# 커밋 : INSERT, UPDATE, DELETE 이후엔 커밋을 해야한다
connect_db.commit()

# 데이터베이스 닫기
connect_db.close()
```
