# 모듈 추가
import sqlite3

# DB 파일 열기 (database_study.db)
connect_db = sqlite3.connect('./database_study.db')

# 커서 생성
cur = connect_db.cursor()

# SQL 명령어 작성
SELECT_SQL = """
    SELECT * FROM Item;
"""

# SQL 명령어 실행
cur.execute(SELECT_SQL)

# 데이터 조회
rows = cur.fetchall()
for row in rows:
    print(row)

# SQL 명령어 작성
SELECT_SQL = """
    SELECT code FROM Item;
"""

# SQL 명령어 실행
cur.execute(SELECT_SQL)

# 데이터 조회
rows = cur.fetchall()
for row in rows:
    print(row)

connect_db.close()