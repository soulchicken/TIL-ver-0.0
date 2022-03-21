# 모듈 추가
import sqlite3

# DB 파일 열기 (database_study.db)
connect_db = sqlite3.connect('./database_study.db')

# 커서 생성
cur = connect_db.cursor()

# SQL 명령어 작성
CREATE_SQL = """
    CREATE TABLE IF NOT EXISTS Item(
        id integer primary key  autoincrement,
        code text not null,
        name text not null,
        price integer not null
    )
"""
INSERT_SQL = """
    INSERT INTO Item(code,name,price) VALUES (?,?,?)  
"""

# SQL 명령 실행
 

# 여러 데이터를 한 번에 INSERT
data = [
    ('A345345','국어책','10000'),
    ('A456456','도덕책','5000'),
    ('A567567','기가책','9000')
]

cur.executemany(INSERT_SQL,data)

# 커밋 : INSERT, UPDATE, DELETE 이후엔 커밋을 해야한다
connect_db.commit()

# 데이터베이스 닫기
connect_db.close()