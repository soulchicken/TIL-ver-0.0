-- Student ���̺� DDL
CREATE TABLE STUDENT (
    STUDENT_ID INT(5) unsigned NOT NULL AUTO_INCREMENT,
    MAJOR_ID INT(5) unsigned,
    STUDENT_NAME VARCHAR(20),
    PRIMARY KEY (STUDENT_ID)
);

-- Major ���̺� DDL
CREATE TABLE MAJOR(
    MAJOR_ID INT(5) unsigned NOT NULL AUTO_INCREMENT,
    MAJOR_NAME VARCHAR(20),
    PRIMARY KEY (MAJOR_ID)
);

-- �ܷ�Ű ���� SQL
ALTER TABLE STUDENT
ADD CONSTRAINT FK_STUDENT_MAJOR
FOREIGN KEY (MAJOR_ID)
REFERENCES MAJOR(MAJOR_ID);

-- �а� ������ ����
INSERT INTO MAJOR(MAJOR_NAME) VALUES ("CS"); -- "CS" ��� ���� ������ 1�� ����

-- �� ���� �л� ������ ����, 1�� Major ���̺��� ù ��° id(CS)
INSERT INTO STUDENT(MAJOR_ID, STUDENT_NAME) VALUES (1, "Yoo");
INSERT INTO STUDENT(MAJOR_ID, STUDENT_NAME) VALUES (1, "Kang");

// JOIN SQL���� ��ȸ
SELECT m.*, s.student_name FROM student as s JOIN major as m ON s.major_id = m.major_id;