package dev.sample.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/*
 * Entity annotation : '��ü�� ���̺��� ����(mapping)'
 * �ش� class(Book)�� JPA�� �����ϴ� Entity�� �ν��ϰ� ��
 * ������ Table annotation(@Table)�� �������� ������ �ش� Ŭ������ �̸�(book)���� ���̺��� ������
 * 
 * Entity Annotation ���� �� ������ ��
 * 1. �⺻ ������(Default constructor) �ۼ� �ʼ�(JPA�� ��ƼƼ ��ü�� ������ �� �⺻ �����ڸ� Ȱ���ϱ� ������)
 * 2. ���� ������ �ʵ忡 final�� ����ϸ� �ȵ�
 */

//@Table
//@Table(name="BOOKS") // books��� �̸��� ���̺�� ������
@Entity
public class Book {

	/*
	 * JPA�� �⺻ Ű ���� ����(ũ�� 2����) 1. ���� �Ҵ� : �⺻Ű�� ���ø����̼ǿ��� ���� �Ҵ� ex) new Book(1L,
	 * "���ΰ� �ٴ�", "��ֿ���"); 2. �ڵ� ���� : �븮Ű Ȱ��, @GeneratedValue(strategy =
	 * GenerationType. (1) or (2) or (3) ) (1) IDENTITY : �⺻Ű ������ DB���� ����(MySQL��
	 * auto_increment) (2) SEQUENCE : DB�� ������ ����� Ȱ��(Oracle���� �ַ� ���, MySQL�� ������) (3)
	 * TABLE : Ű ������ ������ ���̺� Ȱ��(�������� ���, ��� DB���� ��� ����)
	 * 
	 * -> ���� �Ҵ� ����� ����ϱ� ���ؼ��� @Id�� �ۼ��ϸ� ��
	 * 
	 * �ڵ����� ����� Ȱ���Ϸ��� @Id + @GeneratedValue�� �߰�, ���ϴ� Ű ���� ������ ����.
	 */

	@Id // PK�� ���� ����
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/*
	 * Column annotation : ��ü�� �ʵ�� DB�� �÷� ����
	 */
	@Column(name = "book_name", nullable = false) // bookName �ʵ�� ���ε� DB ���̺��� �÷����� book_name���� ����
	private String bookName; // camelCase(Java) & snake_case(DB column)

	private String author;

	@Temporal(TemporalType.TIMESTAMP) // java.util.date, util.Calendar ������ �� ���
	// TemporalType.DATE : ��¥, DB date Ÿ�԰� ����(ex. 2022-03-03)
	// TemporalType.TIME : �ð�, DB time Ÿ�԰� ����(ex. 09:30:23)
	// TemporalType.TIMESTAMP : ��¥ + �ð�, DB timestamp Ÿ�԰� ����(ex. 2022-03-03
	// 09:53:24)
	private Date pubDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getPubDate() {
		return pubDate;
	}

	public void setPubDate(Date pubDate) {
		this.pubDate = pubDate;
	}

}
