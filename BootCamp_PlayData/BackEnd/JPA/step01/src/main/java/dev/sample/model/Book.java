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
 * Entity annotation : '객체와 테이블을 맵핑(mapping)'
 * 해당 class(Book)를 JPA가 관리하는 Entity로 인식하게 함
 * 별도의 Table annotation(@Table)을 지정하지 않으면 해당 클래스의 이름(book)으로 테이블이 생성됨
 * 
 * Entity Annotation 적용 시 주의할 점
 * 1. 기본 생성자(Default constructor) 작성 필수(JPA가 엔티티 객체를 생성할 때 기본 생성자를 활용하기 때문에)
 * 2. 값을 저장할 필드에 final을 사용하면 안됨
 */

//@Table
//@Table(name="BOOKS") // books라는 이름의 테이블로 생성됨
@Entity
public class Book {

	/*
	 * JPA의 기본 키 생성 전략(크게 2가지) 1. 직접 할당 : 기본키를 애플리케이션에서 직접 할당 ex) new Book(1L,
	 * "노인과 바다", "헤밍웨이"); 2. 자동 생성 : 대리키 활용, @GeneratedValue(strategy =
	 * GenerationType. (1) or (2) or (3) ) (1) IDENTITY : 기본키 생성을 DB한테 위임(MySQL의
	 * auto_increment) (2) SEQUENCE : DB의 시퀀스 기능을 활용(Oracle에서 주로 사용, MySQL은 미지원) (3)
	 * TABLE : 키 생성용 별도의 테이블 활용(시퀀스와 비슷, 모든 DB에서 사용 가능)
	 * 
	 * -> 직접 할당 방식을 사용하기 위해서는 @Id만 작성하면 됨
	 * 
	 * 자동생성 방식을 활용하려면 @Id + @GeneratedValue를 추가, 원하는 키 생성 전략을 선택.
	 */

	@Id // PK로 맵핑 설정
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/*
	 * Column annotation : 객체의 필드와 DB의 컬럼 맵핑
	 */
	@Column(name = "book_name", nullable = false) // bookName 필드와 맵핑될 DB 테이블의 컬럼명을 book_name으로 지정
	private String bookName; // camelCase(Java) & snake_case(DB column)

	private String author;

	@Temporal(TemporalType.TIMESTAMP) // java.util.date, util.Calendar 맵핑할 때 사용
	// TemporalType.DATE : 날짜, DB date 타입과 맵핑(ex. 2022-03-03)
	// TemporalType.TIME : 시간, DB time 타입과 맵핑(ex. 09:30:23)
	// TemporalType.TIMESTAMP : 날짜 + 시간, DB timestamp 타입과 맵핑(ex. 2022-03-03
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
