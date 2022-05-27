package dev.sample;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import dev.sample.model.Book;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("step01");

		// EntityManagerFactory를 통해 EntityManager 객체 생성
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();
			Book book = new Book();
			
			book.setBookName("노르웨이 숲");

			// 등록, em.persist(등록할 entity); list.add(entity);
			em.persist(book); // INSERT INTO Book ~~~~ 내용 날리는 함수

			// 수정 메서드. UPDATE는 없다.
//			book.setBookName("자바의 정석");

			Book findBook = em.find(Book.class, 1L);
			System.out.println(findBook.getBookName());
			
			em.remove(findBook);
			
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
			emf.close();
		}
	}
}
